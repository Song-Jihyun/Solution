//Time Complexity: O(stations.length)

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1, end = 1;
        int range = 2*w+1;
        for(int i=0; i<stations.length; i++){
            int station = stations[i];
            end = station - w;

            if(end > start){
                int black = end - start;
                answer += black/range;
                answer += black%range == 0 ? 0 : 1;
            }
            start = station + w + 1;
        }
        if(start <= n){
            int black = n+1 - start;
            answer += black/range;
            answer += black%range == 0 ? 0 : 1;
        }
        return answer;
    }
}
