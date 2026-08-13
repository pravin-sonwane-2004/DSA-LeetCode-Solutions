class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        
        int min = nums[0];
        int max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        if (min == max) return 0;
        
        int n = nums.length;
        int bucketSize = Math.max(1, (max - min) / (n - 1));
        int bucketCount = (max - min) / bucketSize + 1;
        
        int[] minBucket = new int[bucketCount];
        int[] maxBucket = new int[bucketCount];
        java.util.Arrays.fill(minBucket, Integer.MAX_VALUE);
        java.util.Arrays.fill(maxBucket, Integer.MIN_VALUE);
        
        for (int num : nums) {
            int idx = (num - min) / bucketSize;
            minBucket[idx] = Math.min(minBucket[idx], num);
            maxBucket[idx] = Math.max(maxBucket[idx], num);
        }
        
        int maxGap = 0;
        int previousMax = min;
        
        for (int i = 0; i < bucketCount; i++) {
            if (minBucket[i] == Integer.MAX_VALUE) continue;
            maxGap = Math.max(maxGap, minBucket[i] - previousMax);
            previousMax = maxBucket[i];
        }
        
        return maxGap;
    }
}
