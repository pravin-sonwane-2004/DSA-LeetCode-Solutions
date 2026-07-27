class Solution {
    public int maxProduct(int[] nums) {
        int max1 = 0;
        int max2 = 0;

        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }

        return (max1 - 1) * (max2 - 1);
    }
}

// class Solution {
//     public int maxProduct(int[] nums) {
//         int minIndex = 0;
//         int maxIndex= 0;
//         for(int i=1;i<nums.length;i++) {
//             minIndex = Math.max(minIndex,(nums[i]-i)*(nums[i-1]-(i-1)));
//             maxIndex = Math.max(maxIndex,minIndex);
//         }
//         return maxIndex;
//     }
// }