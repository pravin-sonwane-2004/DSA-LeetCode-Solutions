class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left =0 ;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        for(int i=0;i<nums.length;i++) {
            sum+=nums[i];
            while(sum >= target) {
            minLength = Math.min(minLength,i-left+1);
                sum -= nums[left++];
            }
        }
         return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}

// class Solution {
//     public int minSubArrayLen(int target, int[] nums) {

//             int left = 0;
//             int sum =0;
//             int minLen = Integer.MAX_VALUE;

//         for(int i=0;i<nums.length;i++) {
//             sum += nums[i];
//             while(sum >=target) {
//                     minLen = Math.min(minLen, i - left + 1);
//                     sum -= nums[left];
//                     left++;
                
//             }
//         }
//           return minLen == Integer.MAX_VALUE ? 0 : minLen;
//     }
// }

// class Solution {
//     public int minSubArrayLen(int target, int[] nums) {
//         int left = 0;
//         int sum = 0;
//         int min = Integer.MAX_VALUE;
//         for(int i =0;i<nums.length;i++) {
//             sum += nums[i];
//             while(sum >= target) {
//                 min = Math.min(min,i-left+1);
//                 sum -= nums[left];
//                 left++;
//             }
//         }
//         return min  == Integer.MAX_VALUE ? 0 : min;
//     }
// }