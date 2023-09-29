import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        boolean[] used = new boolean[n];


        StringTokenizer tokens = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(tokens.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int idx = 0;

        for (int i=0; i<n; i++) {
            sb.append((idx + 1) + " ");
            int num = arr[idx];
            used[idx] = true;

            if (i == n-1) break;

            for (int j=0; j<Math.abs(num); j++) {
                if (num > 0) {
                    idx++;
                    if (idx >= arr.length) idx = 0;
                    while (used[idx]) {
                        idx++;
                        if (idx >= arr.length) idx = 0;
                    }
                }
                else if (num < 0) {
                    idx--;
                    if (idx < 0) idx = arr.length-1;
                    while (used[idx]) {
                        idx--;
                        if (idx < 0) idx = arr.length-1;
                    }
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}