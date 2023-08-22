import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer tokens = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(tokens.nextToken());
        }

        ArrayList<Integer> list = new ArrayList<>();

        list.add(arr[0]);

        for(int i=1; i<n; i++) {
            if(list.get(list.size()-1) < arr[i]) list.add(arr[i]);
            else {
                int idx = binarySearch(arr[i], list);
                list.set(idx, arr[i]);
            }
        }

        System.out.println(list.size());

    }

    public static int binarySearch(int target, ArrayList<Integer> list) {
        int start = 0;
        int end = list.size()-1;

        while(start < end) {
            int mid = (start + end) / 2;

            if(target > list.get(mid)) start = mid + 1;
            else if(target < list.get(mid)) end = mid;
            else return mid;
        }

        return end;
    }
}
