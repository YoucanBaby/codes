package data.string1;


class Trie {

    int N = (int) 1e5;
    int[][] trie = new int[N][26];
    int[] count = new int[N];
    int index = 1;

    public Trie() {}

    public void insert(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (trie[p][c] == 0) trie[p][c] = index++;
            p = trie[p][c];
        }
        count[p]++;
    }

    public boolean search(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (trie[p][c] == 0) return false;
            p = trie[p][c];
        }
        return count[p] != 0;
    }

    public boolean startsWith(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (trie[p][c] == 0) return false;
            p = trie[p][c];
        }
        return true;
    }
}
