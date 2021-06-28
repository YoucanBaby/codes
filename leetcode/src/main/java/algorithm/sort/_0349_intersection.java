package algorithm.sort;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: algorithm.sort
 * @Author: xuyifang
 * @CreateTime: 2021-06-21 05:59
 * @Description:
 */
public class _0349_intersection {

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        _0349_intersection solution = new _0349_intersection();

        int[] ret1 = solution.intersection1(nums1, nums2);
        System.out.println(Arrays.toString(ret1));

        int[] ret = solution.intersection(nums1, nums2);
        System.out.println(Arrays.toString(ret));
    }


    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1 = 0;
        int p2 = 0;
        int pre = -1;
        List<Integer> list = new ArrayList<>();

        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] == nums2[p2] && nums1[p1] != pre) {
                list.add(nums1[p1]);
                pre = nums1[p1];
                p1++;
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }

        int[] ret = new int[list.size()];
        int i = 0;
        for (int num: list) {
            ret[i++] = num;
        }

        return ret;
    }


    public int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num: nums1) {
            set1.add(num);
        }

        for (int num: nums2) {
            set2.add(num);
        }

        List<Integer> list = new ArrayList<>();
        for (int num: set1) {
            if (set2.contains(num)) {
                list.add(num);
            }
        }

        int[] ret = new int[list.size()];
        int i = 0;
        for (int num: list) {
            ret[i++] = num;
        }

        return ret;
    }
}
