import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main app = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();

        int[] locations = new int[n];

        for(int i=0; i<n; i++) {
            locations[i] = sc.nextInt();
        }
        Arrays.sort(locations);

        System.out.println(app.binarySearch(locations, c));
        sc.close();
    }

    private int binarySearch(int[] arr, int c) {
        int start = 1;
        int end = (arr[arr.length-1] - arr[0]) / (c-1);
        if(isValidDistance(end, arr, c)) return end;

        int max = 0;
        while(start <= end) {
            int mid = (start + end)/2;

            if(isValidDistance(mid, arr, c)) {
                start = mid + 1;
                max = Math.max(max, mid);
            }
            else end = mid - 1;
        }
        return max;
    }

    private boolean isValidDistance(int distance, int[] arr, int c) {
        int installedLocation = arr[0];
        int count = 1;
        for(int i=1; i<arr.length; i++) {
            if(arr[i] - installedLocation >= distance) {
                count++;
                installedLocation = arr[i];
            }
            if(count >= c) return true;
        }
        return false;
    }
}