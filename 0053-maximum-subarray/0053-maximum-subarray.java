class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int secMax = nums[0];

        for(int i=1;i<nums.length;i++) {
            max = Math.max(nums[i],max+nums[i]);
            secMax = Math.max(secMax,max);
        }
        return secMax;
    }
}