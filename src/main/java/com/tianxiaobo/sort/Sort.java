package com.tianxiaobo.sort;

/**
 * Sort
 *
 * @author Tian XiaoBo
 * @date 2018-09-13 12:28:39
 */
public interface Sort<T extends Comparable<T>> {

    /**
     * 排序接口
     * @param elements
     * @return
     */
    T[] sort(T[] elements);
}
