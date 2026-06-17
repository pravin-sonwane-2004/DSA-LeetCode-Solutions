// class Solution {
//     public int search(int[] nums, int target) {
//         if(nums.length == 1 && target == nums[0]) return 0;
//         int start =0;
//         int end = nums.length-1;
//         while(start<=end) {
//             int mid = (start + end) / 2;
//             if(target == nums[mid]) return mid;
//             else if(target<= nums[mid]) {
//                 end = mid-1;
//             }
//             else {
//                 start = mid +1;
//             }
//         }
//         return -1;
//     }
// }




class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1 && target == nums[0]) return 0;
        int start = 0;
        int end = nums.length-1;
        while(start<=end) {
            int mid = start + (end-start) /2;
            if(target==nums[mid]) return mid;
            else if(target < mid) {
                end = mid;
            }
            else {
                start  = mid+1;
            }
            start++;
            end--;
        }
        return -1;
    }
}