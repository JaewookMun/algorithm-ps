import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[][] graph;
    private static boolean[][] visited;

    private static int[] ax = {1, -1, 0, 0};
    private static int[] ay = {0, 0, 1, -1};

    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokens = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());

        graph = new int[n][m];

        for(int i=0; i<n; i++) {
            tokens = new StringTokenizer(br.readLine());

            for(int j=0; j<m; j++) {
                graph[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }

        dfs(0);

        System.out.println(max);
        br.close();
    }

    private static void dfs(int wallCount) {
        if(wallCount == 3) {
            int[][] clone = new int[n][m];
            for(int i=0; i<graph.length; i++) {
                clone[i] = graph[i].clone();
            }

            search(clone);
            return;
        }

        for(int i=0; i<graph.length; i++) {
            for(int j=0; j<graph[0].length; j++) {
                if(graph[i][j] == 0) {
                    graph[i][j] = 1;
                    dfs(wallCount + 1);
                    graph[i][j] = 0;
                }
            }
        }
    }

    private static void search(int[][] arr) {
        visited = new boolean[n][m];

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {

                if(!visited[i][j] && arr[i][j] == 2) {
                    bfs(i, j, arr);
                    visited[i][j] = true;
                }
            }
        }

        int count = 0;
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                if(arr[i][j] == 0) count++;
            }
        }

        max = Math.max(max, count);
    }

    private static void bfs(int i, int j, int[][] arr) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});

        while(!queue.isEmpty()) {
            int[] head = queue.poll();

            for(int d=0; d<4; d++) {
                int y = head[0] + ay[d];
                int x = head[1] + ax[d];

                if(y<0 || y>=arr.length || x<0 || x>=arr[0].length) continue;

                if(!visited[y][x] && arr[y][x] == 0) {
                    arr[y][x] = 2;
                    queue.offer(new int[]{y, x});
                    visited[y][x] = true;
                }
            }
        }
    }
}