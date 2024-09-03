package DynamicProgramming;
import java.util.*;

public class LongestIncreasingSubsequence {
    // LIS
    public static int lis(int[] arr1){
        HashSet<Integer> set = new HashSet<>();
        for(int num : arr1){
            set.add(num);
        }

        int[] arr2 = new int[set.size()];
        int i = 0;
        for(int num: set){
            arr2[i] = num;
            i++;
        }

        Arrays.sort(arr2);

        return lcs(arr1,arr2);
    }

    private static int lcs(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        int[][] dp = new int[n+1][m+1];
        for(int row = 0; row<dp.length;row++){
            dp[row][0] = 0;
        }
        for(int col = 0; col<dp[0].length;col++){
            dp[0][col] = 0;
        }

        for(int row = 1; row < dp.length;row++){
            for(int col = 1 ; col < dp[0].length; col++){
                if(arr1[row-1] == arr2[col-1]){
                    dp[row][col] = dp[row-1][col-1]+1;
                }else{
                    int ans1 = dp[row][col-1];
                    int ans2 = dp[row-1][col];
                    dp[row][col] = Math.max(ans1,ans2);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        int[] arr = {50,3,10,7,40,80};
        System.out.println(lis(arr));
    }
}
