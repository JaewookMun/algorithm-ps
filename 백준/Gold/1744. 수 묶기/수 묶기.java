import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        List<Integer> zero = new ArrayList<>();
        int n = sc.nextInt();

        for (int i=0; i<n; i++) {
            int num = sc.nextInt();
            if (num > 0) pos.add(num);
            else if (num < 0) neg.add(num);
            else zero.add(num);
        }

        Collections.sort(pos, Comparator.reverseOrder());
        Collections.sort(neg);

        int sum = 0;
        for (int i=1; i<pos.size(); i+=2) {
            int a = pos.get(i-1);
            int b = pos.get(i);

            if (a==1 || b==1) sum += (a+b);
            else sum += (a*b);
        }
        if (pos.size()%2 == 1) sum += pos.get(pos.size() - 1);

        for (int i=1; i<neg.size(); i+=2) {
            sum += (neg.get(i-1) * neg.get(i));
        }
        if (neg.size()%2 == 1 && zero.isEmpty()) sum += neg.get(neg.size()-1);


        System.out.println(sum);
        sc.close();
    }
}