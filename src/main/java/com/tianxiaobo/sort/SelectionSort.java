package com.tianxiaobo.sort;

import static com.tianxiaobo.Util.less;
import static com.tianxiaobo.Util.swap;

/**
 * 选择排序
 *
 * @author Tian XiaoBo
 * @date 2018-09-13
 */
public class SelectionSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public T[] sort(T[] elements) {
        for (int i = 0; i < elements.length; i++) {
            int min = i;
            for (int j = i + 1; j < elements.length; j++) {
                if (less(elements[j], elements[min])) {
                    min = j;
                }
            }

            if (min != i) {
                swap(elements, i, min);
            }
        }

        return elements;
    }
}