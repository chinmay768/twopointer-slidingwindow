import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FruitInBasket {

    public static int maxFruitsNaive(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();

        int maxFruitsCount = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr.length; j++) {
                set.add(arr[j]);

                if(set.size() > k) break;

                maxFruitsCount = Math.max(maxFruitsCount, j - i + 1);
            }
            set.clear();
        }

        return maxFruitsCount;
    }

    // TC: O(2N)  SC: O(K)
    public static int maxFruitsOptimal(int[] arr, int k) {
        int l = 0;
        int r = 0;
        int maxFruitsCnt = 0;

        Map<Integer, Integer> map = new HashMap<>();

        while (r < arr.length){
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);

            while (map.size() > k){
                map.put(arr[l], map.get(arr[l]) - 1);
                if(map.get(arr[l]) == 0) map.remove(arr[l]);
                l++;
            }

            maxFruitsCnt = Math.max(maxFruitsCnt, r - l + 1);
            r++;
        }

        return maxFruitsCnt;
    }

    public static void main(String[] args) {

        int[] arr = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};

        System.out.println(maxFruitsOptimal(arr, 2));
    }
}
