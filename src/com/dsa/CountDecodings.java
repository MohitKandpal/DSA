/**
 * You have intercepted a secret message encoded as a string of numbers. The message is decoded via the following mapping:
 * "1" -> 'A'
 * "2" -> 'B'
 * ...
 * "25" -> 'Y'
 * "26" -> 'Z'
 * However, while decoding the message, you realize that there are many different ways you can decode the message because some codes are contained in other codes ("2" and "5" vs "25").
 * For example, "11106" can be decoded into:
 * "AAJF" with the grouping (1, 1, 10, 6)
 * "KJF" with the grouping (11, 10, 6)
 * The grouping (1, 11, 06) is invalid because "06" is not a valid code (only "6" is valid).
 * Note: there may be strings that are impossible to decode.
 * Given a string s containing only digits, return the number of ways to decode it. If the entire string cannot be decoded in any valid way, return 0.
 * The test cases are generated so that the answer fits in a 32-bit integer.
 */
package com.dsa;

public class CountDecodings {
    public static void main(String[] args) {
        String str = "226";
        System.out.println("Number of possible decodings: - " + countDecodings(str));
    }

    public static int countDecodings(String str) {
        if(null == str || str.isEmpty())
            return 0;
        int[] dp = new int[str.length() + 1];
        dp[0] = 1;
        dp[1] = str.charAt(0) == '0' ? 0 : 1;

        for(int i = 2; i <= str.length(); i++) {
            int first = Integer.parseInt(str.substring(i - 1, i));
            int second = Integer.parseInt(str.substring(i - 2, i));
            if(first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[str.length()];
    }
}
