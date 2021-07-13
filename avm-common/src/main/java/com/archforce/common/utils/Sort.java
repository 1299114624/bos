package com.archforce.common.utils;

public class Sort {

    private String key;

    private SortType sortType;

    public Sort() {

    }

    public Sort(String key, SortType sortType) {
        this.key = key;
        this.sortType = sortType;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public SortType getSortType() {
        return sortType;
    }

    public void setSortType(SortType sortType) {
        this.sortType = sortType;
    }

    @Override
    public String toString() {
        return "Sort{" +
                "Key='" + key + '\'' +
                ", sortType=" + sortType +
                '}';
    }
}
