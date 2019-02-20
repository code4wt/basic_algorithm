package com.tianxiaobo.sort;

import static com.tianxiaobo.Util.less;
import static com.tianxiaobo.Util.swap;

/**
 * 冒泡排序优化版
 *
 * @author Tian XiaoBo
 * @date 2018-09-13 13:15:47
 */
public class OptimizedBubbleSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public T[] sort(T[] elements) {
        int len = elements.length;
        boolean sorted = false;
        for (int i = 0; i < len && !sorted; i++) {
            for (int j = 1; j < len - i; j++) {
                sorted = true;
                if (less(elements[j], elements[j - 1])) {
                    swap(elements, j - 1, j);
                    sorted = false;
                }
            }
        }
        return elements;
    }
}
