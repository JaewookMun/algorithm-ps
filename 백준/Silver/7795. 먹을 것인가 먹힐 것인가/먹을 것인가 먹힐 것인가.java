import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Main app = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringBuilder answers = new StringBuilder();
        for(int t=0; t<tc; t++) {
            StringTokenizer tokens = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(tokens.nextToken());
            int m = Integer.parseInt(tokens.nextToken());

            int[] arr1 = new int[n];
            int[] arr2 = new int[m];

            tokens = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                arr1[i] = Integer.parseInt(tokens.nextToken());
            }

            tokens = new StringTokenizer(br.readLine());
            for(int i=0; i<m; i++) {
                arr2[i] = Integer.parseInt(tokens.nextToken());
            }
            Arrays.sort(arr2);

            int count = 0;
            for(int i=0; i<arr1.length; i++) {
                int idx = app.binarySearch(arr1[i], arr2);
                count += (idx - 0);
            }
            answers.append(count).append("\n");
        }

        System.out.println(answers);
        br.close();
    }

    private int binarySearch(int k, int[] arr) {
        int start = 0;
        int end = arr.length;

        while(start < end) {
            int mid = (start + end) / 2;

            if(arr[mid] < k) start = mid + 1;
            else end = mid;
        }

        return end;
    }
}