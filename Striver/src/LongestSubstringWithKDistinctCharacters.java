import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctCharacters {

    public static int maxLenSubstringNaive(String str, int k){
        Map<Character, Integer> map = new HashMap<>();

        int maxLen = 0;
        for(int i = 0; i < str.length(); i++){
            for(int j = i; j < str.length(); j++){
                map.put(str.charAt(j), map.getOrDefault(str.charAt(i), 0) + 1);

                if(map.size() > k) break;

                maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return maxLen;
    }

    // TC: O(2N)   SC: O(256)
    public static int maxLenSubstringOptimal(String str, int k){
        Map<Character, Integer> map = new HashMap<>();

        int maxLen = 0;
        int l = 0;
        int r = 0;

        while (r < str.length()){
            map.put(str.charAt(r), map.getOrDefault(str.charAt(r), 0) + 1);

            while (map.size() > k){
                map.put(str.charAt(l), map.get(str.charAt(l)) - 1);
                if(map.get(str.charAt(l)) == 0) map.remove(str.charAt(l));
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String str = "aacabbccd";
        int k = 2;

        System.out.println(maxLenSubstringOptimal(str, k));
    }
}
