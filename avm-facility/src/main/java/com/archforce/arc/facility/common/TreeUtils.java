package com.archforce.arc.facility.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TreeUtils {
    /**
     * 将 list 转换成树结构
     * 实现逻辑：
     * 1.初始化 AvmTree 的 children 属性
     * 2.最后返回根节点的集合
     * @param list
     * @param rootCodes
     * @return 只包含根节点
     */
    public static List<AvmTree> listToTree(List<AvmTree> list, String... rootCodes) {
        List<AvmTree> roots = new ArrayList<>();
        return roots;
    }

    /**
     * 从 list 找出 leaves 节点的所有父节点一直到根节点形成一个新的集合
     * @param list 所有树节点的集合
     * @param leaves 需要展示的树节点集合
     * @return
     */
    public static List<AvmTree> getTreeList(List<AvmTree> list, List<AvmTree> leaves) {
        Set<AvmTree> pList = new HashSet<>();
        return new ArrayList<>(pList);
    }



    /**
     * 将 allNodes 转换成树结构，并返回所有的根节点
     * 1.allNodes 必须存在根节点
     * @param allNodes
     * @return
     */
    public static List<AvmTree> tree (List<? extends AvmTreeConverter> allNodes) {
        return listToTree(allNodes.stream().map(node -> node.toAvmTree()).collect(Collectors.toList()));
    }

    /**
     * 将 allNodes 转换成树结构，并返回所有的根节点
     * 1.allNodes 必须存在根节点
     * 2.可以传入自己指定的根节点的 code（指定树的根节点）
     * @param allNodes
     * @param rootCodes
     * @return
     */
    public static List<AvmTree> tree (List<? extends AvmTreeConverter> allNodes, String... rootCodes) {
        return listToTree(allNodes.stream().map(node -> node.toAvmTree()).collect(Collectors.toList()), rootCodes);
    }
}
