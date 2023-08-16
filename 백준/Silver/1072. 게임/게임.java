import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main app = new Main();
        Scanner sc = new Scanner(System.in);

        long x = sc.nextLong();
        long y = sc.nextLong();

        int ratio = app.getRatio(x, y);

        long start = 1;
        long end = Integer.MAX_VALUE;

        boolean changed = false;
        while (start < end) {
            long mid = (start+end) / 2;
            if(app.getRatio(x + mid, y + mid) == ratio) start = mid + 1;
            else {
                end = mid;
                changed = true;
            }
        }

        if(changed) System.out.println(end);
        else System.out.println(-1);
    }

    private int getRatio(long x, long y) {
        Long ratio = (y * 100) / x;
        return ratio.intValue();
    }
}
