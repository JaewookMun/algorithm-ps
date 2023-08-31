import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];

        StringTokenizer tokens = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(tokens.nextToken());
        }

        int max = 1;
        dp[0] = 1;
        for(int i=1; i<n; i++) {
            int temp = 0;
            for(int j=i-1; j>=0; j--) {
                if(arr[j] > arr[i]) temp = Math.max(temp, dp[j]);
            }

            dp[i] = temp + 1;
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
        br.close();
    }
}