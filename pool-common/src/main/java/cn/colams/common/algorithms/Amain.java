package cn.colams.common.algorithms;

public class Amain {

    public static void main(String[] args) {
        int[] list = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int item = 3;
        int[] result = BinarySearch.binarySearch(list, item);
        System.out.print(result);
    }
}
