//Time Complexity: O(NlogN)

import java.util.Comparator;
import java.util.PriorityQueue;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        int[] dist = new int[N];
        dist[0] = 0;

        int[][] map = new int[N][N];
        for(int i=0; i<road.length; i++){
            int a = road[i][0] - 1;
            int b = road[i][1] - 1;
            int d = road[i][2];

            if(map[a][b] == 0 || map[a][b] > 0 && map[a][b] > d){
                map[a][b] = d;
                map[b][a] = d;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(road.length, new MyComparator());
        int[] start = {0, 0}; //{final village ,total distance}
        pq.add(start);

        while(!pq.isEmpty()){
            start = pq.poll();
            int startPoint = start[0];
            int totalDist = start[1];

            for(int i=1; i<N; i++){
                int newDist = map[startPoint][i];
                if(newDist == 0) continue;

                int newTotalDist = totalDist + newDist;
                if(dist[i] == 0 || newTotalDist < dist[i]){
                    dist[i] = newTotalDist;
                    int[] newStart = {i, newTotalDist};
                    pq.add(newStart);
                }
            }
        }

        for(int i=0; i<dist.length; i++) {
            if(dist[i] <= K)
                answer++;
        }

        return answer;
    }
}

class MyComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] a, int[] b){
        if(a[1] > b[1]) {
            return -1;
        }
        return 1;
    }
}
