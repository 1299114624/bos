package com.archforce.arc.facility.util;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import static org.apache.poi.ss.usermodel.CellType.STRING;

public class ExcelUtils {
    private static final String XLSX_SUFFIX = "xlsx";


    /**
     * excel 转 json字符串
     */
    public static List<Map<String, String>> parseExcel(File file) throws IOException {
        // 根据Excel构成的对象
        Workbook wb;
        DataFormat dataFormat;
        // 如果是2007及以上版本，则使用想要的Workbook以及CellStyle
        FileInputStream inputStream = new FileInputStream(file);
        if (file.getName().endsWith(XLSX_SUFFIX)) {
            wb = new XSSFWorkbook(inputStream);
            dataFormat = wb.createDataFormat();
        } else {
            POIFSFileSystem fs = new POIFSFileSystem(inputStream);
            wb = new HSSFWorkbook(fs);
            dataFormat = wb.createDataFormat();
        }
        // Excel列的样式，主要是为了解决Excel数字科学计数的问题
        CellStyle cellStyle = wb.createCellStyle();
        // 设置Excel列的样式为文本
        cellStyle.setDataFormat(dataFormat.getFormat("@"));
        Sheet sheet = wb.getSheetAt(0);
        String[] cellNames = getCellNames(cellStyle, sheet);
        if (cellNames == null) {
            return null;
        }
        return getDataList(cellStyle, sheet, cellNames);
    }

    /**
     * 获取列名数组
     * @param cellStyle
     * @param sheet
     * @return
     */
    private static String[] getCellNames(CellStyle cellStyle, Sheet sheet) {
        // 取第一行列的值作为key
        Row firstRow = sheet.getRow(1);
        // 如果第一行就为空，则是空sheet表，该表跳过
        if (null == firstRow) {
            return null;
        }
        // 得到第一行有多少列
        int curCellNum = firstRow.getLastCellNum();
        // 根据第一行的列数来生成列头数组
        String[] cellNames = new String[curCellNum];
        // 单独处理第一行，取出第一行的每个列值放在数组中，就得到了整张表的JSON的key
        for (int m = 0; m <curCellNum; m++) {
            Cell cell = firstRow.getCell(m);
            cellNames[m] = getCellValue(cell);
        }
        return cellNames;
    }

    /**
     * 获取Cell值
     * @param cell
     * @return
     */
    private static String getCellValue(Cell cell) {
        String cellValue = "";
        if (null == cell) {
            return cellValue;
        }
        if (NUMERIC == cell.getCellTypeEnum()) {
            cell.setCellType(STRING);
        }

        switch (cell.getCellTypeEnum()) {
            case NUMERIC:
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                    cellValue = format.format(cell.getNumericCellValue());
                } else {
                    cellValue = String.valueOf(cell.getNumericCellValue());
                }
                break;
            case STRING:
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case FORMULA:
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case BLANK:
                cellValue = "";
                break;
            case ERROR:
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }

        return cellValue;
    }

    /**
     * 获取每一行的对应记录map
     * @param cellStyle
     * @param sheet
     * @param cellNames 列名
     * @param j 行号
     * @return
     */
    private static Map<String, String> getEachLineMap(CellStyle cellStyle, Sheet sheet, String[] cellNames, int j) {
        // 一行数据对于一个Map
        Map<String, String> rowMap = new LinkedHashMap<>();
        // 取得某一行
        Row row = sheet.getRow(j);
        if (row == null) {
            return null;
        }
        int cellNum = row.getLastCellNum();
        // 遍历每一遍
        for (int k = 0; k < cellNum; k++) {
            Cell cell = row.getCell(k);
            if (null != cell && cell.getCellType() != Cell.CELL_TYPE_BLANK) {
                cell.setCellStyle(cellStyle);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                // 保存该单元格的数据到该行中
                rowMap.put(cellNames[k], cell.getStringCellValue().trim());
            }
        }
        return rowMap;
    }

    /**
     * 获取excel数据集合
     * @param cellStyle
     * @param s
     * @param cellNames
     * @return
     */
    public static List<Map<String, String>> getDataList(CellStyle cellStyle, Sheet sheet , String[] cellNames) {
        // 从第三行起遍历每一行
        int rowNum = sheet.getLastRowNum();
        // 一个sheet表对应一个List
        List<Map<String, String>> list = new ArrayList<>();
        for (int j = 2; j <= rowNum; j++) {
            Map<String, String> rowMap = getEachLineMap(cellStyle, sheet, cellNames, j);
            if (!CollectionUtils.isEmpty(rowMap)) {
                // 保存改行的数据到该表的List中
                list.add(rowMap);
            }
        }
        return list;
    }
}
