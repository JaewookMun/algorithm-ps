import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main app = new Main();

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        long min = app.bfs(a, b);
        System.out.println(min);
        sc.close();
    }

    private long bfs(int a, int b) {
        Queue<long[]> queue = new LinkedList<>();
        queue.offer(new long[]{a, 0});

        while (!queue.isEmpty()) {
            long[] head = queue.poll();

            long now = head[0];
            long cnt = head[1];

            if (now < b) {
                long calcA = now * 2;
                long calcB = (now * 10) + 1;
                if (calcA == b || calcB == b) return cnt + 1 + 1;
                else {
                    queue.offer(new long[] {calcA, cnt + 1});
                    queue.offer(new long[] {calcB, cnt + 1});
                }
            }
        }

        return -1;
    }
}
