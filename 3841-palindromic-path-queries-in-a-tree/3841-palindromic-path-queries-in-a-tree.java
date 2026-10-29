import java.util.*;

public class Solution {
    // Fenwick Tree (Binary Indexed Tree) for prefix XOR queries
    static class FenwickTree {
        private final int[] tree;
        private final int n;

        public FenwickTree(int n) {
            this.n = n;
            this.tree = new int[n + 2];
        }

        public void update(int i, int delta) {
            for (; i <= n; i += i & -i) {
                tree[i] ^= delta;
            }
        }

        public int query(int i) {
            int xorSum = 0;
            for (; i > 0; i -= i & -i) {
                xorSum ^= tree[i];
            }
            return xorSum;
        }

        // Range update on [l, r] with XOR delta
        public void rangeUpdate(int l, int r, int delta) {
            update(l, delta);
            update(r + 1, delta);
        }
    }

    private int[][] up;
    private int[] depth;
    private int[] tin;
    private int[] tout;
    private int[] initDist;
    private int timer = 0;
    private int maxLog;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        // Build adjacency list
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        // Initialize binary lifting tables
        maxLog = 1;
        while ((1 << maxLog) <= n) {
            maxLog++;
        }
        up = new int[n][maxLog];
        depth = new int[n];
        tin = new int[n];
        tout = new int[n];
        initDist = new int[n];

        char[] chars = s.toCharArray();

        // Iterative DFS to flatten tree and compute LCA tables without StackOverflow
        int[] it = new int[n];
        int[] stack = new int[n];
        int top = 0;

        stack[0] = 0;
        up[0][0] = 0;
        depth[0] = 0;
        tin[0] = ++timer;
        initDist[0] = 1 << (chars[0] - 'a');

        while (top >= 0) {
            int u = stack[top];
            if (it[u] < adj[u].size()) {
                int v = adj[u].get(it[u]++);
                if (v != up[u][0]) {
                    up[v][0] = u;
                    depth[v] = depth[u] + 1;
                    initDist[v] = initDist[u] ^ (1 << (chars[v] - 'a'));
                    tin[v] = ++timer;
                    stack[++top] = v;
                }
            } else {
                tout[u] = timer;
                top--;
            }
        }

        // Precompute binary lifting for LCA
        for (int j = 1; j < maxLog; j++) {
            for (int i = 0; i < n; i++) {
                up[i][j] = up[up[i][j - 1]][j - 1];
            }
        }

        FenwickTree bit = new FenwickTree(n);
        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {
            String[] parts = q.split(" ");
            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char newChar = parts[2].charAt(0);
                if (chars[u] != newChar) {
                    int oldMask = 1 << (chars[u] - 'a');
                    int newMask = 1 << (newChar - 'a');
                    int delta = oldMask ^ newMask;
                    chars[u] = newChar;

                    // Update all descendants in subtree [tin[u], tout[u]]
                    bit.rangeUpdate(tin[u], tout[u], delta);
                }
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int lcaNode = getLCA(u, v);
                int rootU = initDist[u] ^ bit.query(tin[u]);
                int rootV = initDist[v] ^ bit.query(tin[v]);
                int maskLca = 1 << (chars[lcaNode] - 'a');

                int pathXor = rootU ^ rootV ^ maskLca;

                // A path forms a palindrome if at most one bit is set
                ans.add(pathXor == 0 || (pathXor & (pathXor - 1)) == 0);
            }
        }

        return ans;
    }

    private int getLCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int tmp = u;
            u = v;
            v = tmp;
        }

        for (int j = maxLog - 1; j >= 0; j--) {
            if (depth[u] - (1 << j) >= depth[v]) {
                u = up[u][j];
            }
        }

        if (u == v) return u;

        for (int j = maxLog - 1; j >= 0; j--) {
            if (up[u][j] != up[v][j]) {
                u = up[u][j];
                v = up[v][j];
            }
        }

        return up[u][0];
    }
}