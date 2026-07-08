// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         String line = "";
//         for(String str : wordDict) {
//             line = line.concat(str);
//             if(s.equals(str)){
//                 return true;
//             }
//         }
//         return false;
//     }
// }

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        
        dp[0] = true; 

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; 
                }
            }
        }
        
        return dp[n];
    }
}
