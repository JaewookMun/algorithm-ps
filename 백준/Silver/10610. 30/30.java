import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.next();

        int[] numbers = new int[10];

        int sum = 0;
        for (String s : n.split("")) {
            int idx = Integer.parseInt(s);
            numbers[idx]++;
            sum += idx;
        }

        if(!n.contains("0") || sum % 3 != 0) {
            System.out.println(-1);
            System.exit(0);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=9; i>=0; i--) {
            while(numbers[i] > 0) {
                sb.append(i);
                numbers[i]--;
            }
        }

        System.out.println(sb);
    }
}