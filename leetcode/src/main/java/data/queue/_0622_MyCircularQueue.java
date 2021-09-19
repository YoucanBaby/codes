package data.queue;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.queue
 * @Author: xuyifang
 * @CreateTime: 2021-09-16 17:53
 * @Description:
 */
public class _0622_MyCircularQueue {


    public class MyCircularQueue {

        private int rear;
        private int front;
        private int N;
        private int[] nums;

        public MyCircularQueue(int k) {
            N = k + 1;
            nums = new int[N];
            rear = 0;
            front = 0;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            nums[front] = value;
            front = (front + 1) % N;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            rear = (rear + 1) % N;
            return true;
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return nums[rear];
        }

        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            return nums[(front - 1 + N) % N];
        }

        public boolean isEmpty() {
            return rear == front;
        }


        public boolean isFull() {
            return (front + 1) % N == rear;
        }
    }
}
