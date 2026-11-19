package list;

/**
 * 题目：合并两个有序链表
 * 来源：LeetCode 21
 * 日期：2026-11-19
 * <p>
 * 思路：
 * 迭代法 + 哨兵节点
 * 使用 dummy 哨兵节点简化头节点处理，双指针比较两个链表当前节点，取较小值接入结果链表。
 * <p>
 * 时间复杂度：O(m + n)
 * 空间复杂度：O(1)
 */
public class P0021_MergeTwoSortedLists {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode merged = mergeTwoLists(l1,l2);
        System.out.print("res = ");
        printList(merged);

    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //创建虚拟头结点
        ListNode dummy = new ListNode(-1);
        //合并链表的尾指针
        ListNode cur = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            }else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

//        if (list1 == null) {
//            cur.next = list2;
//        }
//        if (list2 == null) {
//            cur.next = list1;
//        }

        cur.next = (list1 == null)?list2:list1;
        return dummy.next;
    }

    // 辅助方法：打印链表
    private static void printList(ListNode head) {
        StringBuilder sb = new StringBuilder("{");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) {
                sb.append(",");
            }
            head = head.next;
        }
        sb.append("}");
        System.out.println(sb);
    }
}