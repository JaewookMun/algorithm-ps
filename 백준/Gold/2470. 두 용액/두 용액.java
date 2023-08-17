import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        int answer = Integer.MAX_VALUE;
        int ans1 = 0;
        int ans2 = 0;
        for(int i=0; i<n-1; i++) {
            int current = arr[i];
            int target = current * -1;

            int start = i+1;
            int end = n;

            int gap = Integer.MAX_VALUE;
            int temp = 0;
            while(start < end) {
                int mid = (start + end) / 2;

                if(Math.abs(target - arr[mid]) < gap) {
                    gap = Math.abs(target - arr[mid]);
                    temp = arr[mid];
                }
                if(arr[mid] < target) start = mid + 1;
                else if(arr[mid] > target) end = mid;
                else {
                    temp = target;
                    break;
                }
            }

            int sum = Math.abs(arr[i] + temp);

            if(sum < answer) {
                answer = sum;
                ans1 = arr[i];
                ans2 = temp;
            }
        }
        if(ans1 < ans2) System.out.println(ans1 + " " + ans2);
        else System.out.println(ans2 + " " + ans1);
    }
}