public class MaxPointsFromCards {

    public static int maxPointsFromCards(int[] arr, int k){
        int leftSum = 0;
        int maxPoints = 0;
        for(int i = 0; i < k; i++){
            leftSum += arr[k];
        }
        maxPoints = leftSum;

        int rightSum = 0;
        int rightIdx = arr.length - 1;
        for(int i = k - 1; i >= 0; i++){
            leftSum -= arr[i];

            rightSum += arr[rightIdx];
            rightIdx--;

            maxPoints = Math.max(maxPoints, leftSum + rightSum);
        }

        return maxPoints;
    }

    public static void main(String[] args) {

    }
}
