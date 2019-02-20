package com.tianxiaobo.sort;

import com.tianxiaobo.Util;
import org.junit.Assert;
import org.junit.Test;

/**
 * ShellSortTest
 *
 * @author Tian ZhongBo
 * @date 2018-09-14 21:50:39
 */
public class ShellSortTest {

    @Test
    public void sort() throws Exception {
        Sort<Integer> shellSort = new ShellSort<>();
        Integer[] nums = shellSort.sort(new Integer[]{1, 3, 8, 0, 7, 2, 9, 2});
        Integer[] nums1 = shellSort.sort(new Integer[]{1, 3, 8, 10, 29, 21, 30, 50, 22, 75, 0, 7, 2, 9, 2});
        Assert.assertTrue(Util.isSorted(nums));
        Assert.assertTrue(Util.isSorted(nums1));
    }

}