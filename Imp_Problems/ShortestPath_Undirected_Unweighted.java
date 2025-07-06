import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ShortestPath_Undirected_Unweighted {

    public static int findTheShortest(int n , int m, List<List<Integer>>lst, boolean[] visited){
        Queue<List<Integer>>queue = new LinkedList<>();
        
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        List<List<Integer>>lst = new ArrayList<>();
        for(int i = 0 ; i < rows ; i++){
            List<Integer>row = new ArrayList<>();
            for(int j = 0 ; j < cols ; j++){
                row.add(scanner.nextInt());
            }
            lst.add(row);
        }

        boolean[] visited = new boolean[cols];
        int shortest = findTheShortest(rows, cols, lst, visited);

        System.out.println("The shortest path : " + shortest);

        scanner.close();
    }
}

