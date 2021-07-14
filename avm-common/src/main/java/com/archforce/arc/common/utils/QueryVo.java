package com.archforce.arc.common.utils;

import com.archforce.arc.common.exception.ApplicationException;
import com.github.pagehelper.PageHelper;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

public class QueryVo<T> {

    private T matchFields;
    private T query;
    private Page page;
    private Sort sort;

    public QueryVo() {

    }

    public QueryVo(T query) {
        this.query = query;
    }

    public QueryVo(T query, Page page, Sort sort) {
        this.query = query;
        this.page = page;
        this.sort = sort;
    }

    public T getMatchFields() {
        return matchFields;
    }

    public void setMatchFields(T matchFields) {
        this.matchFields = matchFields;
    }

    public T getQuery() {
        return query;
    }

    public void setQuery(T query) {
        this.query = query;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public static String getSortTableFiled(String sortKey) {
        if (StringUtils.isEmpty(sortKey)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < sortKey.length(); i++) {
            if (Character.isUpperCase(sortKey.charAt(i))) {
                sb.append("_");
            }
            sb.append(sortKey.charAt(i));
        }
        return sb.toString().toLowerCase();
    }

    private static boolean validateSort(String sortKey) {
        String pattern = "^[a-z|0-9|A-Z|_]+$";
        return sortKey.matches(pattern);
    }

    public void resetSort() {
        if (sort == null || sort.getKey().equals("id")) {
            return;
        }
        if (!validateSort(sort.getKey())) {
            throw new ApplicationException("排序字段存在不合法的字符");
        }
        String sortInfo = getSortTableFiled(sort.getKey()) + " " + sort.getSortType().name();
        PageHelper.orderBy(sortInfo);
    }

    public void resetSort(List<Sort> sortList) {
        if (CollectionUtils.isEmpty(sortList)) {
            return;
        }
        StringBuffer sb = new StringBuffer();
        for (Sort sort : sortList) {
            if (sort == null || sort.getKey().equals("id")) {
                continue;
            }
            if (org.apache.commons.lang.StringUtils.isBlank(sort.getKey())) {
                continue;
            }
            if (sort.getSortType() == null) {
                sort.setSortType(SortType.DESC);
            }
            String sortInfo = getSortTableFiled(sort.getKey()) + " " + sort.getSortType().name();
            if (org.apache.commons.lang.StringUtils.isNotBlank(sortInfo)) {
                sb.append(sortInfo).append(",");
            }
        }
        String sortInfo = org.apache.commons.lang.StringUtils.substringBeforeLast(sb.toString(),",");
        if (org.apache.commons.lang.StringUtils.isBlank(sortInfo)) {
            return;
        }
        PageHelper.orderBy(sortInfo);
    }

    public void resetPage() {
        QueryVo queryVo = this;
        resetPage(queryVo);
    }

    public static void resetPage(QueryVo queryVo) {
        if (queryVo == null) {
            queryVo = new QueryVo();
        }
        Page page = queryVo.getPage();
        if (queryVo.getPage() == null) {
            page = new Page();
            page.setCurrent(0);
            page.setPageSize(0);
            page.setPageNumber(0);
            queryVo.setPage(page);
        }
        limitPageSize(page);
        if (queryVo.matchFields != null) {
            queryVo.query = queryVo.matchFields;
        }
        if (page == null || page.UN_LIMIT_PAGE.equals(page.getPageNumber()) || page.UN_LIMIT_PAGE.equals(page.getCurrent())) {
            if (page == null) {
                page = new Page();
            }
            page.setPageNumber(page.DEFAULT_PAGENUMBER);
            page.setPageSize(page.DEFAULT_PAGENUMBER_MAX);
        }
        if (page.getPageNumber() == null) {
            page.setPageNumber(page.getCurrent());
        }
        if (page.getPageNumber() == null) {
            page.setPageNumber(page.DEFAULT_PAGENUMBER);
        }
        PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    }

    /**
     * 限制每页的最大值，如果超过Page.MAX_PAGESIZE，则设置为Page.MAX_PAGESIZE
     * @param page
     */
    private static void limitPageSize(Page page) {
        if (Page.MAX_PAGESIZE > 0 && page != null) {
            Integer pageSize = page.getPageSize();
            if (pageSize > Page.MAX_PAGESIZE) {
                page.setPageSize(Page.MAX_PAGESIZE);
            }
        }
    }

    public static void resetData(QueryVo queryVo) {
        if (queryVo == null) {
            queryVo = new QueryVo();
        }
        if (queryVo.matchFields != null) {
            queryVo.query = queryVo.matchFields;
        }
    }
}
