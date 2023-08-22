import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringBuilder sentence = new StringBuilder();
        sentence.append(br.readLine());
        if(sentence.indexOf(".") != -1 && sentence.length() > 1) {
            sb.append(interpret(sentence.toString())).append("\n");
            sentence = new StringBuilder();
        }
        while(br.ready()) {
            sentence.append(br.readLine());
            if(sentence.indexOf(".") != -1 && sentence.length() > 1) {
                sb.append(interpret(sentence.toString())).append("\n");
                sentence = new StringBuilder();
            }
        }
        System.out.println(sb);
        br.close();
    }

    private static String interpret(String line) {
        Stack<String> stack = new Stack<>();

        String[] arr = line.split("");
        for(String s : arr) {
            if(s.equals("(") || s.equals("[")) stack.push(s);
            else if(s.equals(")")) {
                if(stack.empty()) return "no";

                if(stack.peek().equals("(")) stack.pop();
                else return "no";
            }
            else if(s.equals("]")) {
                if(stack.empty()) return "no";

                if(stack.peek().equals("[")) stack.pop();
                else return "no";
            }
        }

        return stack.isEmpty() ? "yes" : "no";
    }
}
