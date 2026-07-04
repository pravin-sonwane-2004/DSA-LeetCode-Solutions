class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Optional: Sorting helps prune unnecessary recursive branches early
        Arrays.sort(candidates); 
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentList, int[] candidates, int remain, int start) {
        if (remain == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remain) {
                break; 
            }

            currentList.add(candidates[i]);
            
            backtrack(result, currentList, candidates, remain - candidates[i], i);
            
            currentList.remove(currentList.size() - 1);
        }
    }
}
