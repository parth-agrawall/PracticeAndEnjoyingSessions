package DynamicProgramming;
// this question is the example of knapsack problem
public class TargetSumSubset {
    public static boolean findSubset(int[] arr, int sum){
        int n = arr.length;
        boolean [][] dp = new boolean[n+1][sum+1];
        for(int i = 0; i< dp.length; i++){
            dp[i][0] = true;
        }

        for(int i = 1 ; i < dp.length;i++){
            for(int j = 1; j<dp[0].length; j++){

                int v = arr[i-1];
                if(v <= j && dp[i - 1][j - v]){ // include

                    dp[i][j] = true;

                }else if(dp[i-1][j]){  // exclude

                    dp[i][j] = true;
                }
            }
        }
        return dp[n][sum];
    }
    public static void main(String[] args) {
        int[] arr = {4,2,7,1,3};
        int targetSum = 10;
        System.out.println(findSubset(arr,targetSum));
    }
}
