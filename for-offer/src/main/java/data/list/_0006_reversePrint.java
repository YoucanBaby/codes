package data.list;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-06-18 09:23
 * @Description:
 */
public class _0006_reversePrint {

    public static void main(String[] args) {

    }

    public int[] reversePrint(ListNode head) {
        ListNode cur = head;
        int N = 0;

        while (cur != null) {
            N++;
            cur = cur.next;
        }

        int[] ret = new int[N];
        cur = head;
        for (int i = N - 1; i >= 0; i--) {
            ret[i] = cur.val;
            cur = cur.next;
        }
        return ret;
    }
}
