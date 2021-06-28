package data.list;

import java.util.List;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-06-23 01:42
 * @Description:
 */
public class _0147_insertionSortList {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode cur = head;
        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(1);
        cur = cur.next;
        cur.next = new ListNode(3);
        cur = cur.next;
        _0147_insertionSortList solution = new _0147_insertionSortList();

        cur = solution.insertionSortList(head);
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }


    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        // 虚假的头节点
        ListNode newHead = new ListNode(0);
        // node用于遍历head所在的链表
        ListNode node = head;

        while(node != null){
            // node的下一个节点
            ListNode next = node.next;

            // sortNode是已经排好序的节点
            ListNode sortNode = newHead.next;
            // prevNode是sortNode的上一个节点
            ListNode prevNode = newHead;

            // 如果sortNode.val < node.val，说明node应该在sortNode的后面，所以prevNode和sortNode向后移一位
            while(sortNode != null && sortNode.val < node.val){
                prevNode = prevNode.next;
                sortNode = sortNode.next;
            }

            // 这里把node加入到newHead的链表中，画图就能理解！
            prevNode.next = node;
            node.next = sortNode;
            node = next;
        }
        return newHead.next;
    }

}
