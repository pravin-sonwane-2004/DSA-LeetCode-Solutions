class Solution {
    public int jump(int[] nums) {
        // Base case: If the array has 1 or fewer elements, 0 jumps are needed.
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        // Iterate through the array except for the last index.
        // We stop before the last index because once we reach or cross it, 
        // we don't need to initiate another jump.
        for (int i = 0; i < nums.length - 1; i++) {
            // Track the maximum reachable index from any point within the current jump range
            farthest = Math.max(farthest, i + nums[i]);

            // If we have reached the end of the current jump's range
            if (i == currentEnd) {
                jumps++;            // Make a jump
                currentEnd = farthest; // Update the boundary to the farthest reachable index

                // Optimization: If the new boundary already reaches or exceeds 
                // the last index, we can safely exit early.
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }
}
