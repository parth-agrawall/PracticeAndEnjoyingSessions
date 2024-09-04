package DynamicProgramming;

public class MinOperationsReq {
    public static int operationsToConvert(String original, String updated){
        int n = original.length();
        int m = updated.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 0 ; i < n+1 ; i++){
            for(int j = 0 ; j < m+1 ; j++){
                if(i==0){
                    dp[i][j] = j;
                }
                if(j==0){
                    dp[i][j] = i;
                }
            }
        }

        for(int i = 1 ; i < dp.length ; i++){
            for(int j = 1 ; j < dp[0].length; j++){
                if(original.charAt(i-1) == updated.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int add = dp[i][j-1] + 1;
                    int del = dp[i-1][j] + 1;
                    int replace = dp[i-1][j-1] + 1;
                    dp[i][j] = Math.min(add, Math.min(del,replace));
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        System.out.println(operationsToConvert("abcd","aderw"));
    }

}
