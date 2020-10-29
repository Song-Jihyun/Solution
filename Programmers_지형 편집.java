//Time Complexity: O(land.length^2)

import java.util.HashMap;
import java.util.ArrayList;

public class Solution {
    public long solution(int[][] land, int P, int Q) {
        HashMap<Long, Long> map = new HashMap<>();
        ArrayList<Long> distinct = new ArrayList<>();

        long sum = 0;
        long len = land.length;

        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                sum += land[i][j];
                long curr = land[i][j];
                if(map.containsKey(curr)) map.replace(curr, map.get(curr)+1);
                else{
                    map.put(curr, (long)1);
                    distinct.add(curr);
                }
            }
        }

        distinct.sort(null);

        long small = 0;
        long same = 0;
        long large = sum;
        long before = 0;
        long roomNum = 0;

        long answer = Long.MAX_VALUE;

        for(long curr : distinct){
            small += (curr-before) * roomNum;
            same = map.get(curr);
            large -= (curr-before) * (len*len - roomNum);

            roomNum += same;
            answer = Math.min(answer, small*P + large*Q);
            before = curr;
        }

        return answer;
    }
}
