package data.tree.base;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree.base
 * @Author: xuyifang
 * @CreateTime: 2021-07-13 09:23
 * @Description:
 */
public class TrieTree {

    class TrieNode {
        int pass;       // 有多少个字符串经过这个节点
        int end;        // 是多少个字符串的结尾节点
        TrieNode[] nexts;

        TrieNode() {
            pass = 0;
            end = 0;
            nexts = new TrieNode[26];   // 一共有26个小写字母
        }
    }

    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        // 增
        public void insert(String word) {
            // 处理特殊情况
            if (word == null) {
                return;
            }
            // 更新节点
            TrieNode node = root;
            node.pass++;
            // 遍历字符串，沿途节点的pass++，末端节点的end++
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                // 如果后续没有节点，则新建节点
                if (node.nexts[index] == null) {
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.pass++;
            }
            node.end++;
        }

        // 删
        public void delete(String word) {
            // 处理特殊情况，如果没有word
            if (search(word) == 0) {
                return;
            }
            // 更新节点
            TrieNode node = root;
            node.pass--;
            // 遍历字符串，沿途节点的pass--，末端节点的end--
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                node.nexts[index].pass--;
                // 如果后续节点的pass为0，则置空
                if (node.nexts[index].pass == 0) {
                    node.nexts[index] = null;
                    return;
                }
                node = node.nexts[index];
            }
            node.end--;
        }

        // 查：word这个单词加入过几次
        public int search(String word) {
            // 处理特殊情况
            if (word == null) {
                return 0;
            }
            // 节点
            TrieNode node = root;
            // 遍历字符串，返回末端节点的end
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                // 如果没有这个节点
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            // 返回末端节点的end
            return node.end;
        }

        // 查：所有加入的字符串中，有几个是以pre这个字符串作为前缀的
        public int prefixNumber(String pre) {
            // 处理特殊情况
            if (pre == null) {
                return 0;
            }
            // 节点
            TrieNode node = root;
            // 遍历字符串，返回pre末端节点的pass
            for (char c : pre.toCharArray()) {
                int index = c - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }
    }
}
