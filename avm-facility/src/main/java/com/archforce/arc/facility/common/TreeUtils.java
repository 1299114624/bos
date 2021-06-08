package com.archforce.arc.facility.common;

import java.util.*;
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
        Map<String, List<AvmTree>> childrenMap = new HashMap<>();
        for (AvmTree tree : list) {
            if (rootCodes == null || (rootCodes != null && rootCodes.length == 0)) {
                if (tree.isRoot()) {
                    roots.add(tree);
                }
            }
            if (rootCodes != null) {
                if (isContain(tree.getCode(), rootCodes)) {
                    roots.add(tree);
                }
            }
            List<AvmTree> ch = childrenMap.get(tree.getParentCode());
            if (ch == null) {
                ch = new ArrayList<>();
                childrenMap.put(tree.getParentCode(), ch);
            }
            ch.add(tree);
        }
        for (AvmTree tree : list) {
            tree.setChildren(childrenMap.get(tree.getCode()));
        }
        return roots;
    }

    /**
     * 从 list 找出 leaves 节点的所有父节点一直到根节点形成一个新的集合
     * @param list 所有树节点的集合
     * @param leaves 需要展示的树节点集合
     * @return
     */
    public static List<AvmTree> filterLeafTree(List<AvmTree> list, List<AvmTree> leaves) {
        Set<AvmTree> pList = new HashSet<>();
        Map<String, AvmTree> idMap = new HashMap<>();
        for (AvmTree tree : list) {
            idMap.put(tree.getCode(), tree);
        }

        Set<AvmTree> parentList = new HashSet<>();
        for (AvmTree leaf : leaves) {
            parentList.add(leaf);
            parentList.addAll(getParentList(idMap, leaf));
        }

        pList.addAll(parentList);
        return new ArrayList<>(pList);
    }

    /**
     * 递归获取父亲节点
     * @param idMap
     * @param leaf
     * @return
     */
    private static Set<AvmTree> getParentList(Map<String, AvmTree> idMap, AvmTree leaf) {
        Set<AvmTree> pSet = new HashSet<>();
        if (leaf == null || leaf.isRoot()) {
            return pSet;
        } else {
            AvmTree p = idMap.get(leaf.getParentCode());
            if (p != null) {
                pSet.add(p);
                pSet.addAll(getParentList(idMap, p));
            }
            return pSet;
        }
    }

    public static List<AvmTree> filterLeafTree(List<? extends AvmTreeConverter> list, List<? extends AvmTreeConverter> leaves, Boolean bool) {
        List<AvmTree> listNodes = list.stream().map(node -> node.toAvmTree()).collect(Collectors.toList());
        List<AvmTree> leafNodes = leaves.stream().map(node -> node.toAvmTree()).collect(Collectors.toList());
        return filterLeafTree(listNodes, leafNodes);
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

    /**
     * 将两个实现了 AvmTreeConverter 的List合并后生成树结构
     * @param firstList
     * @param secondList
     * @return
     */
    public static List<AvmTree> treeCombine (List<? extends AvmTreeConverter> firstList, List<? extends AvmTreeConverter> secondList) {
        List<AvmTree> firstAvmList = firstList.stream().map(node -> node.toAvmTree()).collect(Collectors.toList());
        List<AvmTree> secondAvmList = secondList.stream().map(node -> node.toAvmTree()).collect(Collectors.toList());
        firstAvmList.addAll(secondAvmList);
        return listToTree(firstAvmList);
    }

    /**
     * 匹配 rootCodes 是否含有 str
     * @param str
     * @param rootCodes
     * @return
     */
    private static boolean isContain(String str, String... rootCodes) {
        if (rootCodes == null) {
            return false;
        }
        return Arrays.stream(rootCodes).anyMatch(rootCode -> rootCode.equals(str));
    }
}
