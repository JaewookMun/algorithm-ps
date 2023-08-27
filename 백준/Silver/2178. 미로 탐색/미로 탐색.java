
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static int n, m;

    private static boolean[][] visited;

    private static int[] ay = {-1, 1, 0, 0};
    private static int[] ax = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        Main app = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int[][] graph = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            String line = sc.next();
            int j = 0;
            for (String v : line.split("")) {
                graph[i][j] = Integer.parseInt(v);
                j++;
            }
        }

        app.bfs(graph);

        System.out.println(graph[n-1][m-1]);
        sc.close();

    }

    private void bfs(int[][] graph) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] head = queue.poll();

            for(int d=0; d<4; d++) {
                int y = head[0] + ay[d];
                int x = head[1] + ax[d];

                if(y<0 || y>=n || x<0 || x>=m) continue;

                if(!visited[y][x] && graph[y][x] == 1) {
                    queue.offer(new int[]{y, x});
                    graph[y][x] = graph[head[0]][head[1]] + 1;
                    visited[y][x] = true;
                }
            }
        }
    }
}