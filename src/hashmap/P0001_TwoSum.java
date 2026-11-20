package hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：两数之和
 * 来源：LeetCode 1
 * 日期：2026-11-13
 *
 * 思路：
 * 哈希表
 * 遍历数组，用 HashMap 记录已遍历元素的值与下标；对当前元素 nums[i]，查找 target - nums[i] 是否已存在。
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class P0001_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}