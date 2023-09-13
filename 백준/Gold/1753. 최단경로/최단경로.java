import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    private static boolean[] visited;
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        Main app = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokens.nextToken());
        int m = Integer.parseInt(tokens.nextToken());
        int start = Integer.parseInt(br.readLine());

        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        visited = new boolean[n+1];

        for(int i=0; i<m; i++) {
            tokens = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(tokens.nextToken());
            int e = Integer.parseInt(tokens.nextToken());
            int w = Integer.parseInt(tokens.nextToken());

            graph.get(s).add(new Node(e, w));
        }
        app.dijkstra(start);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++) {
            if(dist[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(dist[i]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node head = queue.poll();

            int vertex = head.end;

            if(visited[vertex]) continue;
            visited[vertex] = true;

            for (Node node : graph.get(vertex)) {
                if(dist[node.end] > dist[vertex] + node.w) {
                    dist[node.end] = dist[vertex] + node.w;
                    queue.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int end;
        int w;

        public Node(int end, int w) {
            this.end = end;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}