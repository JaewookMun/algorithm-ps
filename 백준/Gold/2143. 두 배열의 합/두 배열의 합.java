import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int target = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer tokens = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(tokens.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        tokens = new StringTokenizer(br.readLine());

        for(int i=0; i<m; i++){
            b[i] = Integer.parseInt(tokens.nextToken());
        }

        int[] arrA = new int[n*(n+1)/2];
        int[] arrB = new int[m*(m+1)/2];

        int idxA = 0;
        for(int i=0; i<n; i++) {
            int subSum = 0;
            for(int j=i; j<n; j++) {
                subSum += a[j];
                arrA[idxA++] = subSum;
            }
        }

        int idxB = 0;
        for(int i=0; i<m; i++) {
            int subSum = 0;
            for(int j=i; j<m; j++) {
                subSum += b[j];
                arrB[idxB++] = subSum;
            }
        }
        Arrays.sort(arrB);

        long count = 0;
        for(int i=0; i<arrA.length; i++) {
            int numB = target - arrA[i];

            int start = 0;
            int end = arrB.length-1;

            while(start < end) {
                int mid = (start + end) / 2;

                if(arrB[mid] < numB) start = mid + 1;
                else end = mid;
            }

            if(arrB[end] != numB) continue;

            int lowerBound = end;

            start = 0;
            end = arrB.length;

            while(start < end) {
                int mid = (start + end) / 2;

                if(arrB[mid] <= numB) start = mid + 1;
                else end = mid;
            }
            int upperBound = end;

            count += (upperBound - lowerBound);
        }
        System.out.println(count);
        br.close();
    }
}
