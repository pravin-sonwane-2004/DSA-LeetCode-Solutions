class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int leftSum = 0;
        int rightSum = 0;
        int leftQ = 0;
        int rightQ = 0;

        // Process the first half of the string
        for (int i = 0; i < n / 2; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                leftQ++;
            } else {
                leftSum += c - '0';
            }
        }

        // Process the second half of the string
        for (int i = n / 2; i < n; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                rightQ++;
            } else {
                rightSum += c - '0';
            }
        }

        // Bob can only win if the sum difference matches the question mark difference scaled by 4.5
        // To avoid floating-point math, we multiply by 2: (leftSum - rightSum) * 2 == (rightQ - leftQ) * 9
        // If this equation holds, Bob wins (return false), else Alice wins (return true).
        return (leftSum - rightSum) * 2 != (rightQ - leftQ) * 9;
    }
}
