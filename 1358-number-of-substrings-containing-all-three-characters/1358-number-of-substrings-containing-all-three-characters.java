// class Solution {
//     public int numberOfSubstrings(String s) {
//         int k = 3;
//         int count = 0;
//         int left = 0;
//         for(int i=1;i<s.length();i++) {
//             while(isIT(s.substring(left,i))) {
//                 count++;
//             }
//         }
//         return count;
//     }
//     boolean isIT(String st) {
//         if(st.contains("abc") || st.contains("cab") || st.contains("bac")) return true;
//         return false;
//     }
// }

class Solution {
    public int numberOfSubstrings(String s) {
        int[] freq = new int[3]; // a, b, c
        int left = 0;
        int count = 0;

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'a']++;

            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                count += s.length() - right;
                freq[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return count;
    }
}