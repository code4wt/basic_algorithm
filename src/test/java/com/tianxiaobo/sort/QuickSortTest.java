package com.tianxiaobo.sort;

import com.tianxiaobo.Util;
import org.junit.Assert;
import org.junit.Test;

/**
 * QuickSortTest
 *
 * @author Tian ZhongBo
 * @date 2019-02-19 13:53:30
 */
public class QuickSortTest {

    @Test
    public void sort() throws Exception {
        Sort<Integer> quickSort = new QuickSort<>();
        Integer[] nums = quickSort.sort(new Integer[]{1, 3, 8, 0, 7, 2, 9, 2});
        Integer[] nums1 = quickSort.sort(new Integer[]{1, 3, 8, 10, 29, 21, 30, 50, 22, 75, 0, 7, 2, 9, 2});
        Assert.assertTrue(Util.isSorted(nums));
        Assert.assertTrue(Util.isSorted(nums1));
    }
}