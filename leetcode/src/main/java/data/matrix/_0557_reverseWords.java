package data.matrix;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.string1
 * @Author: xuyifang
 * @CreateTime: 2021-07-09 11:05
 * @Description:
 */
public class _0557_reverseWords {

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        _0557_reverseWords solution = new _0557_reverseWords();

        System.out.println(solution.reverseWords(s));
    }

    public String reverseWords(String s) {
        int left = 0;
        StringBuilder res = new StringBuilder();

        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == ' ') {
                StringBuilder temp = new StringBuilder(s.substring(left, right));
                temp.reverse();
                res.append(temp);
                res.append(" ");
                left = right + 1;
            }
        }
        StringBuilder temp = new StringBuilder(s.substring(left, s.length()));
        temp.reverse();
        res.append(temp);

        return res.toString();
    }
}
