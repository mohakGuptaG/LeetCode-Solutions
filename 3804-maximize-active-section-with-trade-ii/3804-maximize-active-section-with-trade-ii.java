import java.util.*;

class Solution {

    private void build(int node, int l, int r, int[] seg, int[] arr) {
        if (l == r) {
            seg[node] = arr[l];
            return;
        }

        int mid = (l + r) / 2;
        build(node * 2 + 1, l, mid, seg, arr);
        build(node * 2 + 2, mid + 1, r, seg, arr);

        seg[node] = Math.max(seg[node * 2 + 1], seg[node * 2 + 2]);
    }

    private int query(int node, int l, int r, int ql, int qr, int[] seg) {
        if (l > qr || r < ql)
            return Integer.MIN_VALUE;

        if (ql <= l && r <= qr)
            return seg[node];

        int mid = (l + r) / 2;

        return Math.max(
                query(node * 2 + 1, l, mid, ql, qr, seg),
                query(node * 2 + 2, mid + 1, r, ql, qr, seg));
    }

    private int lowerBound(int[] arr, int len, int key) {
        int lo = 0, hi = len;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] < key)
                lo = mid + 1;
            else
                hi = mid;
        }

        return lo;
    }

    private int upperBound(int[] arr, int len, int key) {
        int lo = 0, hi = len;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] <= key)
                lo = mid + 1;
            else
                hi = mid;
        }

        return lo;
    }

    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {

        int n = s.length();

        int active = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1')
                active++;
        }

        int[] blockStart = new int[n];
        int[] blockEnd = new int[n];

        int m = 0;
        int i = 0;

        while (i < n) {
            if (s.charAt(i) == '0') {
                int st = i;

                while (i < n && s.charAt(i) == '0')
                    i++;

                blockStart[m] = st;
                blockEnd[m] = i - 1;
                m++;
            } else {
                i++;
            }
        }

        List<Integer> ans = new ArrayList<>();

        if (m < 2) {
            for (int[] q : queries)
                ans.add(active);
            return ans;
        }

        int[] blockSize = new int[m];
        for (i = 0; i < m; i++) {
            blockSize[i] = blockEnd[i] - blockStart[i] + 1;
        }

        int pairs = m - 1;

        int[] pairSum = new int[pairs];
        for (i = 0; i < pairs; i++) {
            pairSum[i] = blockSize[i] + blockSize[i + 1];
        }

        int[] seg = new int[4 * pairs];
        build(0, 0, pairs - 1, seg, pairSum);

        for (int[] q : queries) {

            int l = q[0];
            int r = q[1];

            int first = lowerBound(blockEnd, m, l);
            int last = upperBound(blockStart, m, r) - 1;

            int best = 0;

            if (first < last) {

                int leftLen = blockEnd[first] - Math.max(blockStart[first], l) + 1;
                int rightLen = Math.min(blockEnd[last], r) - blockStart[last] + 1;

                if (last - first == 1) {
                    best = leftLen + rightLen;
                } else {

                    int option1 = leftLen + blockSize[first + 1];
                    int option2 = blockSize[last - 1] + rightLen;

                    int option3 = 0;

                    if (first + 1 <= last - 2) {
                        option3 = query(0, 0, pairs - 1, first + 1, last - 2, seg);
                    }

                    best = Math.max(option1, Math.max(option2, option3));
                }
            }

            ans.add(active + best);
        }

        return ans;
    }
}