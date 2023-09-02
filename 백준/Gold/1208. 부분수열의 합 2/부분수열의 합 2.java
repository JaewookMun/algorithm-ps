import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        Main app = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokens.nextToken());
        int s = Integer.parseInt(tokens.nextToken());
        arr = new int[n];

        tokens = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(tokens.nextToken());
        }

        ArrayList<Integer> leftSub = new ArrayList<>();
        ArrayList<Integer> rightSub = new ArrayList<>();

        app.getSubSequence(0, n/2, 0, leftSub);
        app.getSubSequence(n/2, n, 0, rightSub);

        Collections.sort(leftSub);
        Collections.sort(rightSub);

        long count = app.getCount(s, leftSub, rightSub);
        if(s == 0) count -= 1;

        System.out.println(count);
        br.close();
    }

    private long getCount(int s, ArrayList<Integer> leftSub, ArrayList<Integer> rightSub) {
        long count = 0;

        int lp = 0;
        int rp = rightSub.size()-1;

        while(lp < leftSub.size() && rp >=0) {
            long sum = leftSub.get(lp) + rightSub.get(rp);

            if(sum == s) {
                long cntA = 0;
                int a = leftSub.get(lp);
                while(lp < leftSub.size() && leftSub.get(lp) == a){
                    lp++;
                    cntA++;
                }

                long cntB = 0;
                int b = rightSub.get(rp);
                while(rp >=0 && rightSub.get(rp) == b) {
                    rp--;
                    cntB++;
                }

                count += cntA * cntB;
            }
            else if(sum > s) rp--;
            else lp++;
        }

        return count;
    }

    /**
     *
     * @param idx - 수열에서 부분수열 대상으로 추가할지 여부를 판단하는 대상위치
     * @param end - 재귀의 종료 여부를 결정하는 인덱스 정보
     * @param sum - 부분수열의 합 (sum <= 4,000,000)
     * @param subSequence - 모든 부분수열의 합을 담는 리스트 객체
     */
    private void getSubSequence(int idx, int end, int sum, List<Integer> subSequence) {
        if(idx == end) {
            subSequence.add(sum);
            return;
        }

        getSubSequence(idx + 1, end,sum + arr[idx], subSequence);
        getSubSequence(idx + 1, end, sum, subSequence);
    }
}