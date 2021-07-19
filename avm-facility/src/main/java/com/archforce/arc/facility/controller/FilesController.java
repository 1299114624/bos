package com.archforce.arc.facility.controller;

import com.archforce.arc.common.exception.ApplicationException;
import com.archforce.arc.common.log.LogUtils;
import com.archforce.arc.facility.entity.common.Files;
import com.archforce.arc.facility.mapper.avm.FilesMapper;
import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 文件服务rest
 * 此处的接口无需配置在resource中，只做登录拦截
 */
@RestController
@RequestMapping("/files")
public class FilesController {
    @Value("${upload-dir}")
    private String uploadDir;

    // 默认支持所有格式
    @Value("${support-ext-names:#{''}}")
    private String supportExts;

    @Autowired
    private FilesMapper filesMapper;

    /**
     * 文件下载
     * 此处的接口无需配置在resource中，只做登录拦截
     * @param response
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public Files upload(HttpServletResponse response, @RequestParam("file") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        long size = file.getSize();
        final int index = fileName.lastIndexOf('.');
        String extFileName = "";
        if (index == -1) {
            throw new ApplicationException("上传文件异常：不支持没有后缀文件" + fileName);
        } else {
            extFileName = fileName.substring(fileName.lastIndexOf('.'), fileName.length());
        }
        if (!satisfyExtFiles(supportExts, extFileName)) {
            returnSupportFile(response, fileName);
        }
        try {
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            String fileCode = UUID.randomUUID().toString();
            String filePath = uploadDir + fileCode + extFileName;
            OutputStream ops = new FileOutputStream(filePath);
            StreamUtils.copy(file.getInputStream(), ops);
            ops.close();
            Files f = new Files();
            f.setFileCode(fileCode);
            f.setFilePath(filePath);
            f.setFileName(fileName);
            f.setFileSize(size);
            f.setFileType(extFileName);
            f.setFileUploadtime(new Date());
            filesMapper.insert(f);
            return f;
        } catch (Exception e) {
            LogUtils.error(this.getClass(), "文件服务", "文件上传异常", e);
            throw new ApplicationException("文件上传异常：" + fileName);
        }
    }

    /**
     * 文件下载
     * 此处的接口无需配置在resource中，只做登录拦截
     * @param id
     * @param response
     */
    @GetMapping("/down/{id}")
    public void downLoad(@PathVariable Integer id, HttpServletResponse response) {
        Files info = filesMapper.selectByPrimaryKey(id);
        if (info != null) {
            String fileName = info.getFileName();
            String name = "";
            try {
                name = new String(fileName.getBytes(Charset.forName("UTF-8")), "iso-8859-1");
            } catch (UnsupportedEncodingException e) {
                LogUtils.error(FilesController.class, "文件服务", "文件下载异常", e);
            }
            response.setHeader("content-Type", "application/octet-stream");
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename="+name);
            try {
                OutputStream outputStream = response.getOutputStream();
                String filePath = info.getFilePath();
                FileInputStream inputStream = new FileInputStream(filePath);
                StreamUtils.copy(inputStream, outputStream);
            } catch (IOException e) {
                LogUtils.error(FilesController.class, "文件服务", "文件下载异常", e);
                throw new ApplicationException("文件下载异常：" + fileName);
            }
        }
    }

    private boolean satisfyExtFiles(String supportExts, String extFileName) {
        extFileName = extFileName.substring(1);
        if (StringUtils.isNotEmpty(supportExts)) {
            List<String> supportFiles = Lists.newArrayList(supportExts.split("\\|"));
            if (!supportFiles.contains(extFileName)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 返回支持的文件格式
     * @param response
     * @param fileName
     */
    private void returnSupportFile(HttpServletResponse response, String fileName) {
        response.setStatus(415);
        try {
            String[] exts = supportExts.split("\\|");
            response.setContentType("text/plain;charset=UTF-8");
            response.getWriter().append("上传的文件格式仅支持"+String.join("、",exts)).flush();
        } catch (IOException e) {
            throw new ApplicationException("上传文件异常："+fileName);
        }
    }
}
