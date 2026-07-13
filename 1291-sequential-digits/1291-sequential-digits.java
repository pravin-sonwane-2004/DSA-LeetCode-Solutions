class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 8; i++) {
            queue.add(i);
        }
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            
            if (curr >= low && curr <= high) {
                result.add(curr);
            }
            
            int lastDigit = curr % 10;
            if (lastDigit < 9) {
                int nextNum = curr * 10 + (lastDigit + 1);
                if (nextNum <= high) {
                    queue.add(nextNum);
                }
            }
        }
        Collections.sort(result);
        return result;
    }
}
