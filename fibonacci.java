package DynamicProgramming;

public class fibonacci {
    public static int fibMemoization(int n, int[] dp){
        if(n == 1 || n==0){
            return n;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        dp[n] = fibMemoization(n-1,dp)+fibMemoization(n-2,dp);
        return dp[n];
    }

    public static int fibTabulation(int n){
        int[] dp = new int[n+1];
        // no need to initialize dp[0] = 0 as already in java all values are default set to 0
        dp[1] = 1;
        for(int i = 2; i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];

    }
    public static void main(String[] args) {
        int n = 6;
        int[] f= new int[n+1];
        System.out.println(fibMemoization(n,f));
        System.out.println(fibTabulation(6));
    }


}
