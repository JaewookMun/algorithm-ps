import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> lis = new ArrayList<>();
        lis.add(arr[0]);
        for(int i=1; i<n; i++) {
            if(lis.get(lis.size()-1) < arr[i]) lis.add(arr[i]);
            else {
                int lowerBound = getLowerBound(lis, arr[i]);
                lis.set(lowerBound, arr[i]);
            }
        }
        System.out.println(lis.size());
        sc.close();
    }

    private static int getLowerBound(ArrayList<Integer> lis, int target) {
        int start = 0;
        int end = lis.size()-1;

        while(start < end) {
            int mid = (start + end) / 2;

            if(lis.get(mid) < target) start = mid + 1;
            else end = mid;
        }

        return start;
    }
}