package com.tianxiaobo.misc;

import static com.tianxiaobo.Util.less;
import static com.tianxiaobo.Util.swap;

/**
 * MaxHeap
 *
 * @author Tian XiaoBo
 * @date 2019-02-19 12:50:52
 */
public class MaxHeap<T extends Comparable<T>> {

    private T[] heap;

    private int N;

    public MaxHeap(int len) {
        heap = (T[]) new Comparable[len + 1];
    }

    public void insert(T t) {
        heap[++N] = t;
        swim(N);
    }

    public void insertAll(T[] ts) {
        for (T t : ts) {
            insert(t);
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public T delMax() {
        T max = heap[1];
        heap[1] = heap[N--];
        heap[N + 1] = null;
        sink(1);
        return max;
    }

    private void sink(int n) {
        while (2 * n <= N) {
            int p = 2 * n;
            if (p < N && less(heap[p], heap[p + 1])) {
                p++;
            }
            if (!less(heap[n], heap[p])) {
                break;
            }

            swap(heap, n, p);
            n = p;
        }
    }

    private void swim(int n) {
        while (n > 1 && less(heap[n / 2], heap[n])) {
            swap(heap, n / 2, n);
            n /= 2;
        }
    }

    public static void main(String[] args) {
        MaxHeap<Integer> heap = new MaxHeap<>(10);
        Integer[] nums = {3, 6, 1, 9, 6, 2, 7, 0, 8, 4};
        for (Integer num : nums) {
            heap.insert(num);
        }

        while (!heap.isEmpty()) {
            System.out.println(heap.delMax());
        }
    }
}
