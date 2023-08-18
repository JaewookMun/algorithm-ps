import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	private static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws IOException {
		Main app = new Main();
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] dy = new int[n+1];
		dy[1] = 1;
		for(int i=2; i<=n; i++) {
			dy[i] = 2 * dy[i-1] + 1;
		}
		
		System.out.println(dy[n]);
		app.movePlates(n, 1, 3);
		
		BufferedOutputStream out = new BufferedOutputStream(System.out);
		byte[] bytes = sb.toString().getBytes();
		out.write(bytes);
		out.flush();		
	}
	
	private void movePlates(int n, int start, int end) {
		if(n > 1) movePlates(n-1, start, 6-start-end);
		
		sb.append(start + " " + end).append("\n");
		
		
		if(n > 1) movePlates(n-1, 6-start-end, end);
	}
}