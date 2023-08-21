import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t=0; t<tc; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            StringTokenizer tokens = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(tokens.nextToken());
            }
            Arrays.sort(arr);

            int m = Integer.parseInt(br.readLine());
            tokens = new StringTokenizer(br.readLine());

            for(int i=0; i<m; i++) {
                int target = Integer.parseInt(tokens.nextToken());

                int start = 0;
                int end = n-1;

                boolean isPresent = false;

                while(start<end) {
                    int mid = (start+end) / 2;

                    if(arr[mid] < target) start = mid + 1;
                    else if(arr[mid] > target) end = mid - 1;
                    else {
                        isPresent = true;
                        break;
                    }
                }
                if(end < 0) end = 0;

                if(isPresent || arr[end] == target) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
        }

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(sb.toString());
        writer.flush();
        br.close();
    }
}
