import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];

        StringTokenizer tokens = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(tokens.nextToken());
        }
        Arrays.sort(arr);

        long min = Long.MAX_VALUE;

        long[] answer = new long[3];
        for(int i=0; i<n-2; i++) {
            long a = arr[i];
            for(int j=i+1; j<n-1; j++) {
                long b = arr[j];

                int start = j+1;
                int end = n;

                while(start < end) {
                    int mid = (start + end) / 2;
                    long sum = a + b + arr[mid];

                    if(sum == 0) {
                        answer[0] = a;
                        answer[1] = b;
                        answer[2] = arr[mid];
                        min = sum;
                        break;
                    }

                    if(Math.abs(sum) < min) {
                        answer[0] = a;
                        answer[1] = b;
                        answer[2] = arr[mid];
                        min = Math.abs(sum);
                    }

                    if(sum < 0) {
                        start = mid + 1;
                    } else end = mid;
                }
                if(min == 0) break;
            }
        }
        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
        br.close();
    }
}