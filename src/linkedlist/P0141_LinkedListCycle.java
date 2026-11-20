package linkedlist;

/**
 * 题目：环形链表
 * 来源：LeetCode 141
 * 日期：2026-11-20
 * <p>
 * 思路：
 * 快慢指针（Floyd 判圈算法）
 * 慢指针每次走一步，快指针每次走两步；若存在环，两指针终会相遇。
 * <p>
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class P0141_LinkedListCycle {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        public boolean hasCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    return true;
                }
            }
            return false;
        }
    }
}