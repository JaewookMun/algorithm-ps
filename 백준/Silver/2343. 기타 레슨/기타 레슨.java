import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokens.nextToken());
        int m = Integer.parseInt(tokens.nextToken());

        arr = new int[n];
        tokens = new StringTokenizer(br.readLine());

        long sum = 0;
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(tokens.nextToken());
            sum += arr[i];
        }

        long start = 1;
        long end = sum;
        if(n == 1) start = end = arr[0];
        while(start < end) {
            long mid = (start + end) / 2;
            int count = dividedCount(mid, m);

            if(count == -1 || count > m) start = mid + 1;
            else end = mid;
        }

        System.out.println(end);
    }

    private static int dividedCount(long mid, int m) {
        long sum = 0;
        int count = 1;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > mid) return -1;

            if(sum + arr[i] > mid) {
                count++;
                sum = arr[i];
            } else sum += arr[i];
            if(count > m) break;
        }

        return count;
    }
}
