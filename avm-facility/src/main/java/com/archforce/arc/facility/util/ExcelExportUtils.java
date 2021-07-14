package com.archforce.arc.facility.util;

import com.archforce.arc.common.log.LogUtils;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class ExcelExportUtils {

    public static void excelExport(Map<String, Object> data, InputStream inputStream, OutputStream outputStream) {
        XLSTransformer transformer = new XLSTransformer();
        try {
            Workbook workbook = transformer.transformXLS(inputStream, data);
            workbook.write(outputStream);
        } catch (InvalidFormatException | IOException e) {
            LogUtils.error(ExcelExportUtils.class, "导出表格基础类报错","表格导出报错",e);
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    LogUtils.error(ExcelExportUtils.class, "导出表格基础类报错","表格导出报错",e);
                }
            }
            if (null != outputStream) {
                try {
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    LogUtils.error(ExcelExportUtils.class, "导出表格基础类报错","表格导出报错",e);
                }
            }
        }
    }

    public static void excelExport(String fileName, Map<String, Object> data, InputStream inputStream, HttpServletResponse response) {
        response.reset();
        response.setContentType("application/octet-stream;charset=UTF-8");
        try {
            response.setHeader("Content-Disposition","attachment;filename=\""+ URLEncoder.encode(fileName,"UTF-8")+"\"");
        } catch (UnsupportedEncodingException e) {
            LogUtils.error(ExcelExportUtils.class, "导出表格基础类报错","表格导出报错",e);
        }
        try {
            OutputStream outputStream = response.getOutputStream();
            excelExport(data, inputStream, outputStream);
        } catch (IOException e) {
            LogUtils.error(ExcelExportUtils.class, "导出表格基础类报错","表格导出报错",e);
        }
    }
}
