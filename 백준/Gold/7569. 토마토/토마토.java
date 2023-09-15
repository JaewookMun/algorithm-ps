import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[][][] grid;
    private static int[][][] effected;

    private static int[] ax = {1, -1, 0, 0};
    private static int[] ay = {0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        Main app = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(tokens.nextToken());
        int l = Integer.parseInt(tokens.nextToken());
        int h = Integer.parseInt(tokens.nextToken());


        grid = new int[h][l][w];
        effected = new int[h][l][w];

        for(int i=0; i<h; i++) {
            for(int j=0; j<l; j++) {
                tokens = new StringTokenizer(br.readLine());
                for(int k=0; k<w; k++) {
                    int e = Integer.parseInt(tokens.nextToken());
                    grid[i][j][k] = e;
                }
            }
        }

        Queue<Cube> queue = new LinkedList<>();
        for(int i=0; i<h; i++) {
            for(int j=0; j<l; j++) {
                for(int k=0; k<w; k++) {
                    if(grid[i][j][k] == 1) queue.offer(new Cube(i, j, k));
                }
            }
        }

        app.bfs(queue, h);

        int max = 0;

        label:
        for(int i=0; i<h; i++) {
            for(int j=0; j<l; j++) {
                for(int k=0; k<w; k++) {
                    if(grid[i][j][k] == 0) {
                        max = -1;
                        break label;
                    }

                    max = Math.max(max, effected[i][j][k]);
                }
            }
        }

        System.out.println(max);
        br.close();
    }

    private void bfs(Queue<Cube> queue, int height) {
        while (!queue.isEmpty()) {
            Cube cube = queue.poll();
            int h = cube.h;
            int l = cube.l;
            int w = cube.w;

            if(h + 1 < height && grid[h+1][l][w] == 0) {
                grid[h+1][l][w] = 1;
                effected[h+1][l][w] = effected[h][l][w] + 1;
                queue.offer(new Cube(h+1, l, w));
            }

            if(h-1 >= 0 && grid[h-1][l][w] == 0) {
                grid[h-1][l][w] = 1;
                effected[h-1][l][w] = effected[h][l][w] + 1;
                queue.offer(new Cube(h-1, l, w));
            }

            for(int d=0; d<4; d++) {
                int y = l + ay[d];
                int x = w + ax[d];

                if(y<0 || y>=grid[0].length || x<0 || x>=grid[0][0].length) continue;

                if(grid[h][y][x] == 0) {
                    grid[h][y][x] = 1;
                    effected[h][y][x] = effected[h][cube.l][cube.w] + 1;
                    queue.offer(new Cube(h, y, x));
                }
            }
        }
    }

    static class Cube {
        int h;
        int l;
        int w;

        public Cube(int h, int l, int w) {
            this.h = h;
            this.l = l;
            this.w = w;
        }
    }
}