package DynamicProgramming;

public class UnboundedKnapsack01 {
    public static int unboundedSolution(int[] val, int[] wt, int W ){
        int n = val.length;
        int[][] dp = new int[n+1][W+1];

        for(int i = 0; i<dp.length;i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j<dp.length;j++){
            dp[0][j] = 0;
        }

        for(int i = 1; i<dp.length;i++){
            int v = val[i-1];
            int w = wt[i-1];
            for(int j = 1; j<dp[0].length;j++){
                if(w <= j) {
                    // valid
                    int includeProfit = v + dp[i][j-w]; // unbounded main difference
                    int excludeProfit = dp[i-1][j];
                    dp[i][j] = Math.max(includeProfit,excludeProfit);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }
    public static void main(String[] args) {
        int[] val = {15,14,10,45,30};
        int[] wt = {2,5,1,3,4};
        int W = 7;
        System.out.println(unboundedSolution(val,wt,W));
    }
}
