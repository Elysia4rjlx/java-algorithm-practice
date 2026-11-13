package string;


public class P0005_LongestPalindromicSubstring {
    /**
     * 题目：最长回文子串
     * 来源：LeetCode 5
     * 日期：2026-11-13
     *
     * 思路：
     * 中心扩展法
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */

    public static void main(String[] args) {
        String s = "dfdsdsaabbaassdfs";
        System.out.println(longestPalindrome(s));


    }


    public static String longestPalindrome(String s) {
        int start = 0;
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            int a = expandAroundCenter(s,i,i);
            int b = expandAroundCenter(s,i,i+1);

            int curLen = Math.max(a,b);

            if (curLen > maxLen) {
                maxLen = curLen;
                start = i - (curLen -1) / 2;
            }

        }

        return s.substring(start,start + maxLen);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0
                && right < s.length()
                && s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }
        return right - left - 1;
    }
















}