class Solution {
    public String smallestSubsequence(String s) {
        int[] lastOccurrence = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }
        
        StringBuilder stack = new StringBuilder();
        boolean[] visited = new boolean[26];
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            int currIdx = curr - 'a';
            
            if (visited[currIdx]) continue;
            
            while (stack.length() > 0 && stack.charAt(stack.length() - 1) > curr 
                   && lastOccurrence[stack.charAt(stack.length() - 1) - 'a'] > i) {
                
                char removed = stack.charAt(stack.length() - 1);
                visited[removed - 'a'] = false;
                stack.deleteCharAt(stack.length() - 1);
            }
            
            stack.append(curr);
            visited[currIdx] = true;
        }
        
        return stack.toString();
    }
}
