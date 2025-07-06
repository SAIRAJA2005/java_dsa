import java.util.Scanner;


public class NumberOfIslands {
    public static int dfs(int[][] arr, int i, int j, boolean[][] visited){
        if(i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || 
           arr[i][j] == 0 || visited[i][j]) {
            return 0; 
        }
    
        visited[i][j] = true;
    
        // Explore all four directions
        dfs(arr, i + 1, j, visited); // Down
        dfs(arr, i - 1, j, visited); // Up
        dfs(arr, i, j + 1, visited); // Right
        dfs(arr, i, j - 1, visited); // Left
    
        return 1;
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int[][] arr = new int[m][n];

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                arr[i][j] = scanner.nextInt();
            }
        }

        int cnt = 0;

        boolean[][] visited = new boolean[m][n];

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(arr[i][j] == 1 && !visited[i][j]){
                    dfs(arr , i, j, visited);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

        scanner.close();
    }
}