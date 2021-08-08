package odd._253;

/**
 * @BelongsProject: codes
 * @BelongsPackage: odd._253
 * @Author: xuyifang
 * @CreateTime: 2021-08-08 10:30
 * @Description:
 */
public class _5838_isPrefixString {

    public boolean isPrefixString(String s, String[] words) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word);
            if (s.equals(sb.toString())) {
                return true;
            }
        }
        return false;
    }
}
