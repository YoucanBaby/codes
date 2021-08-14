package data.matrix;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: com.yifang
 * @Author: xuyifang
 * @CreateTime: 2021-06-10 21:34
 * @Description:
 */
public class _0005_replaceSpace {
    public static void main(String[] args) {
        String s = "We are happy.";

        _0005_replaceSpace solution = new _0005_replaceSpace();
        System.out.println(solution.replaceSpace1(s));
        System.out.println(solution.replaceSpace(s));
    }



    public String replaceSpace1(String s) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == ' '){
                str.append("%20");
            } else {
                str.append(c);
            }
        }
        return str.toString();
    }

    public String replaceSpace(String s) {
        StringBuilder str = new StringBuilder(s);
        int P1 = str.length() - 1;
        for (int i = 0; i <= P1; i++)
            if (str.charAt(i) == ' ')
                str.append("  ");

        int P2 = str.length() - 1;
        while (P1 >= 0 && P2 > P1) {
            char c = str.charAt(P1--);
            if (c == ' ') {
                str.setCharAt(P2--, '0');
                str.setCharAt(P2--, '2');
                str.setCharAt(P2--, '%');
            } else {
                str.setCharAt(P2--, c);
            }
        }
        return str.toString();
    }
}
