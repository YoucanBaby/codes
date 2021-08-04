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
}
