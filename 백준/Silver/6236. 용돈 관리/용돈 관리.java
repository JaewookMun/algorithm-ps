import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main app = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        int max = 0;
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }

        int start = max;
        int end = 100000 * 10000;

        while(start < end) {
            int mid = (start + end) / 2;

            int count = app.getCount(arr, mid);
            if(count > m) start = mid + 1;
            else end = mid;
        }

        System.out.println(end);
        sc.close();
    }

    private int getCount(int[] arr, int budget) {
        int cnt = 0;

        int sum = 0;
        for(int i=0; i<arr.length; i++) {
            if(sum + arr[i] > budget) {
                sum = 0;
                cnt++;
            }
            sum += arr[i];
        }
        if(sum != 0) cnt++;

        return cnt;
    }
}