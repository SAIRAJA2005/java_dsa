import java.util.*;

public class CoinChange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        int amount = sc.nextInt();
        int result = coinChange(coins, amount);
        System.out.println(result);
        sc.close();
    }

    public static int coinChange(int[] coins, int amount) {
        // Use amount + 1 as a sentinel value for "infinity", since the max number of
        // coins can't exceed the amount itself (if a coin of value 1 is used).
        int max = amount + 1;
        // dp[i] will store the minimum number of coins to make amount i.
        int[] dp = new int[amount + 1];
        // Initialize all amounts to our "infinity" value.
        Arrays.fill(dp, max);
        // Base case: It takes 0 coins to make an amount of 0.
        dp[0] = 0;
        // Build the solution from the bottom up for each amount from 1 to the target.
        for (int i = 1; i <= amount; i++) {
            // For each amount, check each available coin.
            for (int coin : coins) {
                if (i - coin >= 0) {
                    // The minimum coins for amount 'i' is the minimum of its current value
                    // and 1 (for the current coin) + the coins needed for the remaining amount.
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        // If dp[amount] is still the "infinity" value, it means the amount cannot be made.
        return dp[amount] > amount ? -1 : dp[amount];
    }
}