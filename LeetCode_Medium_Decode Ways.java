//Solution 1. faster than 6.53% / memory less than 14.41%

class Solution {
    public int numDecodings(String s) {
        int cache[] = new int[s.length()];
        return countDecodeWays(s, 0, cache);
    }
    
    int countDecodeWays(String s, int idx, int cache[]){
        if(idx == s.length()) return 1;
        if(cache[idx] != 0) return cache[idx];
        if(s.charAt(idx) == '0') return 0; // numbers cannot start with zero.
        
        String subs;
        int ret = 0;
        
        for(int i=1; idx+i <= s.length() ;i++){
            subs = s.substring(idx, idx+i);
            
            if(Integer.parseInt(subs) > 26) break;
            ret += countDecodeWays(s, idx+i, cache);
        }
        
        return cache[idx] = ret;
    }
}
