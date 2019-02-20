package com.tianxiaobo.sort;

import com.tianxiaobo.misc.MaxHeap;

/**
 * HeapSort
 *
 * @author Tian XiaoBo
 * @date 2018-09-15 08:54:20
 */
public class HeapSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public T[] sort(T[] elements) {
        MaxHeap<T> heap = new MaxHeap<>(elements.length);
        heap.insertAll(elements);
        for (int i = elements.length - 1; i >= 0; i--) {
            elements[i] = heap.delMax();
        }
        return elements;
    }
}
