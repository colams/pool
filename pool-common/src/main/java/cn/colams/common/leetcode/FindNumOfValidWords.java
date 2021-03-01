package cn.colams.common.leetcode;

import java.util.ArrayList;
import java.util.List;


/**
 * 元宵节，猜灯谜
 */
public class FindNumOfValidWords {

    public static void main(String[] args) {

        String[] words = {"aaaa", "asas", "able", "ability", "actt", "actor", "access"};
        String[] puzzles = {"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"};

        List<Integer> result = findNumOfValidWords(words, puzzles);
        return;

    }


    public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        if (words == null || words.length <= 0 || puzzles == null || puzzles.length <= 0) {
            return null;
        }

        List<Integer> result = new ArrayList<>();

        for (String puzzle : puzzles) {
            for (String word : words) {
                // if ()
            }
        }


        return result;

    }

}
