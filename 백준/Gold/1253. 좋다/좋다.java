import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(tokens.nextToken());
        }
        Arrays.sort(arr);

        int count = 0;
        for(int i=0; i<n; i++) {
            int target = arr[i];

            int lp = i == 0 ? 1 : 0;
            int rp = i == n-1 ? n-2 : n-1;

            while(lp < rp) {
                int sum = arr[lp] + arr[rp];

                if(sum == target) {
                    count++;
                    break;
                }

                if(sum > target) rp = rp-1 == i ? rp - 2 : rp-1;
                else if(sum < target) lp = lp+1 == i ? lp + 2 : lp+1;
            }
        }

        System.out.println(count);
        br.close();
    }
}
