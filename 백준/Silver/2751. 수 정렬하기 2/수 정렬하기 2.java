import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] sequence = new int[n];
		for(int i=0; i<n; i++) {
			sequence[i] = sc.nextInt();			
		}
		
		Arrays.sort(sequence);
		
        StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) sb.append(sequence[i]).append("\n");
        
        System.out.println(sb);
        sc.close();
	}
}