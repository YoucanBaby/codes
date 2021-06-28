package data.list;

import java.util.*;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.list
 * @Author: xuyifang
 * @CreateTime: 2021-06-25 18:47
 * @Description:
 */
public class _0355_Twitter {
}
class Twitter {

    // 用户id 和 推文（单链表）的对应关系
    private Map<Integer, Tweet> twitter;

    // 用户id 和 他关注的用户列表 的对应关系
    private Map<Integer, Set<Integer>> followings;

    // 全局使用的时间戳字段，用户每发布一条推文之前 + 1
    private static int timestamp = 0;

    // 合并 k 组推文使用的数据结构（可以在方法里创建使用），声明成全局变量非必需，视个人情况使用
    private static PriorityQueue<Tweet> maxHeap;

    /**
     * 推文类，是一个单链表（结点视角）
     */
    private class Tweet {

         // 推文id
        private int id;
        //发推文的时间戳
        private int timestamp;

        private Tweet next;

        public Tweet(int id, int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {

    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        return new ArrayList<Integer>();
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {

    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {

    }
}