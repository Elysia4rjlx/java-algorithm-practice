package hashmap;


import java.util.HashMap;

/**
 * 题目：无重复字符的最长子串
 * 来源：LeetCode 3
 * 日期：2026-11-12
 *
 * 思路：
 * 滑动窗口 + HashMap
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class P0003_LongestSubstringWithoutRepeatingCharacters {

    static void main() {
        String s = "m@P%a%!";
        System.out.println(lengthOfLongestSubstring(s));
    }

    private static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int ans = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch) && map.get(ch) >= left) {
                left = map.get(ch) + 1;
            }

            map.put(ch, i);
            ans = Math.max(ans, i - left + 1);

        }
        return ans;
    }
}