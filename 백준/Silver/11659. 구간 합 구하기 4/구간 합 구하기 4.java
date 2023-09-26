import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokens = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokens.nextToken());
        int m = Integer.parseInt(tokens.nextToken());

        int[] arr = new int[n];

        tokens = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(tokens.nextToken());

        for (int i=1; i<n; i++) arr[i] = Integer.parseInt(tokens.nextToken()) + arr[i-1];

        StringBuilder sb = new StringBuilder();
        for(int t=0; t<m; t++) {
            tokens = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tokens.nextToken()) - 1;
            int b = Integer.parseInt(tokens.nextToken()) - 1;

            int sum;
            if(a > 0) sum = arr[b] - arr[a-1];
            else sum = arr[b];

            sb.append(sum + "\n");
        }

        System.out.println(sb);
        br.close();
    }
}