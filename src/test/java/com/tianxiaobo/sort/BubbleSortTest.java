package com.tianxiaobo.sort;

import com.tianxiaobo.Util;
import org.junit.Assert;
import org.junit.Test;

/**
 * BubbleSortTest
 *
 * @author Tian XiaoBo
 * @date 2018-09-13 12:40:57
 */
public class BubbleSortTest {

    @Test
    public void sort() throws Exception {
        Sort<Integer> bubbleSort = new BubbleSort<>();
        Integer[] nums = bubbleSort.sort(new Integer[]{1, 3, 8, 0, 7, 2, 9, 2});
        Integer[] nums1 = bubbleSort.sort(new Integer[]{1, 3, 8, 10, 29, 21, 30, 50, 22, 75, 0, 7, 2, 9, 2});
        Assert.assertTrue(Util.isSorted(nums));
        Assert.assertTrue(Util.isSorted(nums1));
    }
}
