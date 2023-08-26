import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> mockQueue = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            String command = br.readLine();

            if(command.indexOf("push") != -1) mockQueue.add(Integer.parseInt(command.split(" ")[1]));
            else if(command.equals("pop")) {
                if(mockQueue.isEmpty()) sb.append(-1).append("\n");
                else sb.append(mockQueue.remove(0)).append("\n");
            }
            else if(command.equals("size")) sb.append(mockQueue.size()).append("\n");
            else if(command.equals("empty")) {
                if(mockQueue.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
            else if(command.equals("front")) {
                if(mockQueue.isEmpty()) sb.append(-1).append("\n");
                else sb.append(mockQueue.get(0)).append("\n");
            } else if (command.equals("back")) {
                if(mockQueue.isEmpty()) sb.append(-1).append("\n");
                else sb.append(mockQueue.get(mockQueue.size()-1)).append("\n");
            }
        }
        System.out.println(sb);
    }
}