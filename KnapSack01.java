package DynamicProgramming;

import java.util.Arrays;

public class KnapSack01 {
    public static int knapsackRecur(int[] val, int[] wt, int W, int n){
        if(n==0 || W==0){
            return 0;
        }
        if(wt[n-1] <= W){ // valid
            int ans1 = val[n-1] + knapsackRecur(val,wt,W - wt[n-1],n-1); //include
            int ans2 = knapsackRecur(val,wt, W, n-1); // exclude
            return Math.max(ans1,ans2);
        }else{
            return knapsackRecur(val,wt,W,n-1);
        }
    }

    public static int knapsackMemo(int[] val, int[] wt, int W, int n, int[][]dp){
        if(n == 0 || W == 0){
            return 0;
        }
        if(dp[n][W] != -1){
            return dp[n][W];
        }

        if(wt[n-1] <= W){  // valid
            // include
            int ans1 = val[n-1] + knapsackMemo(val,wt,W-wt[n-1],n-1,dp);
            // exclude
            int ans2 = knapsackMemo(val,wt,W,n-1,dp);

            dp[n][W] = Math.max(ans1,ans2);
            return dp[n][W];
        }else{            // invalid
            dp[n][W] = knapsackMemo(val,wt,W,n-1,dp);
            return dp[n][W];
        }
    }
    public static int knapsackTabulation(int[] val, int[] wt, int W){
        int n = val.length;
        int[][] dp = new int[n+1][W+1];
        for(int i = 0; i< dp.length;i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j<dp[0].length;j++){
            dp[0][j] = 0;
        }
        for(int i = 1; i<n+1;i++){
            int v = val[i-1];
            int w = wt[i-1];

            for(int j = 1; j<W+1;j++){
                if(w <= j){
                    // include
                    int includeProfit = v + dp[i-1][j-w];
                    // exclude
                    int excludeProfit = dp[i-1][j];
                    dp[i][j] = Math.max(includeProfit,excludeProfit);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        // displaying DP Table
        for(int i = 0; i<dp.length;i++){
            System.out.println(Arrays.toString(dp[i]));
        }

        return dp[n][W];
    }
    public static void main(String[] args) {
        // for recursion only
        /*
        int[] val = {15,14,10,45,30};
        int[] wt = {2,5,1,3,4};
        int W = 7;
        System.out.println(knapsackRecur(val,wt,W,val.length));
        */
//   --------------------------------------------------------------------------------------------------

        // Memoization Code

        int[] val = {15,14,10,45,30};
        int[] wt = {2,5,1,3,4};
        int W = 7;
        int[][] dp = new int[val.length+1][W+1];
        for(int i = 0; i<dp.length;i++){
            for(int j = 0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsackTabulation(val,wt,W));

    }
}
