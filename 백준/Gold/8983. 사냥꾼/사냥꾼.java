import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        Main app = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokens = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokens.nextToken());
        int m = Integer.parseInt(tokens.nextToken());
        int l = Integer.parseInt(tokens.nextToken());

        arr = new int[n];
        ArrayList<int[]> grid = new ArrayList<>();

        tokens = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(tokens.nextToken());

        for(int i=0; i<m; i++) {
            tokens = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(tokens.nextToken());
            int y = Integer.parseInt(tokens.nextToken());

            grid.add(new int[]{x, y});
        }

        Arrays.sort(arr);
        Collections.sort(grid, Comparator.comparing(a -> ((int[]) a)[0]).thenComparing(b -> ((int[]) b)[1]));

        int count = 0;
        for(int[] coordinate : grid) {
            if(coordinate[1] > l) continue;

            if(app.reachable(coordinate, l)) count++;
        }

        System.out.println(count);
        br.close();
    }

    private boolean reachable(int[] coordinate, int l) {
        int x = coordinate[0];
        int y = coordinate[1];

        int start = 0;
        int end = arr.length;

        while(start < end) {
            int mid = (start + end) / 2;

            if(Math.abs(arr[mid] - x) + y <= l) return true;

            if(arr[mid] < x) start = mid + 1;
            else end = mid;
        }

        return false;
    }
}