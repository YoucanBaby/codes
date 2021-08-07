package algorithm.twopoint;/**
* @BelongsProject: codes
* @BelongsPackage: algorithm.twopoint
* @Author: xuyifang
* @CreateTime: 2021-08-07 01:32
* @Description: 
*/public class _0457_circularArrayLoop {

    public static void main(String[] args) {
        int[] nums = {-1,2};
        _0457_circularArrayLoop solution = new _0457_circularArrayLoop();

        System.out.println(solution.circularArrayLoop(nums));
    }

    public int getNext(int[] nums, int index) {
        int N = nums.length;
        int res = index + nums[index];
        if (res < 0) {
            res %= N;			// res = (res % N + N) % N
            res += N;
            res %= N;
        } else if (res >= N){
            res %= N;
        }
        return res;
    }

    public boolean circularArrayLoop(int[] nums) {
        int N = nums.length;

        for (int i = 0; i < N; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int slow = i;
            int fast = getNext(nums, i);

            while (nums[slow] * nums[fast] > 0 && nums[fast] * nums[getNext(nums, fast)] > 0) {
                if (slow == fast) {
                    if (slow == getNext(nums, slow)) {
                        break;
                    } else {
                        return true;
                    }
                }
                slow = getNext(nums, slow);
                fast = getNext(nums, fast);
                fast = getNext(nums, fast);
            }
            // 访问过的节点置为0
            int val = i;
            while (nums[val] * nums[getNext(nums, val)] > 0) {
                int temp = val;
                val = getNext(nums, val);
                nums[temp] = 0;
            }
        }
        return false;
    }


    public int next(int[] nums, int index) {
        int N = nums.length;
        int res = index + nums[index];
        if (res < 0) {
            res %= N;			// res = (res % N + N) % N
            res += N;
            res %= N;
        } else if (res >= N){
            res %= N;
        }
        return res;
    }

    class Solution {
        int[] nums;
        int N;

        public int next(int index) {
            return ((index + nums[index]) % N + N) % N;
        }

        public boolean circularArrayLoop(int[] nums) {
            this.nums = nums;
            this.N = nums.length;

            for (int i = 0; i < N; i++) {
                int slow = i;
                int fast = next(i);

                while (nums[slow] * nums[fast] > 0 && nums[fast] * nums[next(fast)] > 0) {
                    if (slow == fast) {
                        if (slow == next(slow)) {   // 长度为1的环
                            break;
                        } else {
                            return true;
                        }
                    }
                    slow = next(slow);
                    fast = next(next(fast));
                }
            }
            return false;
        }
    }
}
