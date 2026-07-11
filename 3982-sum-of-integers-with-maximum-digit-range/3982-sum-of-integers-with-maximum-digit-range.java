// class Solution {
//     public int maxDigitRange(int[] nums) {
//         List<Integer>list = new ArrayList<>();
//         int digit =0 ;
//        for(int n : nums) {
//             if(findMaxDigit(n) - findMinDigit(n) > 0) {
//                 list.add(n);
//             }
//        } 
//     }
//     int findMaxDigit(int n) {
//         int max = 0;
//         while(n!=0) {
//             int  temp = n/10;
//             max = Math.max(max,temp);
//         }
//     }
//     int findMinDigit(int n) {
//         int max = 0;
//         while(n!=0) {
//             int  temp = n/10;
//             max = Math.min(max,temp);
//         }
//     }
// }
// class Solution {
//     public int maxDigitRange(int[] nums) {
//         int ans = 0;

//         for(int n : nums) {
//             int range = findMaxDigit(n) - findMinDigit(n);
//             ans = Math.max(ans, range);
//         }

//         return ans;
//     }

//     int findMaxDigit(int n) {
//         int max = 0;

//         while(n != 0) {
//             int digit = n % 10;
//             max = Math.max(max, digit);
//             n = n / 10;
//         }

//         return max;
//     }

//     int findMinDigit(int n) {
//         int min = 9;

//         while(n != 0) {
//             int digit = n % 10;
//             min = Math.min(min, digit);
//             n = n / 10;
//         }

//         return min;
//     }
// }

class Solution {
    public int maxDigitRange(int[] nums) {

        int maxRange = -1;
        int sum = 0;

        for(int n : nums) {

            int range = findMaxDigit(n) - findMinDigit(n);

            if(range > maxRange) {
                maxRange = range;
                sum = n;
            }
            else if(range == maxRange) {
                sum += n;
            }
        }

        return sum;
    }


    private int findMaxDigit(int n) {

        int max = 0;

        while(n > 0) {
            int digit = n % 10;
            max = Math.max(max, digit);
            n /= 10;
        }

        return max;
    }


    private int findMinDigit(int n) {

        int min = 9;

        while(n > 0) {
            int digit = n % 10;
            min = Math.min(min, digit);
            n /= 10;
        }

        return min;
    }
}