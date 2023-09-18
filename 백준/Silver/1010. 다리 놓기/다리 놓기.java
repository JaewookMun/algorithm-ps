import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int t=0; t<tc; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            long k=1;
            for(int i=1; i<=m; i++) {
                if(i <= n) numbers.add(i);

                if(i > m-n) {
                    int num = -1;
                    for(int j=0; j<numbers.size(); j++) {
                        if(i % numbers.get(j) == 0) {
                            num = numbers.remove(j);
                            k *= (i/num);
                            break;
                        }
                    }

                    if(num == -1) k *= i;
                }
            }
            long temp = numbers.stream().reduce(1, (a,b) -> a*b);

            sb.append(k / temp).append("\n");
            numbers.clear();
        }
        System.out.println(sb);
        sc.close();
    }
}
