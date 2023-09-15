package cn.colams.common.leetcode;

public class ClimbStairs {

    public int climbStairs(int n) {
        int totalCount = 0;

        int oneStep = 1;
        int twoStep = 2;

        int oneStepCount = n / 1;
        int twoStepCount = n / 2;

        int mod = n % 2;
        if (mod > 0) {
            totalCount = twoStepCount + 1;
        }
        if (oneStepCount <= 1) {
            return oneStepCount;
        }

        int sub = oneStepCount / 2;


        System.out.println(oneStepCount / 2);
        return oneStepCount;
    }

    public static void main(String[] args) {
        ClimbStairs c = new ClimbStairs();
        c.climbStairs(5);

    }

}
