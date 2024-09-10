package DynamicProgramming;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;
public class fibonacciMoreOptimised {
        public static void main(String[] args) throws IOException {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
            while (T-- > 0) {
                int n = sc.nextInt();
                Fibo obj = new Fibo();
                long topDownans = obj.topDown(n);
                long bottomUpans = obj.bottomUp(n);
                if (topDownans != bottomUpans)
                    System.out.println(-1);
                else
                    System.out.println(topDownans);
            }
        }
}

//{ Driver Code Starts
// Initial Template for Java



// } Driver Code Ends


// User function Template for Java

class Fibo {
    final static int mod = (int)1e9+7;
    static long topDown(int n) {
        // code here
        long[] dp = new long[n+1];
        // Arrays.fill(dp,-1);
        return memoization(n, dp);

    }
    static long memoization(int n, long[] dp){
        if(n==1 || n==0){
            return n;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        dp[n] = (memoization(n-1, dp) + memoization(n-2, dp)) % mod;
        if (dp[n] < 0) {
            return -1; // Overflow indicator
        }
        return dp[n];
    }

    static long bottomUp(int n) {
        // code here
        long[] dp = new long[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i] = (dp[i-1] + dp[i-2])%mod;
            if (dp[i] < 0) {
                return -1; // Overflow indicator
            }
        }
        return dp[n];
    }
}
