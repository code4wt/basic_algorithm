package com.tianxiaobo.search;

import org.junit.Assert;
import org.junit.Test;

/**
 * BinarySearchTest
 *
 * @author Tian ZhongBo
 * @date 2019-02-20 18:10:02
 */
public class BinarySearchTest {

    @Test
    public void search() throws Exception {
        Integer[] nums = new Integer[]{1, 3, 7, 8, 10, 13, 14, 19, 20, 28};
        Assert.assertEquals(Integer.valueOf(7), BinarySearch.search(nums, 7));
        Assert.assertEquals(Integer.valueOf(19), BinarySearch.search(nums, 19));
        Assert.assertNull(BinarySearch.search(nums, 6));
        Assert.assertNull(BinarySearch.search(nums, 32));
    }

    @Test
    public void search1() throws Exception {
        Integer[] nums = new Integer[]{1, 3, 7, 8, 10, 13, 14, 19, 20, 28};
        Assert.assertEquals(Integer.valueOf(7), BinarySearch.search(nums, 7, 0, nums.length - 1));
        Assert.assertEquals(Integer.valueOf(19), BinarySearch.search(nums, 19, 0, nums.length - 1));
        Assert.assertNull(BinarySearch.search(nums, 6, 0, nums.length - 1));
        Assert.assertNull(BinarySearch.search(nums, 32, 0, nums.length - 1));
    }
}