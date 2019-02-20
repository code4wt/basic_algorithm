package com.tianxiaobo.search;

/**
 * BinarySearch
 *
 * @author Tian XiaoBo
 * @date 2018-09-15 08:57:04
 */
public class BinarySearch {

    public static <T extends Comparable<T>> T search(T[] items, T target) {
        if (items == null || items.length == 0) {
            return null;
        }

        int low = 0, high = items.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            int cmp = items[mid].compareTo(target);
            if (cmp == 0) {
                return items[mid];
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return null;
    }

    public static <T extends Comparable<T>> T search(T[] items, T target, int lo, int hi) {
        if (items == null || items.length == 0) {
            return null;
        }

        if (lo <= hi) {
            int mid = (hi + lo) / 2;
            int cmp = items[mid].compareTo(target);
            if (cmp == 0) {
                return items[mid];
            } else if (cmp > 0) {
                return search(items, target, lo, mid - 1);
            } else {
                return search(items, target, mid + 1, hi);
            }
        }

        return null;
    }
}
