package data.string1;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.string1
 * @Author: xuyifang
 * @CreateTime: 2021-08-17 08:11
 * @Description:
 */
public class _0551_checkRecord {

    public boolean checkRecord(String s) {
        return s.indexOf("A") == s.lastIndexOf("A") && !s.contains("LLL");
    }
}
