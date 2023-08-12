import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long m = sc.nextLong();
        long[] arr = new long[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextLong();
        }
        Arrays.sort(arr);

        System.out.println(binarySearch(m, arr));
        sc.close();
    }

    private static long binarySearch(long m, long[] arr) {
        long max = 0;

        long start = 1;
        long end = arr[arr.length - 1];

        while(start <= end) {
            long mid = (start + end) / 2;

            long len = 0;
            for(int i=0; i<arr.length; i++) {
                if(mid < arr[i]) {
                    len += (arr[i] - mid);
                    if(len >= m) {
                        start = mid + 1;
                        max = Math.max(max, mid);
                        break;
                    }
                }
            }
            if(len < m) end = mid - 1;
        }

        return max;
    }
}
