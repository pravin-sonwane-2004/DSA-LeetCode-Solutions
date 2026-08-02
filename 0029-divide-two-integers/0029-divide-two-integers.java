class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        int absDividend = dividend < 0 ? dividend : -dividend;
        int absDivisor = divisor < 0 ? divisor : -divisor;

        int quotient = 0;

        while (absDividend <= absDivisor) {
            int currentDivisor = absDivisor;
            int numDivisors = 1;

            while (currentDivisor >= (Integer.MIN_VALUE >> 1) && absDividend <= (currentDivisor << 1)) {
                currentDivisor <<= 1;
                numDivisors <<= 1;
            }

            absDividend -= currentDivisor;
            quotient += numDivisors;
        }

        return isNegative ? -quotient : quotient;
    }
}
