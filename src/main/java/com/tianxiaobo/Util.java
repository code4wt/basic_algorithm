package com.tianxiaobo;

/**
 * Util
 *
 * @author Tian XiaoBo
 * @date 2018-09-13 13:06:14
 */
public class Util {

    public static void swap(Object[] a, int i, int j) {
        Object tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static <T extends Comparable<T>> boolean isSorted(T[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i - 1]) < 0) {
                return false;
            }
        }

        return true;
    }

    public static <T extends Comparable<T>> boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }
}
