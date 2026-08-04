// class Solution {
//     public List<Integer> findMissingElements(int[] nums) {
//         List<Integer> list = new ArrayList<>();
//         Arrays.sort(nums);
//         int largest = findLargest(nums);
//         for(int i=0;i<nums.length;i++) {
//            int expected = 1;;
//             while(nums[i] != largest) {
//                 list.add(min);
//                 min++;
//             }
//             min++;
//         }
//         return list;
//     }
//     public int findLargest(int nums []) {
//         int max = 0;
//         for(int i=0;i<nums.length;i++) {
//             max = Math.max(max,nums[i]);
//         }
//         return max;
//     }
//      public int findSmallest(int nums []) {
//         int max = 1;
//         for(int i=0;i<nums.length;i++) {
//             max = Math.min(max,nums[i]);
//         }
//         return max;
//     }
// }

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            for (int x = nums[i] + 1; x < nums[i + 1]; x++) {
                ans.add(x);
            }
        }

        return ans;
    }
}