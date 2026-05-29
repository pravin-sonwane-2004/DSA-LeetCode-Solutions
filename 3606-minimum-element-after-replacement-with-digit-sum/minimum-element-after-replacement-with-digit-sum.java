class Solution {
    public int minElement(int[] nums) {
        int[] arr = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            arr[i] = digitSum(nums[i]);     
        }
        
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        
        return min;
    }
    
    private int digitSum(int n) {
        int sum = 0; 
        while (n != 0) {
            int temp = n % 10;
            sum += temp;       
            n /= 10;           
        } 
        return sum;
    }
}
