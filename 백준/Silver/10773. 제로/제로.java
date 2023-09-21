import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++) {
            int num = sc.nextInt();
            if(num == 0) stack.pop();
            else stack.push(num);
        }

        System.out.println(stack.stream().mapToInt(e -> e.intValue()).sum());
        sc.close();
    }
}
