package data.array;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: com.yifang
 * @Author: xuyifang
 * @CreateTime: 2021-06-11 10:16
 * @Description:
 */
public class _0050_firstUniqChar {
    public static void main(String[] args) {
        String s = "abaccdeff";
        _0050_firstUniqChar solution = new _0050_firstUniqChar();
        System.out.println(solution.firstUniqChar(s));
    }

    public char firstUniqChar(String s) {
        int N = s.length();
        int firstIndex = s.length();
        for (char c = 'a'; c <= 'z'; c++) {
            if (s.indexOf(c) >= 0 && s.indexOf(c) == s.lastIndexOf(c)) {
                if (firstIndex > s.indexOf(c)) {
                    firstIndex = s.indexOf(c);
                }
            }
        }

        if (firstIndex < N)
            return s.charAt(firstIndex);
        else
            return ' ';
    }
}
