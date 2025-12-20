package org.example.algorithm;

public class MajorityElement {
    // 169. 多数元素
    public int majorityElement(int[] nums) {
        int length = nums.length;
        if (length == 1) return nums[0];
        int flag = 1;
        int num = nums[0];
        for (int i = 1; i < length; i++) {
            if (flag == 0) {
                num = nums[i];
            }
            if (num == nums[i]) {
                flag++;
            } else {
                flag--;
            }
        }
        return num;

    }


}
