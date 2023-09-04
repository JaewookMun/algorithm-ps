import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            String line = br.readLine();

            if(line.contains(" ")) {
                stack.push(Integer.parseInt(line.split(" ")[1]));
            }
            else {
                int c = Integer.parseInt(line);

                if(c == 2) {
                    if(!stack.isEmpty()) answer.append(stack.pop()).append("\n");
                    else answer.append(-1).append("\n");
                }
                else if(c == 3) answer.append(stack.size()).append("\n");
                else if(c == 4) {
                    if(stack.isEmpty()) answer.append(1).append("\n");
                    else answer.append(0).append("\n");
                }
                else if (c == 5) {
                    if(!stack.isEmpty()) answer.append(stack.peek()).append("\n");
                    else answer.append(-1).append("\n");
                }
            }
        }

        System.out.println(answer);
        br.close();

    }
}
