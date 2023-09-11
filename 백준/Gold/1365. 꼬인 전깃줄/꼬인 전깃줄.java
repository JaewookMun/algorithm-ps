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
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(tokens.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        for(int i=1; i<n; i++) {
            int element = arr[i];
            if(element > list.get(list.size()-1)) list.add(element);
            else if(element < list.get(list.size()-1)) {
                int start = 0;
                int end = list.size();

                while(start < end) {
                    int mid = (start + end) / 2;

                    if(list.get(mid) < element) start = mid + 1;
                    else end = mid;
                }

                list.set(end, Integer.valueOf(element));
            }
        }

        System.out.println(arr.length - list.size());
        br.close();
    }
}