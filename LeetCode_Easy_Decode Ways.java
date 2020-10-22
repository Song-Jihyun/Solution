//Solution 1. faster than 100.00% / memory less than 44.04%
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ret = new int[m+n];
        
        int idx = 0;
        int idx1 = 0;
        int idx2 = 0;
        
        while(idx1 < m || idx2 < n){
            if(idx1 == m){
                ret[idx] = nums2[idx2];
                idx2++;
            } 
            else if(idx2 == n){
                ret[idx] = nums1[idx1];
                idx1++;
            }
            else {
                ret[idx] = nums1[idx1] < nums2[idx2] ? nums1[idx1] : nums2[idx2];
                if(nums1[idx1] < nums2[idx2]) idx1++;
                else idx2++;
            }
            idx++;
        }
        
        for(int i=0; i<m+n; i++){
            nums1[i] = ret[i];
        }
    }
}
