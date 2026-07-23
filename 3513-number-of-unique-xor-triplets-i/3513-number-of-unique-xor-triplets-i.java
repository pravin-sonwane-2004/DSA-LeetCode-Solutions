class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        
        if (n < 3) {
            return n;
        }
        
        int highestBit = Integer.numberOfLeadingZeros(n);
        int bitLength = 32 - highestBit;
        
        return 1 << bitLength;
    }
}
