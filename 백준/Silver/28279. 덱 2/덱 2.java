import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            String cmd = br.readLine();

            if (cmd.contains(" ")) {
                String[] pair = cmd.split(" ");

                if (pair[0].equals("1")) deque.offerFirst(Integer.parseInt(pair[1]));
                else deque.offer(Integer.parseInt(pair[1]));
            }
            else {
                int k = Integer.parseInt(cmd);
                if (k == 3) {
                    if (!deque.isEmpty()) sb.append(deque.poll() + "\n");
                    else sb.append(-1 + "\n");
                }
                else if (k == 4) {
                    if (!deque.isEmpty()) sb.append(deque.pollLast() + "\n");
                    else sb.append(-1 + "\n");
                }
                else if (k == 5) sb.append(deque.size() + "\n");
                else if (k == 6) {
                    if(deque.isEmpty()) sb.append(1 + "\n");
                    else sb.append(0 + "\n");
                }
                else if (k == 7) {
                    if(!deque.isEmpty()) sb.append(deque.peek() + "\n");
                    else sb.append(-1 + "\n");
                }
                else if (k == 8) {
                    if(!deque.isEmpty()) sb.append(deque.peekLast() + "\n");
                    else sb.append(-1 + "\n");
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}