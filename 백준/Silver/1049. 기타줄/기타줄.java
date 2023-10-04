import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] set = new int[m];
        int[] one = new int[m];

        for (int i=0; i<m; i++) {
            set[i] = sc.nextInt();
            one[i] = sc.nextInt();
        }

        Arrays.sort(set);
        Arrays.sort(one);

        int min = 0;
        while (n >= 6 && set[0] <= one[0] * 6) {
            min += set[0];
            n -= 6;
        }

        if (set[0] > one[0] * 6) min += one[0] * n;
        else if (set[0] < one[0] * n) min += set[0];
        else min += one[0] * n;

        System.out.println(min);
        sc.close();
    }
}