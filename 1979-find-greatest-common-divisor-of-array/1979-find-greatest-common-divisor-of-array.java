class Solution {
    public int findGCD(int[] nums) {
        int minElement = 1000;
        int maxElement = 1;

        for (int num : nums) {
            maxElement = Math.max(maxElement, num);
            minElement = Math.min(minElement, num);
        }

        return gcd(minElement, maxElement);
    }

    private int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}