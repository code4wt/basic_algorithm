package com.tianxiaobo.sort;

import com.tianxiaobo.Util;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 * InsertionSortTest
 *
 * @author Tian ZhongBo
 * @date 2018-09-14 18:05:23
 */
public class OptimizedInsertionSortTest {

    @Test
    public void sort() throws Exception {
        Sort<Integer> insertionSort = new OptimizedInsertionSort<>();
        Integer[] nums = insertionSort.sort(new Integer[]{1, 3, 8, 0, 7, 2, 9, 2});
        Integer[] nums1 = insertionSort.sort(new Integer[]{1, 3, 8, 10, 29, 21, 30, 50, 22, 75, 0, 7, 2, 9, 2});
        Assert.assertTrue(Util.isSorted(nums));
        Assert.assertTrue(Util.isSorted(nums1));
    }
}