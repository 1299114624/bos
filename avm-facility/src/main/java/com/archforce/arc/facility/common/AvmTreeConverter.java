package com.archforce.arc.facility.common;

public interface AvmTreeConverter {

    /**
     * 实体类需要实现这个方法才能使用 TreeUtils 里面的方法
     * @return
     */
    AvmTree toAvmTree();
}
