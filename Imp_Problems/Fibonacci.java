import java.util.Scanner;

public class Fibonacci {

    public static int memoization(int n, int[] dp){
        if(n <= 1) return n;
        if(dp[n] != 0) return dp[n];
        return dp[n] = memoization(n - 1, dp) + memoization(n - 2, dp);
    }

    public static int tabulation(int n){
        int[] table = new int[n + 1];
        table[0] = 0;
        if(n > 0) table[1] = 1;
        for(int i = 2 ; i <= n ; i++){
            table[i] = table[i - 1] + table[i - 2];
        }
        return table[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your Fibonacci number index: ");
        int n = scanner.nextInt();
        int[] dp = new int[n + 1];
        System.out.println("Memoization: " + memoization(n , dp));
        System.out.println("Tabulation: " + tabulation(n));
        scanner.close();
    }
}
