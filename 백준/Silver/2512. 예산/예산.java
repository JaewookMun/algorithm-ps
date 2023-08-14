import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int limit;
    private static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        limit = sc.nextInt();

        System.out.println(binarySearch());
        sc.close();
    }

    private static int binarySearch() {
        int start = 1;
        int end = arr[arr.length-1];

        if(isValidNumber(end)) return end;
        int max = 0;
        while(start<=end) {
            int mid = (start+end) / 2;
            if(isValidNumber(mid)) {
                start = mid + 1;
                max = Math.max(max, mid);
            }
            else end = mid - 1;
        }
        return max;
    }

    private static boolean isValidNumber(int num) {
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] <= num) sum += arr[i];
            else sum += num;

            if(sum > limit) break;
        }
        boolean isValid = sum <= limit ? true : false;

        return isValid;
    }
}