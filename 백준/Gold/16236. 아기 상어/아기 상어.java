import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, minSec, eatCnt, sharkSize;
    private static Fish shark;
    private static int[][] graph;

    private static boolean[][] visited;

    private static int[] ay = {-1, 1, 0, 0};
    private static int[] ax = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        Main app = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for (int i=0; i<n; i++) {
            StringTokenizer tokens = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                int k = Integer.parseInt(tokens.nextToken());
                graph[i][j] = k;

                if (k==9) {
                    shark = new Fish(i, j, 0);
                    graph[i][j] = 0;
                    sharkSize = 2;
                    eatCnt = 0;
                }
            }
        }

        int seconds = app.getSeconds();

        System.out.println(seconds);
        br.close();
    }

    private int getSeconds() {
        int seconds = 0;
        while (eatable()) seconds += minSec;

        return seconds;
    }

    private boolean eatable() {
        visited = new boolean[n][n];

        Queue<Fish> queue = new LinkedList<>();
        queue.offer(shark);

        PriorityQueue<Fish> pQueue = new PriorityQueue<>((a, b) -> {
            if (a.sec == b.sec) { // 거리가 같다면
                if (a.y == b.y) return a.x - b.x; // 높이가 같다면 가장 왼쪽
                else return a.y - b.y; // 가장 위에 있는 물고기
            } return a.sec - b.sec; // 가장 가까운 물고기
        });

        while (!queue.isEmpty()) {
            Fish prev = queue.poll();

            for (int d=0; d<4; d++) {
                int y = prev.y + ay[d];
                int x = prev.x + ax[d];

                if (y<0 || y>=n || x<0 || x>=n) continue;
                if (visited[y][x] || sharkSize < graph[y][x]) continue;

                if (graph[y][x] != 0 && sharkSize > graph[y][x])
                    pQueue.offer(new Fish(y, x, prev.sec + 1));
                else {
                    queue.offer(new Fish(y, x, prev.sec + 1));
                    visited[y][x] = true;
                }
            }
        }

        if (!pQueue.isEmpty()) {
            Fish target = pQueue.poll();

            eatCnt++;
            if (sharkSize == eatCnt) {
                sharkSize++;
                eatCnt = 0;
            }

            minSec = target.sec;
            shark = new Fish(target.y, target.x, 0);
            graph[target.y][target.x] = 0;

            return true;
        }
        return false;
    }

    static class Fish {
        int y;
        int x;
        int sec;

        public Fish (int y, int x, int sec) {
            this.y = y;
            this.x = x;
            this.sec = sec;
        }
    }
}