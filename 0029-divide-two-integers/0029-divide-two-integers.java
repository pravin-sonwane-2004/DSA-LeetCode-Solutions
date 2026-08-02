class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow case: -2147483648 / -1 = 2147483648 (over MAX_VALUE)
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the final quotient
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Convert both numbers to negative to prevent overflow during absolute conversion
        // (Integer.MIN_VALUE cannot be converted to a positive 32-bit int)
        int absDividend = dividend < 0 ? dividend : -dividend;
        int absDivisor = divisor < 0 ? divisor : -divisor;

        int quotient = 0;

        // Since numbers are negative, we check if dividend is less than or equal to divisor
        while (absDividend <= absDivisor) {
            int currentDivisor = absDivisor;
            int numDivisors = 1;

            // Double the divisor using left shifts until doubling it exceeds the dividend
            // To prevent overflow, check against half of Integer.MIN_VALUE before shifting
            while (currentDivisor >= (Integer.MIN_VALUE >> 1) && absDividend <= (currentDivisor << 1)) {
                currentDivisor <<= 1;
                numDivisors <<= 1;
            }

            // Subtract the max accumulated divisor value from the dividend
            absDividend -= currentDivisor;
            // Add the corresponding number of divisors to the quotient
            quotient += numDivisors;
        }

        // Return the final result with the proper sign applied
        return isNegative ? -quotient : quotient;
    }
}
