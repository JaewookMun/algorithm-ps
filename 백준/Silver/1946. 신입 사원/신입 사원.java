import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        ArrayList<int[]> list = new ArrayList<>();
        for(int t=0; t<tc; t++) {
            int n = Integer.parseInt(br.readLine());

            StringTokenizer tokens;
            for(int i=0; i<n; i++) {
                tokens = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(tokens.nextToken());
                int b = Integer.parseInt(tokens.nextToken());
                list.add(new int[]{a, b});
            }

            Collections.sort(list, Comparator.comparing(a -> a[0]));

            int[] docFirst = list.get(0);
            int count = 1;
            int interviewRank = docFirst[1];
            for (int i=1; i<list.size(); i++) {
                if (list.get(i)[1] < interviewRank) {
                    count++;
                    interviewRank = list.get(i)[1];
                }
            }

            sb.append(count + "\n");
            list.clear();
        }

        System.out.println(sb);
        br.close();
    }
}