package DynamicProgramming;

import java.util.Arrays;

public class RodCutting {
    public static int maxProfit(int[] length, int[] price, int totalRodLength){
        int n = length.length;
        int[][] dp = new int[n+1][totalRodLength+1];
        for(int i = 0 ; i<dp.length;i++){
            dp[i][0] = 0;
        }
        for(int j = 0 ; j < dp[0].length;j++){
            dp[0][j] = 0;
        }

        for(int i = 1 ; i < n+1 ; i++){
            for(int j = 0; j<totalRodLength+1;j++){
                if(length[i-1] <= j){
                    // valid condition
                    dp[i][j] = Math.max(price[i-1] + dp[i][j-length[i-1]] , dp[i-1][j]);
                }else{
                    // invalid condtion
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        // printing dp array
        System.out.println("DP Array is ");
        for(int i = 0 ; i<dp.length;i++)
            System.out.println(Arrays.toString(dp[i]));
        System.out.println("------------------------------------------");
        return dp[n][totalRodLength];
    }
    public static void main(String[] args) {
        int[] length = {1,2,3,4,5,6,7,8};
        int[] price = {1,5,8,9,10,17,17,20};
        int rodLength = 8;
        System.out.println("Max Profit: "+maxProfit(length,price,rodLength));
    }
}
