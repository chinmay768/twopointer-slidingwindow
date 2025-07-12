import java.util.Arrays;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int maxLen = 0;
        int[] hash = new int[26];

        for(int i = 0; i < s.length(); i++){
            int maxFreqCharCnt = 0;
            for(int j = i; j < s.length(); j++){
                hash[s.charAt(j) - 'A']++;

                int currLen = j - i + 1;
                maxFreqCharCnt = Math.max(maxFreqCharCnt, hash[s.charAt(j) - 'A']);

                if(currLen - maxFreqCharCnt <= k){
                    maxLen = Math.max(maxLen, currLen);
                }else {
                    break;
                }
            }

            Arrays.fill(hash, 0);
        }
        return maxLen;
    }

    public static int characterReplacementBetter(String s, int k){
        int[] hash = new int[26];
        int maxLen = 0;

        int l = 0, r = 0;
        int maxFreqCharCnt = 0;

        while (r < s.length()){
            hash[s.charAt(r) - 'A']++;
            maxFreqCharCnt = Math.max(maxFreqCharCnt, hash[s.charAt(r) - 'A']);
            while (r - l + 1 - maxFreqCharCnt > k){
                hash[s.charAt(l) - 'A']--;
                maxFreqCharCnt = 0;
                for(int i = 0; i < hash.length; i++){
                    maxFreqCharCnt = Math.max(maxFreqCharCnt, hash[i]);
                }
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String str = "AABABBA";
        System.out.println(characterReplacementBetter(str, 2));
    }
}
