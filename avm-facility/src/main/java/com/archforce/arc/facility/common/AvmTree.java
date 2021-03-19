package com.archforce.arc.facility.common;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AvmTree<T> {
    private Integer id;
    private String parentCode;
    private String name;
    private String code;
    private Integer type; // 0标准产品，1客制产品
    private T node;
    private List<AvmTree> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public T getNode() {
        return node;
    }

    public void setNode(T node) {
        this.node = node;
    }


    public List<AvmTree> getChildren() {
        return children;
    }

    /**
     * TreeUtils 把List转为AvmTree时使用
     * @param children
     */
    public void setChildren(List<AvmTree> children) {
        if (children == null || children.size() == 0) return;
        this.children = children;
    }

    /**
     * 往数据库增一条数据时使用，同时设置 parentCode
     * @param avmTree
     */
    public void addChildren(AvmTree<T> avmTree) {
        if (children == null) {
            children = new ArrayList<>();
        }
        if (avmTree != null) {
            children.add(avmTree);
            avmTree.setParentCode(this.getCode());
        }
    }

    public boolean isRoot() {
        return "0".equals(this.getParentCode());
    }

    @JsonIgnore
    public List<AvmTree> getAllAvmTrees() {
        List<AvmTree> allNodes = new ArrayList<>();
        if (this.getNode() != null) {
            allNodes.add(this);
        }
        List<AvmTree> children = this.getChildren();
        if(children != null && children.size() > 0) {
            for (AvmTree avmTree : children) {
                allNodes.addAll(avmTree.getAllAvmTrees());
            }
        }
        return allNodes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AvmTree test = (AvmTree) o;
        return Objects.equals(code, test.code);
    }
}
