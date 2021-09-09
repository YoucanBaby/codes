package algorithm.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.greedy
 * @Author: xuyifang
 * @CreateTime: 2021-09-09 01:48
 * @Description:
 */
public class _0068_fullJustify {

    public static void main(String[] args) {
        _0068_fullJustify solution = new _0068_fullJustify();

        String[] words = {"Science","is","what","we","understand","well","enough","to",
                "explain","to","a","computer.","Art","is","everything","else","we","do"};
        int maxLength = 20;
        System.out.println(solution.fullJustify(words, maxLength));
    }

    public List<String> fullJustify(String[] words, int maxLength) {
        List<String> res = new ArrayList<>();
        int left = 0;
        int N = words.length;
        while (left < N) {

            int rowLength = 0;          // 一行的长度
            int right = left;
            while (right < N && rowLength + words[right].length() <= maxLength) {
                rowLength += words[right].length() + 1;      // 一个单词后面要跟一个空格
                right++;
            }

            String row = row = justified(words, maxLength, left, right);
            res.add(row);
            left = right;
//            System.out.println(row);
//            System.out.println(row.length());
        }
        return res;
    }

    // [left, right)
    private String justified(String[] words, int maxLength, int left, int right) {
        // 如果不是最后一行，则一行内均摊空格，左右对齐
        if (right < words.length) {
            // 单词个数
            int wordsCount = right - left;
            // 去除空格的单词长度
            int wordsLength = 0;
            for (int i = left; i < right; i++) {
                wordsLength += words[i].length();
            }
            // 空格总长度
            int spaceAllLength = maxLength - wordsLength;
            // 空格个数
            int spaceCount = Math.max(1, wordsCount - 1);
            // 单个空格长度
            int spaceLength = spaceAllLength / spaceCount;
            // 前n个空格需要+1的
            int n = spaceAllLength % spaceCount;
            // 最后返回的结果
            StringBuilder sb = new StringBuilder();
            for (int i = left; i <= right - 1; i++) {
                sb.append(words[i]);
                if (wordsCount != 1 && i == right - 1) {
                    continue;
                }
                for (int j = 0; j < spaceLength; j++) sb.append(" ");
                if (i < left + n) sb.append(" ");
            }
            return sb.toString();
        }
        // 如果是最后一行，左对齐
        else {
            StringBuilder sb = new StringBuilder();
            for (int i = left; i <= right - 1; i++) {
                if (i != right - 1) {
                    sb.append(words[i]).append(" ");
                } else {
                    sb.append(words[i]);
                }
            }
            while (sb.length() < maxLength) {
                sb.append(" ");
            }
            return sb.toString();
        }
    }
}
