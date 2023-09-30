import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<int[]> pQueue = new PriorityQueue<>((a, b) -> {
			if (a[0] == b[0]) return a[1] - b[1];
			else return a[0] - b[0];
		});
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i=0; i<n; i++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(tokens.nextToken());
			int y = Integer.parseInt(tokens.nextToken());
			
			pQueue.offer(new int[]{x, y});
		}
		
		for (int i=0; i<n; i++) {
			int[] head = pQueue.poll();
			System.out.println(head[0] + " " + head[1]);
		}
		br.close();
	}
}