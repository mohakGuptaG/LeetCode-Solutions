import java.util.*;

public class Solution {
    public int minMoves(String[] classroom, int energy) {
        int R = classroom.length;
        int C = classroom[0].length();

        int sr = -1, sc = -1;
        List<int[]> litters = new ArrayList<>();

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                char ch = classroom[r].charAt(c);
                if (ch == 'S') {
                    sr = r;
                    sc = c;
                } else if (ch == 'L') {
                    litters.add(new int[]{r, c});
                }
            }
        }

        int k = litters.size();
        if (k == 0) {
            return 0;
        }

        int[][] litterIdx = new int[R][C];
        for (int[] row : litterIdx) {
            Arrays.fill(row, -1);
        }
        for (int i = 0; i < k; i++) {
            int[] pos = litters.get(i);
            litterIdx[pos[0]][pos[1]] = i;
        }

        int fullMask = (1 << k) - 1;
        int[][][][] dist = new int[R][C][energy + 1][1 << k];
        for (int[][][] d1 : dist) {
            for (int[][] d2 : d1) {
                for (int[] d3 : d2) {
                    Arrays.fill(d3, -1);
                }
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sr, sc, energy, 0});
        dist[sr][sc][energy][0] = 0;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int e = curr[2];
            int mask = curr[3];
            int d = dist[r][c][e][mask];

            if (mask == fullMask) {
                return d;
            }

            if (e == 0) {
                continue;
            }

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C && classroom[nr].charAt(nc) != 'X') {
                    char cell = classroom[nr].charAt(nc);
                    int nextEnergy = (cell == 'R') ? energy : e - 1;
                    int nextMask = mask;
                    if (litterIdx[nr][nc] != -1) {
                        nextMask |= (1 << litterIdx[nr][nc]);
                    }

                    if (dist[nr][nc][nextEnergy][nextMask] == -1) {
                        dist[nr][nc][nextEnergy][nextMask] = d + 1;
                        queue.offer(new int[]{nr, nc, nextEnergy, nextMask});
                    }
                }
            }
        }

        return -1;
    }
}