package com.tianxiaobo.sort;

import com.tianxiaobo.Util;
import org.junit.Assert;
import org.junit.Test;

/**
 * HeapSortTest
 *
 * @author Tian ZhongBo
 * @date 2019-02-19 13:48:53
 */
public class HeapSortTest {

    @Test
    public void sort() throws Exception {
        Integer[] nums = {3, 6, 1, 9, 6, 2, 7, 0, 8, 4};
        Integer[] nums1 = new Integer[]{1, 3, 8, 10, 29, 21, 30, 50, 22, 75, 0, 7, 2, 9, 2};
        Sort<Integer> heapSort = new HeapSort<>();
        heapSort.sort(nums);
        heapSort.sort(nums1);
        Assert.assertTrue(Util.isSorted(nums));
        Assert.assertTrue(Util.isSorted(nums1));
    }

}