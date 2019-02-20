package com.tianxiaobo.sort;

import static com.tianxiaobo.Util.less;
import static com.tianxiaobo.Util.swap;

/**
 * ShellSort
 *
 * @author Tian XiaoBo
 * @date 2018-09-14 21:15:52
 */
public class ShellSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public T[] sort(T[] elements) {
        int len = elements.length;
        int h = 1;
        while (h < len / 3) {
            h = h * 3 + 1;
        }

        while (h >= 1) {
            for (int i = h; i < len; i++) {
                for (int j = i; j >= h && less(elements[j], elements[j - h]); j -= h) {
                    swap(elements, j, j - h);
                }
            }

            h /= 3;
        }
        return elements;
    }
}
