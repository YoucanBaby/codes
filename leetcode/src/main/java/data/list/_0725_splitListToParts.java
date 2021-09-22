package data.list;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-06-26 06:16
 * @Description:
 */
public class _0725_splitListToParts {

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

        ListNode[] res = new ListNode[k];
        cur = head;
        for (int i = 0; i < k; i++) {
            res[i] = cur;
            for (int j = 1; j < width + (i < remainder ? 1 : 0); j++) {
                if (cur != null) {
                    cur = cur.next;
                } else {
                    break;
                }
            }
            if (cur != null) {
                ListNode pre = cur;
                cur = cur.next;
                pre.next = null;
            }
        }
        return res;
    }


    public ListNode[] splitListToParts1(ListNode head, int k) {
        int N = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            N++;
        }

        int a = N % k;      // 前a个位置中有b+1个节点
        int b = N / k;

        ListNode cur = head;
        ListNode[] res = new ListNode[k];
        for (int i = 0; i < k; i++) {
            res[i] = cur;
            for (int j = 1; j < b + (i < a ? 1 : 0); j++) {
                if (cur == null) break;
                cur = cur.next;
            }
            if (cur != null) {
                ListNode next = cur.next;
                cur.next = null;
                cur = next;
            }
        }
        return res;
    }
}
