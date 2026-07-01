class Solution {
    public void moveZeroes(int[] nums) {
        int pointer = 0;
        for(int i=0;i<nums.length;i++) {
            if( nums[i] != 0) {
                nums[pointer] = nums[i];
                pointer++;
            }
        }
        while(pointer < nums.length) {
            nums[pointer] = 0;
            pointer++;
        }
    }
}