package com.tianxiaobo.sort;

import com.tianxiaobo.Util;
import org.junit.Assert;
import org.junit.Test;

/**
 * OptimizedBubbleSortTest
 *
 * @author Tian XiaoBo
 * @date 2018-09-13 13:21:12
 */
public class OptimizedBubbleSortTest {

    @Test
    public void sort() throws Exception {
        Sort<Integer> optimizedBubbleSort = new OptimizedBubbleSort<>();
        Integer[] nums = optimizedBubbleSort.sort(new Integer[]{1, 3, 8, 0, 7, 2, 9, 2});
        Integer[] nums1 = optimizedBubbleSort.sort(new Integer[]{1, 3, 8, 10, 29, 21, 30, 50, 22, 75, 0, 7, 2, 9, 2});
        Assert.assertTrue(Util.isSorted(nums));
        Assert.assertTrue(Util.isSorted(nums1));
    }
}
