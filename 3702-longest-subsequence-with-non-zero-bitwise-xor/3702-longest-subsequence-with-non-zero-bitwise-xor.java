class Solution {
    public int longestSubsequence(int[] nums) {

        int xor = 0;
        boolean hasNonZero = false;

        for (int num : nums) {
            xor ^= num;

            if (num != 0) {
                hasNonZero = true;
            }
        }

        // Entire array has non-zero XOR
        if (xor != 0) {
            return nums.length;
        }

        // Total XOR is 0, but we can remove one non-zero element
        if (hasNonZero) {
            return nums.length - 1;
        }

        // All elements are zero
        return 0;
    }
}