package data.list;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-06-25 19:10
 * @Description:
 */
public class _1171_removeZeroSumSublists {

    public static void main(String[] args) {

    }

    public ListNode removeZeroSumSublists(ListNode head) {
        // 新建伪头节点 newHead
        ListNode newHead = new ListNode(0, head);
        // 新建HashMap
        Map<Integer, ListNode> map = new HashMap<>();

        // 首次遍历，在HashMap中加入 <前缀和，节点>。若同一前缀和出现多次会覆盖，即记录该sum出现的最后一次节点。
        int sum = 0;
        for (ListNode cur = newHead; cur != null; cur = cur.next) {
            sum += cur.val;
            map.put(sum, cur);
        }

        // 第二次遍历，若当前节点cur的sum在后面出现了，则表明两结点之间所有节点和为0，直接删除区间所有节点。
        sum = 0;
        for (ListNode cur = newHead; cur != null; cur = cur.next) {
            sum += cur.val;
            cur.next = map.get(sum).next;
        }

        return newHead.next;
    }
}
