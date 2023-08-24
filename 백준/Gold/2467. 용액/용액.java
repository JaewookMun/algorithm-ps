import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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


        int left=0; int right=0;

        int min = Integer.MAX_VALUE;
        int lt = 0; int rt = arr.length-1;
        while(lt < rt) {
            if(lt == rt) break;

            int sum = arr[lt] + arr[rt];
            if(sum == 0) {
                left = arr[lt];
                right = arr[rt];
                break;
            }

            if(Math.abs(sum) < min) {
                left = arr[lt];
                right = arr[rt];
                min = Math.abs(sum);
            }

            if(sum < 0) lt++;
            else rt--;
        }

        System.out.println(left + " " + right);
        br.close();
    }
}