import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] alphabet = new int[26];

        for (int i=0; i<n; i++) {
            String word = sc.next();

            for (int j=0; j<word.length(); j++) {
                char character = word.charAt(j);
                alphabet[character - 'A'] += Math.pow(10, word.length()-1-j);
            }
        }
        Arrays.sort(alphabet);

        int sum = 0;
        for (int i=alphabet.length-1, v=9; i>=0; i--, v--) {
            if (v < 0) break;
            sum += alphabet[i] * v;
        }

        System.out.println(sum);
        sc.close();
    }
}
