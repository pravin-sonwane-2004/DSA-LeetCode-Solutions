import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), results);
        return results;
    }

    private void backtrack(int[] candidates, int target, int start, 
                           List<Integer> current, List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates at the same depth level
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
            // Optimization: Stop if the current element exceeds the remaining target
            if (candidates[i] > target) {
                break;
            }

            current.add(candidates[i]);
            // Move to i + 1 because each number can only be used once
            backtrack(candidates, target - candidates[i], i + 1, current, results);
            current.remove(current.size() - 1);
        }
    }
}
