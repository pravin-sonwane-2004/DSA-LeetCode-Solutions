class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int totalSize = m * n;
        
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            Integer[] temp = new Integer[n];
            Arrays.fill(temp, 0);
            result.add(Arrays.asList(temp));
        }
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int oldIndex = r * n + c;
                int newIndex = (oldIndex + k) % totalSize;
                int newRow = newIndex / n;
                int newCol = newIndex % n;
                
                result.get(newRow).set(newCol, grid[r][c]);
            }
        }
        
        return result;
    }
}
