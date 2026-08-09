class Solution {
    public String multiply(String num1, String num2) {
        // Handle edge case where either number is zero
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m + n];
        
        // Multiply each digit from right to left
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                
                // Indices for the current calculation
                int p1 = i + j;
                int p2 = i + j + 1;
                
                // Add to the existing value in the current position
                int sum = mul + pos[p2];
                
                // Update array with carry and current digit
                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }
        
        // Build the final string, skipping any leading zeros
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        
        return sb.toString();
    }
}