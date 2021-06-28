package data.list;

import java.util.Random;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.hashtable1
 * @Author: xuyifang
 * @CreateTime: 2021-06-25 18:22
 * @Description:
 */
public class _0382_getRandom {
}

class Solution {

    ListNode head;
    Random random;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode cur = head;

        // 获取链表长度
        int N = 0;
        while (cur != null) {
            cur = cur.next;
            N++;
        }

        // 随机返回链表中的某个节点值
        int index = random.nextInt(N);
        cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }
}