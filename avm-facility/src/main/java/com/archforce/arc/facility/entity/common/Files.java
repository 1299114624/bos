package com.archforce.arc.facility.entity.common;

import java.io.Serializable;
import java.util.Date;

public class Files implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
    * id
    */
    private Integer id;

    /**
    * 文件名称
    */
    private String fileName;

    /**
    * 文件路径
    */
    private String filePath;

    /**
    * 文件大小
    */
    private Long fileSize;

    /**
    * 文件类别（文件后缀）
    */
    private String fileType;

    private Date fileUploadtime;

    /**
    * 通用唯一识别码（32位）
    */
    private String fileCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Date getFileUploadtime() {
        return fileUploadtime;
    }

    public void setFileUploadtime(Date fileUploadtime) {
        this.fileUploadtime = fileUploadtime;
    }

    public String getFileCode() {
        return fileCode;
    }

    public void setFileCode(String fileCode) {
        this.fileCode = fileCode;
    }
}