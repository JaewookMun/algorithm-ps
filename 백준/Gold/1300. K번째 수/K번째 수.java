import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long start = 1;
        long end = k;

        while (start < end) {
            long mid = (start + end) / 2;

            int count = 0; // count means index
            for(int i=1; i<=n; i++) {
                count += Math.min(mid / i, n);
            }

            if(count < k) start = mid + 1;
            else end = mid;
        }
        System.out.println(end);
        br.close();
    }
}