package linkedlist;

/**
 * 题目：反转链表
 * 来源：LeetCode 206
 * 日期：2026-11-16
 * <p>
 * 思路：
 * 迭代法（三指针）
 * 使用 prev、curr、next 三个指针，逐个反转节点指向。
 * <p>
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class P0206_ReverseLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        // 用数组辅助构造，最清晰
        int[] vals = {1, 2, 3, 4, 5};
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int v : vals) {
            cur.next = new ListNode(v);
            cur = cur.next;
        }
        ListNode head = dummy.next;   // 1 -> 2 -> 3 -> 4 -> 5

//        print(reverseList(head));
        System.out.println(head);
    }


    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null ) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = next;

            curr = next;
        }
        return head;
    }

    static void print(ListNode head) {
        StringBuilder sb = new StringBuilder();
        for (ListNode p = head; p != null; p = p.next) {
            sb.append(p.val);
            if (p.next != null) sb.append(" -> ");
        }
        System.out.println(sb);
    }
}