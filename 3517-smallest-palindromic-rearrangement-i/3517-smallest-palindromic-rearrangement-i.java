class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        char[] halfChars = s.substring(0, n / 2).toCharArray();
        
        Arrays.sort(halfChars);
        String sortedHalf = new String(halfChars);
        
        String middle = (n % 2 == 1) ? String.valueOf(s.charAt(n / 2)) : "";
        
        String reversedHalf = new StringBuilder(sortedHalf).reverse().toString();
        
        return sortedHalf + middle + reversedHalf;
    }
}