//Time Complexity: O(N^2)

class Solution {
    public int solution(String dirs) {
        int answer = 0;

        String dir = "UDRL";
        int[] dirx = {-1, 1, 0, 0};
        int[] diry = {0, 0, 1, -1};

        boolean map[][] = new boolean[21][21];
        int x = 10;
        int y = 10;

        for(int i=0; i<dirs.length(); i++){
            char d = dirs.charAt(i);
            x += dirx[dir.indexOf(d)];
            y += diry[dir.indexOf(d)];

            if(!(x < 0 || x >= 21 || y < 0 || y >= 21)) map[x][y] = true;

            x += dirx[dir.indexOf(d)];
            y += diry[dir.indexOf(d)];

            x = Math.max(x, 0);
            x = Math.min(x, 20);
            y = Math.max(y, 0);
            y = Math.min(y, 20);          
        }

        for(int i=0; i<map.length; i++){
            for(int j=0; j<map.length; j++){
                if(map[i][j]) answer++;
            }
        }

        return answer;
    }
}
