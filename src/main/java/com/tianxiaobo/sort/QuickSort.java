package com.tianxiaobo.sort;

import static com.tianxiaobo.Util.less;
import static com.tianxiaobo.Util.swap;

import java.util.ArrayList;
import java.util.List;

/**
 * 冒泡排序
 *
 * @author Tian XiaoBo
 * @date 2018-09-13
 */
public class QuickSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public T[] sort(T[] elements) {
        sort(elements, 0, elements.length - 1);
        return elements;
    }

    private List<T> sort(List<T> elements) {
        int len = elements.size();
        if (len < 2) {
            return elements;
        }

        T pivot = elements.get(0);
        List<T> l = new ArrayList<>(len);
        List<T> g = new ArrayList<>(len);
        for (int i = 1; i < len; i++) {
            T ele = elements.get(i);
            if (less(ele, pivot)) {
                l.add(ele);
            } else {
                g.add(ele);
            }
        }

        List<T> sorted = new ArrayList<>(len);
        sorted.addAll(sort(l));
        sorted.add(pivot);
        sorted.addAll(sort(g));
        return sorted;
    }

    private void sort(T[] elements, int low, int high) {
        if (high <= low) {
            return;
        }

        int j = partition(elements, low, high);
        sort(elements, low, j - 1);
        sort(elements, j + 1, high);
    }

    private int partition(T[] elements, int low, int high) {
        T pivot = elements[low];
        int i = low, j = high + 1;
        while (true) {
            while (less(elements[++i], pivot)) {
                if (i == high) {
                    break;
                }
            }
            while (less(pivot, elements[--j])) {
                if (j == low) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            swap(elements, i, j);
        }

        swap(elements, low, j);
        return j;
    }
}
