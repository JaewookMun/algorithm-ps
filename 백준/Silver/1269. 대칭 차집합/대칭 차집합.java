import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokens = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokens.nextToken());
        int m = Integer.parseInt(tokens.nextToken());

        Map<String, Boolean> a = new HashMap<>();
        Map<String, Boolean> b = new HashMap<>();

        tokens = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) a.put(tokens.nextToken(), true);

        tokens = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) b.put(tokens.nextToken(), true);

        Queue<String> keys = new LinkedList<>();
        for (String key : a.keySet()) {
            if(b.containsKey(key)) keys.offer(key);
        }

        keys.forEach(key -> {
            a.remove(key);
            b.remove(key);
        });

        System.out.println(a.size() + b.size());
        br.close();
    }
}