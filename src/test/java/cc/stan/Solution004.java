package cc.stan;

import org.junit.Test;

/**
 * Median of Two Sorted Arrays
 * <p>
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * Example 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * <p>
 * Example 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 * 寻找两个有序数组的中位数,问题转换为求第K大的数
 */
public class Solution004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1len = nums1.length;
        int n2len = nums2.length;
        int index1 = 0, index2 = 0;
        int x = 0, y = 0;
        int mid = (n1len + n2len) / 2;

        while ((index1 + index2) <= mid && index1 < n1len && index2 < n2len) {
            x = y;
            if (nums1[index1] < nums2[index2]) {
                y = nums1[index1++];
            } else {
                y = nums2[index2++];
            }
        }
        if (index1 == n1len) {
            while ((index1 + index2) <= mid) {
                x = y;
                y = nums2[index2++];
            }
        }
        if (index2 == n2len) {
            while ((index1 + index2) <= mid) {
                x = y;
                y = nums1[index1++];
            }
        }
        if ((n1len + n2len) % 2 == 0) {
            return ((double) x + (double) y) / 2;
        } else {
            return (double) y;
        }
    }

    @Test
    public void test1() {
        //System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2, 3, 4, 5}, new int[]{6, 7, 8, 9, 10}));
        //System.out.println(findMedianSortedArrays(new int[]{1, 4}, new int[]{5, 6, 9}));
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n1len = nums1.length;
        int n2len = nums2.length;
        int idx1 = 0, idx2 = 0;
        int x = 0, y = 0;
        int mid = (n1len + n2len) / 2;

        while ((idx1 + idx2) <= mid && idx1 < n1len && idx2 < n2len) {
            x = y;
            if (nums1[idx1] < nums2[idx2]) {
                y = nums1[idx1++];
            } else {
                y = nums2[idx2++];
            }
        }
        if (idx1 == n1len) {
            while ((idx1 + idx2) <= mid) {
                x = y;
                y = nums2[idx2++];
            }
        }
        if (idx2 == n2len) {
            while ((idx1 + idx2) <= mid) {
                x = y;
                y = nums1[idx1++];
            }
        }

        if ((n1len + n2len) % 2 == 0) {
            return ((double) x + y) / 2;
        } else {
            return (double) y;
        }
    }
}

