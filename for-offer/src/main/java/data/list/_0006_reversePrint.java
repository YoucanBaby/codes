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
        int N = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            N++;
        }

        int[] res = new int[N];
        ListNode cur = head;
        for (int i = N - 1; i >= 0; i--) {
            res[i] = cur.val;
            cur = cur.next;
        }
        return res;
    }
}
