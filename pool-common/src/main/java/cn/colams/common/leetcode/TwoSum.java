package cn.colams.common.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 1)
            return null;

        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                return null;
            }

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }

        }
        return null;
    }


    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> temMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (temMap.containsKey(target - nums[i])) {
                return new int[]{i, temMap.get(target - nums[i])};
            }
            temMap.put(nums[i], i);
        }
        return null;
    }
}
