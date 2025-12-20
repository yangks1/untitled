package org.example.algorithm;

public class MergeTwoSortedArrays {
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;
        while(len1 >= 0 && len2 >= 0) {
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
        return nums1;
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = new int[]{2,5,6};
        int n = 3;
        MergeTwoSortedArrays mergeTwoSortedArrays = new MergeTwoSortedArrays();
        int[] nums = mergeTwoSortedArrays.merge(nums1, m, nums2, n);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
