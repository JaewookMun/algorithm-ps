import java.util.ArrayList;

class Solution {
    private static ArrayList<int[]> list = new ArrayList<>();
    
    public int[][] solution(int n) {
        int[][] answer = {};
        
        changeLocation(n, 1, 3);
        answer = new int[list.size()][2];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);            
        }
        
        return answer;
    }
    
    private void changeLocation(int n, int a, int b){
        if(n > 1) {
            changeLocation(n-1, a, 6-a-b);
        }
        
        list.add(new int[]{a, b});
        
        if(n > 1) {
            changeLocation(n-1, 6-a-b, b);
        }      
    }
}