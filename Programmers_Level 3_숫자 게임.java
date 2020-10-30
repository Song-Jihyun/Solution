//Time Complexity: O(NlogN)

import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
    
        Arrays.sort(A);
        Arrays.sort(B);
        
        int be = A.length-1;
        
        for(int i = A.length-1; i >= 0; i--){
            if(A[i] < B[be]){
                be--;
                answer++;
            }
        }
        
        return answer;
    }
}
