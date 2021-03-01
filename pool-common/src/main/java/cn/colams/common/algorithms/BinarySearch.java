package cn.colams.common.algorithms;

public class BinarySearch {


    public static int[] binarySearch(int[] list, int item) {
        int step = 0;

        int index = 0;
        int maxIndex = list.length - 1;

        int result = -1;

        while (index <= maxIndex) {
            step++;

            int midIndex = (index + maxIndex) / 2;
            int tempResult = list[midIndex];

            if (tempResult == item) {
                result = midIndex;
                return new int[]{step, result};
            }

            if (tempResult > item) {
                maxIndex = midIndex - 1;
            } else {
                index = midIndex + 1;
            }
        }
        return new int[]{step, result};
    }

}
