import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static int[][] grid;

    private static int[] ay = {2, 2, 1, 1, -1, -1, -2, -2};
    private static int[] ax = {1, -1, 2, -2, 2, -2, 1, -1};


    public static void main(String[] args) throws IOException {
        Main app = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<tc; t++) {
            int n = Integer.parseInt(br.readLine());

            grid = new int[n][n];

            String[] st = br.readLine().split(" ");
            int[] start = {Integer.parseInt(st[1]), Integer.parseInt(st[0])};

            st = br.readLine().split(" ");
            int[] end = {Integer.parseInt(st[1]), Integer.parseInt(st[0])};

            int count = app.bfs(start, end);
            sb.append(count + "\n");
        }

        System.out.println(sb);
        br.close();
    }

    private int bfs(int[] start, int[] end) {

        if(start[0] == end[0] && start[1] == end[1]) return 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int[] head = queue.poll();

            int hy = head[0];
            int hx = head[1];

            for(int d=0; d<8; d++) {
                int y = hy + ay[d];
                int x = hx + ax[d];

                if(y<0 || y>=grid.length || x<0 || x>=grid.length) continue;

                if(y==end[0] && x==end[1]) return grid[hy][hx] + 1;
                else if(grid[y][x] == 0) {
                    grid[y][x] = grid[hy][hx] + 1;
                    queue.offer(new int[] {y, x});
                }
            }
        }

        return -1;
    }
}