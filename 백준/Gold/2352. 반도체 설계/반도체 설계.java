import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Main app = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(tokens.nextToken());
        }

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(arr[0]);

        for(int i=1; i<n; i++) {
            int element = arr[i];
            if(element > numbers.get(numbers.size()-1)) numbers.add(element);
            else {
                int lowerBound = app.binarySearch(numbers, element);
                numbers.set(lowerBound, element);
            }
        }

        System.out.println(numbers.size());
        br.close();
    }

    private int binarySearch(ArrayList<Integer> numbers, int target) {

        int start = 0;
        int end = numbers.size();

        while(start < end) {
            int mid = (start + end) / 2;

            if(numbers.get(mid) < target) start = mid + 1;
            else end = mid;
        }

        return end;
    }
}