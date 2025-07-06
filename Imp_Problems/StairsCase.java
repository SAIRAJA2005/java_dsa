public class StairsCase {

    public static int tabulation(int n) {
        if (n <= 1) return 1;
        int[] table = new int[n + 2];
        table[0] = 1;
        table[1] = 2;
        for (int i = 3; i <= n; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }
        return table[n];
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Enter the number of stairs: ");
        int n = scanner.nextInt();
        System.out.println("Tabulation: " + tabulation(n));
        scanner.close();
    }
    
}
