package algorithm.twopoint;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-08-19 12:12
 * @Description:
 */
public class _0165_compareVersion {


    public int compareVersion(String version1, String version2) {
        int M = version1.length();
        int N = version2.length();

        int p1 = 0;
        int p2 = 0;
        while (p1 < M || p2 < N) {
            int v1 = 0;         // 版本号的某一串
            int v2 = 0;

            while (p1 < M && version1.charAt(p1) != '.') {      // 若当前的字符不是分隔符，就计算值
                v1 = v1 * 10 + version1.charAt(p1) - '0';
                p1++;
            }
            while (p2 < N && version2.charAt(p2) != '.') {
                v2 = v2 * 10 + version2.charAt(p2) - '0';
                p2++;
            }
            if (v1 < v2) {
                return -1;
            } else if (v1 > v2) {
                return 1;
            } else {
                p1++;
                p2++;
            }
        }
        return 0;
    }
}
