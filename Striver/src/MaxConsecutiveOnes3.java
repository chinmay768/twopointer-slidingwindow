public class MaxConsecutiveOnes3 {

    public int longestOnesNaive(int[] nums, int k) {
        int maxLen = 0;

        for(int i = 0; i < nums.length; i++){
            int zeroes = 0;

            for(int j = i; j < nums.length; j++){
                if(nums[j] == 0) zeroes++;

                if(zeroes > k) break;

                maxLen = Math.max(maxLen, j - i + 1);
            }
        }

        return maxLen;
    }

    // TC: O(2N)  SC: O(1)
    public int longestOnesBetter(int[] nums, int k){
        int left = 0;
        int right = 0;
        int maxLen = 0;

        int zeroCount = 0;

        while (right < nums.length){
            if(nums[right] == 0) zeroCount++;

            while (zeroCount > k){
                if(nums[left] == 0) zeroCount--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }

    public static void main(String[] args) {

    }
}
