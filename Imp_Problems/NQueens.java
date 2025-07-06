import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        backtrack(results, new ArrayList<>(), n, 0);
        return results;
    }

    private void backtrack(List<List<String>> results, List<String> board, int n, int row) {
        if (row == n) {
            results.add(new ArrayList<>(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    sb.append(i == col ? 'Q' : '.');
                }
                board.add(sb.toString());
                backtrack(results, board, n, row + 1);
                board.remove(board.size() - 1);
            }
        }
    }

    private boolean isSafe(List<String> board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board.get(i).charAt(col) == 'Q') return false;
            if (col - (row - i) >= 0 && board.get(i).charAt(col - (row - i)) == 'Q') return false;
            if (col + (row - i) < board.size() && board.get(i).charAt(col + (row - i)) == 'Q') return false;
        }
        return true;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        int n = 4; // Change this value to test different sizes
        List<List<String>> solutions = nQueens.solveNQueens(n);
        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}