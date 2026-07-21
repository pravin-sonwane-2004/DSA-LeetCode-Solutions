
public class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int base = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                base++;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        int count = 0;
        String str = "1" + s + "1";
        int len = str.length();
        
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == '0') {
                count++;
            } else {
                if (count > 0) {
                    list.add(count);
                    count = 0;
                }
            }
        }
        
        int size = list.size();
        if (size < 2) {
            return base;
        }
        
        int best = 0;
        for (int i = 0; i < size - 1; i++) {
            int sum = list.get(i) + list.get(i + 1);
            if (sum > best) {
                best = sum;
            }
        }
        
        return base + best;
    }
}
