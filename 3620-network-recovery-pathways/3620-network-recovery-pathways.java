import java.util.*;

class Solution {
    List<int[]>[] g;
    int n;
    long k;

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        this.k = k;
        n = online.length;

        g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();

        int lo = Integer.MAX_VALUE, hi = Integer.MIN_VALUE;

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            if (!online[u] || !online[v]) continue;
            g[u].add(new int[]{v, w});
            lo = Math.min(lo, w);
            hi = Math.max(hi, w);
        }

        if (g[0].isEmpty()) return -1;

        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (check(mid))
                lo = mid;
            else
                hi = mid - 1;
        }

        return check(lo) ? lo : -1;
    }

    private boolean check(int minEdge) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<long[]> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1];

            if (d != dist[u]) continue;
            if (u == n - 1) return d <= k;

            for (int[] e : g[u]) {
                int v = e[0], w = e[1];
                if (w < minEdge) continue;

                long nd = d + w;
                if (nd < dist[v] && nd <= k) {
                    dist[v] = nd;
                    pq.offer(new long[]{nd, v});
                }
            }
        }

        return false;
    }
}