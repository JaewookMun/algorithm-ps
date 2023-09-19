import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<tc; t++) {
            String line = br.readLine();

            if(line.contains(" ")) queue.offer(Integer.parseInt(line.split(" ")[1]));
            else if (line.equals("pop")) {
                if (!queue.isEmpty()) sb.append(queue.pop() + "\n");
                else sb.append(-1 + "\n");
            }
            else if (line.equals("size")) sb.append(queue.size() + "\n");
            else if (line.equals("empty")) {
                if (!queue.isEmpty()) sb.append(0 + "\n");
                else sb.append(1 + "\n");
            }
            else if(line.equals("front")) {
                if (!queue.isEmpty()) sb.append(queue.peek() + "\n");
                else sb.append(-1 + "\n");
            }
            else if(line.equals("back")) {
                if (!queue.isEmpty()) sb.append(queue.peekLast() + "\n");
                else sb.append(-1 + "\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}