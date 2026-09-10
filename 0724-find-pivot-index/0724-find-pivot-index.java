class Solution {
    public int pivotIndex(int[] nums) {
       int n= nums.length;
       int t=0;
       for(int num:nums){
        t +=num;
       } 
       int ls=0;
       for(int i=0;i<n;i++){
        int rs=t-ls-nums[i];
        if(ls==rs){
        return i;
        }
        ls +=nums[i];
       }
       return -1;

    }
}   