class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] count = new int[3];
        for (int stone : stones) {
            count[stone % 3]++;
        }
        
        // If count of multiples of 3 is even
        if (count[0] % 2 == 0) {
            return Math.min(count[1], count[2]) > 0;
        }
        
        // If count of multiples of 3 is odd
        return Math.abs(count[1] - count[2]) > 2;
    }
}