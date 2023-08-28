import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n, s, e;
    private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        Main app = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] conditions = br.readLine().split(" ");

        n = Integer.parseInt(conditions[0]);
        int m = Integer.parseInt(conditions[1]);

        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());


        StringTokenizer tokens;

        for(int i=0; i<m; i++) {
            tokens = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(tokens.nextToken());
            int b = Integer.parseInt(tokens.nextToken());
            int c = Integer.parseInt(tokens.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        tokens = new StringTokenizer(br.readLine());

        s = Integer.parseInt(tokens.nextToken());
        e = Integer.parseInt(tokens.nextToken());

        System.out.println(app.search());
        br.close();
    }

    private int search() {
        int start = 1;
        int end = 1000000001;

        int max = 0;
        while(start <= end) {
            int mid = (start + end) / 2;
            visited = new boolean[n+1];

            if(bfs(mid)) {
                start = mid + 1;
                max = Math.max(max, mid);
            }
            else end = mid;
            
            if(start == end) break;
        }

        return max;
    }

    private boolean bfs(int weight) {
        boolean isValid = false;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        visited[s] = true;

        while(!queue.isEmpty()) {
            Integer head = queue.poll();
            if(graph.get(head).isEmpty()) continue;

            for (Node arrival : graph.get(head)) {
                if(visited[arrival.num]) continue;

                if(arrival.num == e) {
                    if(arrival.weight >= weight) return true;
                }
                else if(arrival.weight >= weight) {
                    queue.offer(arrival.num);
                    visited[arrival.num] = true;
                }
            }
        }

        return isValid;
    }

    static class Node {
        int num;
        int weight;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }
}
