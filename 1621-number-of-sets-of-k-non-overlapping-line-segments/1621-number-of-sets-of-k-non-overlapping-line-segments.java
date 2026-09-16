class Solution {
    public int numberOfSets(int n, int k) {
        long MOD = 1_000_000_007L;
        
        int totalElements = n + k - 1;
        int choose = 2 * k;
        
        // Edge case: if we need to choose more points than available
        if (choose > totalElements) {
            return 0;
        }
        
        long numerator = 1;
        long denominator = 1;
        
        // Calculate C(totalElements, choose)
        for (int i = 0; i < choose; i++) {
            numerator = (numerator * (totalElements - i)) % MOD;
            denominator = (denominator * (i + 1)) % MOD;
        }
        
        // Use Fermat's Little Theorem for modular inverse: denominator^(MOD - 2) % MOD
        long inverseDenominator = power(denominator, MOD - 2, MOD);
        
        return (int) ((numerator * inverseDenominator) % MOD);
    }
    
    // Helper function for modular exponentiation: (base^exp) % mod
    private long power(long base, long exp, long mod) {
        long result = 1;
        base = base % mod;
        
        while (exp > 0) {
            if ((exp & 1) == 1) { // If exp is odd
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1; // exp = exp / 2
        }
        
        return result;
    }
}
