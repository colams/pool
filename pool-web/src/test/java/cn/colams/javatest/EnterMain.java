package cn.colams.javatest;

import java.util.List;

public class EnterMain {

    public static void main(String[] args) {

        InitOrder.staticMethod();
//        System.out.println(9999999 + 9999);
//        System.out.println(InitOrder.staticString);

        int[] arra = new int[]{2, 3, 4, 5, 6};
        int index = binarySearch(arra, 1);
        System.out.println(index);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int val1 = l1 == null ? 0 : l1.val;
        int val2 = l2 == null ? 0 : l2.val;

        ListNode l3 = new ListNode();
        int tempVal = val1 + val2;
        l3.val = tempVal % 10;

        ListNode next1 = l1 == null ? null : l1.next;
        ListNode next2 = l2 == null ? null : l2.next;

        l3.next = addTwoNumbers(next1, next2, tempVal >= 10 ? 1 : 0);

        return l3;
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2, int val) {
        if (l1 == null && l2 == null && val == 0) {
            return null;
        }

        int val1 = l1 == null ? 0 : l1.val;
        int val2 = l2 == null ? 0 : l2.val;

        ListNode l3 = new ListNode();
        int tempVal = val1 + val2 + val;
        l3.val = tempVal % 10;

        ListNode next1 = l1 == null ? null : l1.next;
        ListNode next2 = l2 == null ? null : l2.next;

        l3.next = addTwoNumbers(next1, next2, tempVal >= 10 ? 1 : 0);
        return l3;

    }

    public static int binarySearch(int[] nums2, int number) {
        int minIndex = 0;
        int maxIndex = nums2.length - 1;

        int index = -1;


        while (true) {

            int midIndex = (minIndex + maxIndex) / 2;

            if (midIndex == 0 && number != nums2[midIndex]) {
                break;
            }

            if (number == nums2[midIndex]) {
                index = minIndex;
                break;
            }

            if (number < nums2[midIndex]) {
                maxIndex = midIndex - 1;
            } else {
                minIndex = midIndex + 1;
            }
        }

        return index;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int nums2_index = 0;
        int nums_index = 0;

        int tempVal = 0;

        for (int i = 0; i < m; i++) {
            int index_i = binarySearch(nums2, nums1[i]);

            if (index_i > -1) {
                for (int j = nums2_index; j <= index_i; j++) {
                    tempVal = nums1[i];
                    nums1[i] = nums2[j];
                    nums2_index++;
                    nums_index = i + 1;
                }
            }
        }
    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        int count = 0;
        for (List<String> item : items) {
            if (ruleKey.equalsIgnoreCase("type") && item.get(0).equalsIgnoreCase(ruleValue)) {
                count++;
                continue;
            }

            if (ruleKey.equalsIgnoreCase("color") && item.get(1).equalsIgnoreCase(ruleValue)) {
                count++;
                continue;
            }

            if (ruleKey.equalsIgnoreCase("name") && item.get(2).equalsIgnoreCase(ruleValue)) {
                count++;
            }
        }
        return count;

    }

    public int[] runningSum(int[] nums) {

        if (nums == null) {
            return new int[0];
        }

        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] + nums[i];
        }

        return result;
    }
}
