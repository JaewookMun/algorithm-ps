import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokens = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokens.nextToken());
        int l = Integer.parseInt(tokens.nextToken());

        tokens = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(tokens.nextToken());
        }

        Arrays.sort(arr);

        int start = arr[0];
        int cnt = 1;
        for (int i=1; i<arr.length; i++) {
            if (arr[i] - start < l) continue;
            else {
                start = arr[i];
                cnt++;
            }
        }

        System.out.println(cnt);
        br.close();
    }
}