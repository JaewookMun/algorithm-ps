import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    private static int min;
    private static int[] visited = new int[200000];

    public static void main(String[] args) {
        Main app = new Main();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        min = Math.abs(a-b);

        app.bfs(a, b);

        System.out.println(min);
        sc.close();
    }

    private void bfs(int a, int b) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(a);

        int[] actions = {-1, 1, 2};

        while (!queue.isEmpty()) {
            Integer head = queue.poll();

            if(head == b) {
                min = visited[head];
                break;
            }

            if(head < 0) continue;

            for (int action : actions) {
                int next = head;
                if(action == -1) next -= 1;
                else if(action == 1) next += 1;
                else if(action == 2) next *= 2;

                if(next >= 0 && next <= 100000 && visited[next] == 0) {
                    queue.offer(next);
                    visited[next] = visited[head] + 1;
                }
            }
        }
    }
}