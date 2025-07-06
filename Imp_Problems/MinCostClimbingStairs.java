
import java.util.Scanner;

public class MinCostClimbingStairs {

    public static int minCostClimbingStairs(int[] cost){
        int n = cost.length;
        if (n == 0) return 0;
        if (n == 1) return cost[0];
        
        int[] dp = new int[n + 1];
        dp[0] = 0; // Cost to reach step 0
        dp[1] = cost[0]; // Cost to reach step 1

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + (i < n ? cost[i - 1] : 0), dp[i - 2] + (i < n ? cost[i - 2] : 0));
        }

        return dp[n];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = scanner.nextInt();
        }
        System.out.println(minCostClimbingStairs(cost));
    }
}
