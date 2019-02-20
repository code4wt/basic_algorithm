package com.tianxiaobo.sort;

import static com.tianxiaobo.Util.less;

/**
 * 冒泡排序
 *
 * @author Tian XiaoBo
 * @date 2018-09-13
 */
public class MergeSort<T extends Comparable<T>> implements Sort<T> {

    private T[] arr;

    @Override
    public T[] sort(T[] elements) {
        arr = (T[]) new Comparable[elements.length];
        sort(elements, 0, elements.length - 1);
        return elements;
    }

    private void sort(T[] elements, int lo, int hi) {
        if (hi == lo) {
            return;
        }

        int mid = (hi + lo) / 2;
        sort(elements, lo, mid);
        sort(elements, mid + 1, hi);
        merge(elements, lo, mid, hi);
    }

    private void merge(T[] elements, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            arr[k] = elements[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                elements[k] = arr[j++];
            } else if (j > hi) {
                elements[k] = arr[i++];
            } else if (less(arr[i], arr[j])) {
                elements[k] = arr[i++];
            } else {
                elements[k] = arr[j++];
            }
        }
    }
}
