package com.tianxiaobo.sort;

import static com.tianxiaobo.Util.less;
import static com.tianxiaobo.Util.swap;

/**
 * InsertSort
 *
 * @author Tian XiaoBo
 * @date 2018-09-14 17:29:17
 */
public class InsertionSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public T[] sort(T[] elements) {
        for (int i = 1; i < elements.length; i++) {
            for (int j = i; j > 0 && less(elements[j], elements[j - 1]); j--) {
                swap(elements, j, j - 1);
            }
        }
        return elements;
    }
}
