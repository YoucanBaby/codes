package data.string1;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.string1
 * @Author: xuyifang
 * @CreateTime: 2021-09-25 03:53
 * @Description:
 */
public class _0468_validIPAddress {

    public static void main(String[] args) {
        _0468_validIPAddress solution = new _0468_validIPAddress();
        System.out.println(solution.validIPAddress("0.1.1."));
    }

    public String validIPAddress(String IP) {
        if (IP.chars().filter(c -> c == '.').count() == 3) {
            return isIPv4(IP);
        } else if (IP.chars().filter(c -> c == ':').count() == 7) {
            return isIPv6(IP);
        } else {
            return "Neither";
        }
    }

    private String isIPv4(String IP) {
        String[] nums = IP.split("\\.", -1);
        for (String num : nums) {
            if (num.length() == 0 || num.length() > 3) return "Neither";
            if (num.charAt(0) == '0' && num.length() > 1) return "Neither";
            for (char c : num.toCharArray()) {
                if (!Character.isDigit(c)) return "Neither";
            }
            if (Integer.valueOf(num) > 255) return "Neither";
        }
        return "IPv4";
    }

    private String isIPv6(String IP) {
        String check = "0123456789abcdefABCDEF";
        String[] nums = IP.split("\\:", - 1);
        for (String num : nums) {
            if (num.length() == 0 || num.length() > 4) return "Neither";
            for (char c : num.toCharArray()) {
                if (check.indexOf(c) == -1) return "Neither";
            }
        }
        return "IPv6";
    }
}
