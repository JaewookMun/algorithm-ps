import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] seq = Arrays.copyOf(arr, arr.length);

        Arrays.sort(arr);
        Stack<Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        int j = 0;
        for(int i=0; i<n; i++) {

            stack.push(arr[i]);
            sb.append("+").append("\n");

            while(!stack.empty() && stack.peek().equals(seq[j])) {
                stack.pop();
                sb.append("-").append("\n");
                j++;
            }
        }

        if(!stack.empty()) System.out.println("NO");
        else System.out.println(sb);
        sc.close();
    }
}
