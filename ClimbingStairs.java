package DynamicProgramming;
import java.util.Arrays;
public class ClimbingStairs {
    public static int countWaysRecur(int n){
        if(n==0){
            return 1;
        }else if (n<0){
            return 0;
        }
        return countWaysRecur(n-1)+countWaysRecur(n-2);
    }
    public static int countWaysMemo(int n, int[] ways){ // O(n)
        if(n==0){
            return 1;
        }else if(n<0){
            return 0;
        }
        if(ways[n]!=-1){ // already calculated
            return ways[n];
        }

        ways[n] = countWaysMemo(n-1, ways)+countWaysMemo(n-2, ways);
        return ways[n];
    }
    public static int countWaysTabulation(int n){ // O(n)
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i<=n; i++){
            if(i==1){
                dp[i] = dp[i-1] + 0;
            }else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }

//    public static
    public static void main(String[] args) {
        int n = 5; // n=3 -> 3 and n=4 -> 5 => 8
        int[] ways = new int[n+1];
        Arrays.fill(ways,-1);
//        System.out.println(countWaysRecur(n));
        System.out.println(countWaysMemo(n,ways));
        System.out.println(countWaysTabulation(n));
    }
}
