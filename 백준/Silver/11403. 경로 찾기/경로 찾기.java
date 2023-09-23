import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for(int i=0; i<n; i++) {
            StringTokenizer tokens = new StringTokenizer(br.readLine());

            for(int j=0; j<n; j++) {
                graph[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }

        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                sb.append(graph[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}