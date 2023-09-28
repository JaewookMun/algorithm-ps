import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer tokens = new StringTokenizer(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<n; i++) {
            queue.offer(Integer.parseInt(tokens.nextToken()));
        }

        int order = 1;
        Stack<Integer> storage = new Stack<>();
        while (!queue.isEmpty() || !storage.isEmpty()) {
            if (!queue.isEmpty() && queue.peek() == order) {
                queue.poll();
                order++;
            }
            else if (!storage.isEmpty() && storage.peek() == order) {
                storage.pop();
                order++;
            } else {
                if (!queue.isEmpty()) storage.push(queue.poll());
                else break;
            }
        }

        String answer;

        if(order == n+1) answer = "Nice";
        else answer = "Sad";

        System.out.println(answer);
        br.close();
    }

}