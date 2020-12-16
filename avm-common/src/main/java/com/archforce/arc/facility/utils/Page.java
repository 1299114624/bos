package com.archforce.arc.facility.utils;

public class Page {

    public final static Integer DEFAULT_PAGESIZE = 15;

    public final static Integer DEFAULT_PAGENUMBER = 1;

    /**
     * 增加分页最大值
     */
    public final static Integer DEFAULT_PAGENUMBER_MAX = 100000;

    public final static Integer UN_LIMIT_PAGE = -1;

    /**
     * 每页最大值
     */
    public static int MAX_PAGESIZE = 10000;

    /**
     * 页面大小
     */
    private Integer pageSize;

    /**
     * 当前页，从1开始
     */
    private Integer pageNumber;

    /**
     * 当前页，从1开始
     */
    private Integer current;

    /**
     * 导出时第一页记录的总记录数
     */
    private Long exportTotalCount;

    public Page() {
        this.pageNumber = null;
        this.pageSize = DEFAULT_PAGESIZE;
    }

    public Page(Integer pageSize, Integer pageNumber) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageSize=" + pageSize +
                ", pageNumber=" + pageNumber +
                "}";
    }

    public Long getExportTotalCount() {
        return exportTotalCount;
    }

    public void setExportTotalCount(Long exportTotalCount) {
        this.exportTotalCount = exportTotalCount;
    }
}
