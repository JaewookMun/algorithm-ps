import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] sequence = new int[n];
        int[] dy = new int[n];
        for(int i=0; i<n; i++) {
            sequence[i] = sc.nextInt();
        }

        int solution = 1;
        dy[0] = 1;
        for(int i=1; i<n; i++) {
            int max = 0;
            for(int j=i-1; j>=0; j--) {
                if(sequence[j] < sequence[i] && dy[j] > max) max = dy[j];
            }
            dy[i] = max + 1;
            solution = Math.max(dy[i], solution);
        }

        System.out.println(solution);
    }
}
