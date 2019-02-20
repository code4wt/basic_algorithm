package com.tianxiaobo.sort;

import static com.tianxiaobo.Util.less;
import static com.tianxiaobo.Util.swap;

/**
 * 冒泡排序
 *
 * @author Tian XiaoBo
 * @date 2018-09-13
 */
public class BubbleSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public T[] sort(T[] elements) {
        int len = elements.length;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < len - i; j++) {
                if (less(elements[j], elements[j - 1])) {
                    swap(elements, j - 1, j);
                }
            }
        }
        return elements;
    }
}
