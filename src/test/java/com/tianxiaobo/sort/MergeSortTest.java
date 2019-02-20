package com.tianxiaobo.sort;

import com.tianxiaobo.Util;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 * MergeSortTest
 *
 * @author Tian ZhongBo
 * @date 2019-02-20 10:37:14
 */
public class MergeSortTest {

    @Test
    public void sort() throws Exception {
        Sort<Integer> mergeSort = new MergeSort<>();
        Integer[] nums = mergeSort.sort(new Integer[]{1, 3, 8, 0, 7, 2, 9, 2});
        Integer[] nums1 = mergeSort.sort(new Integer[]{1, 3, 8, 10, 29, 21, 30, 50, 22, 75, 0, 7, 2, 9, 2});
        Assert.assertTrue(Util.isSorted(nums));
        Assert.assertTrue(Util.isSorted(nums1));
    }

}