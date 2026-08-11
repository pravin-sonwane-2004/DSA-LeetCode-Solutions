public class Solution {
    public int missingInteger(int[] nums) {
        int prefixSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                prefixSum += nums[i];
            } else {
                break; 
            }
        }
        
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        
        while (numSet.contains(prefixSum)) {
            prefixSum++;
        }
        
        return prefixSum;
    }
}