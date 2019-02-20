package com.tianxiaobo.sort;

import static com.tianxiaobo.Util.less;
import static com.tianxiaobo.Util.swap;

import java.util.Arrays;

/**
 * InsertSort
 *
 * @author Tian XiaoBo
 * @date 2018-09-14 17:29:17
 */
public class OptimizedInsertionSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public T[] sort(T[] elements) {
        for (int i = 1; i < elements.length; i++) {
            T sentinel = elements[i];
            int j = i;
            for ( ; j > 0 && less(sentinel, elements[j - 1]); j--) {
                elements[j] = elements[j - 1];
            }
            elements[j] = sentinel;
        }
        return elements;
    }
}
