package data.list;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-06-26 06:16
 * @Description:
 */
public class _0725_splitListToParts {


    public static void main(String[] args) {

    }

    public ListNode[] splitListToParts1(ListNode head, int k) {
        // 计算链表长度N
        int N = 0;
        ListNode cur = head;
        while (cur != null) {
            N++;
            cur = cur.next;
        }

        // 计算每个部分的节点个数N/k，前N%k部分有一个额外的结点
        int width = N / k;
        int remainder = N % k;      // remainder: 余数

        ListNode[] ret = new ListNode[k];
        cur = head;
        for (int i = 0; i < k; i++) {
            // 每次把这部分的头节点(cur)加入到ret中
            ret[i] = cur;
            // 移动cur到这部分节点的尾节点
            for (int j = 0; j < width + (i < remainder ? 1 : 0) - 1; j++) {
                if (cur != null) {
                    cur = cur.next;
                }
            }
            // 尾节点的下一个节点是null, cur移动到下一部分的头节点
            if (cur != null) {
                ListNode pre = cur;
                cur = cur.next;
                pre.next = null;
            }
        }
        return ret;
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        // 计算链表长度N
        int N = 0;
        ListNode cur = head;
        while (cur != null) {
            N++;
            cur = cur.next;
        }

        // 计算每个部分的节点个数N/k，前N%k部分有一个额外的结点
        int width = N / k;
        int remainder = N % k;      // remainder: 余数

        ListNode[] ret = new ListNode[k];
        cur = head;
        for (int i = 0; i < k; i++) {
            ListNode newHead = new ListNode(0);
            ListNode write = newHead;
            for (int j = 0; j < width + (i < remainder ? 1 : 0); j++) {
                write.next = cur;
                cur = cur.next;
                write = write.next;
            }
            write.next = null;
            ret[i] = newHead.next;
        }
        return ret;
    }
}
