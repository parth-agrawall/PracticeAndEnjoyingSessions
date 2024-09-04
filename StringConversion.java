package DynamicProgramming;

public class StringConversion {
    public static int lcs(String original, String updated){
        int n = original.length();
        int m = updated.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 0 ;i< dp.length; i++){
            dp[i][0] = 0;
        }
        for(int j = 0 ;j < dp[0].length; j++){
            dp[0][j] = 0;
        }

        for(int i = 1 ; i<dp.length;i++){
            for(int j=1; j<dp[0].length;j++){
                if(original.charAt(i-1)==updated.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    public static int stringConversionOperations(String original, String updated){
        int deleteOperations = original.length() - lcs(original,updated);
        int addOperations = updated.length() - lcs(original, updated);
        return deleteOperations+addOperations;
    }

    public static void main(String[] args) {
        System.out.println(stringConversionOperations("pear","sea")+" operations required");
    }
}
