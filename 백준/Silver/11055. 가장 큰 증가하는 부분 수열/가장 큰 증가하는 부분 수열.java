import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer tokens = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(tokens.nextToken());
        }

        int[] dp = new int[n];
        
        int max = dp[0] = arr[0];
        for(int i=1; i<n; i++) {

            int sum = 0;
            for(int j=0; j<i; j++) {
                if(arr[j] < arr[i]) sum = Math.max(sum, dp[j]);
            }
            dp[i] = sum + arr[i];
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
        br.close();
    }
}