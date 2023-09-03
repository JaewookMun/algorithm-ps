import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main app = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int h = sc.nextInt();

        int[] top = new int[n/2];
        int[] bottom = new int[n/2];

        for(int i=0; i<n; i++) {
            if(i%2 == 0) bottom[i/2] = sc.nextInt();
            else top[i/2] = sc.nextInt();
        }
        Arrays.sort(top);
        Arrays.sort(bottom);

        int minCnt = Integer.MAX_VALUE;
        int sectionCnt = 0;

        for(int i=1; i<=h; i++) {
            int count = app.getBreakCount(bottom, i) + app.getBreakCount(top, h - (i-1));

            if(count < minCnt) {
                minCnt = count;
                sectionCnt = 1;
            }
            else if(count == minCnt) sectionCnt++;
        }

        System.out.println(minCnt + " " + sectionCnt);
        sc.close();
    }

    private int getBreakCount(int[] arr, int section) {
        int start = 0;
        int end = arr.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if(arr[mid] < section) start = mid + 1;
            else end = mid;
        }

        return arr.length - end;
    }
}