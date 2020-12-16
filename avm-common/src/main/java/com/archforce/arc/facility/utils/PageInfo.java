package com.archforce.arc.facility.utils;

import com.github.pagehelper.Page;

import java.util.List;

public class PageInfo<T> {
    /**
     * 页面大小
     */
    private Integer pageSize;

    /**
     * 当前页，从1开始
     */
    private Integer pageNumber;

    /**
     * 总记录
     */
    private Long total;

    /**
     * 总页数
     */
    private Integer totalPage;

    /**
     * 结果
     */
    private List<T> list;

    public static PageInfo getPageInfo(Page originPage) {
        PageInfo newEntity = new PageInfo();
        newEntity.list = originPage.getResult();
        newEntity.pageNumber = originPage.getPageNum();
        newEntity.pageSize = originPage.getPageSize();
        newEntity.total = originPage.getTotal();
        newEntity.totalPage = originPage.getPages();
        return newEntity;
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

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
