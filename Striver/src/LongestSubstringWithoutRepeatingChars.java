import java.util.Arrays;

public class LongestSubstringWithoutRepeatingChars {

    public int lengthOfLongestSubstring(String s) {
        int[] visited = new int[256];
        Arrays.fill(visited, -1);

        int left = 0;
        int right = 0;
        int maxLen = 0;
        while (right < s.length()){
            int lastSeenIdx = visited[s.charAt(right)];
            if(lastSeenIdx != -1 && lastSeenIdx >= left){
                left = visited[s.charAt(right)] + 1;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            visited[s.charAt(right)] = right;
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int i = 'A';
        System.out.println("a".compareTo("A"));
    }
}
