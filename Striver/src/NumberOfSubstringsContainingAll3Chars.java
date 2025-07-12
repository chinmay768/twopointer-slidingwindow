public class NumberOfSubstringsContainingAll3Chars {

    // TC: O(N)
    public static int numberOfSubstrings(String s) {
        int aIdx = -1;
        int bIdx = -1;
        int cIdx = -1;

        int substringCnt = 0;

        for (int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'a'){
                aIdx = i;
            }else if(s.charAt(i) == 'b'){
                bIdx = i;
            }else{
                cIdx = i;
            }

            if(aIdx != -1 && bIdx != -1 && cIdx != -1){
                substringCnt += Math.min(aIdx, Math.min(bIdx, cIdx)) + 1;
            }
        }

        return substringCnt;
    }

    public static void main(String[] args) {
        String s = "abcabc";


    }
}
