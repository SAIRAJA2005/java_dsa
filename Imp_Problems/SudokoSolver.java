import java.util.*;


// document the code

// This code implements a Sudoku solver using backtracking.
// It reads a Sudoku board from input, solves it, and prints the solved board.
// The board is represented as a 2D array of characters, where empty cells are denoted by '.'.
// The `solveSudoku` method attempts to fill the board recursively, checking for valid placements.


public class SudokoSolver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            String[] line = sc.nextLine().trim().split("\\s+");
            for (int j = 0; j < 9; j++) {
                board[i][j] = line[j].charAt(0);
            }
        }
        solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
                if (j < 8) System.out.print(" ");
            }
            System.out.println();
        }
    }
    

    // document the below function
    // The `solveSudoku` method attempts to solve the Sudoku puzzle by filling in empty cells.
    // It uses a backtracking approach, trying each number from '1' to '9' in each empty cell.


    public static boolean solveSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, row, col, c)) {
                            board[row][col] = c;
                            if (solveSudoku(board)) return true;
                            board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) return false;
            if (board[i][col] == c) return false;
            if (board[3*(row/3)+i/3][3*(col/3)+i%3] == c) return false;
        }
        return true;
    }
}

// give the process of the sudoku solver in the form of pseudo code
/*
 * Algorithm:
 * The Sudoku solver uses a backtracking algorithm to fill in the empty cells of the Sudoku board.
 * The rules are:
 * 1. Each number from 1 to 9 must appear exactly once in each row, column, and 3x3 subgrid.
 * 2. Empty cells are represented by '.'.
 * 
 * The solution involves recursively trying to place numbers in empty cells and checking if the placement is valid.
 * If a valid number is found, it proceeds to the next empty cell; if not, it backtracks and tries the next number.
 * 
 * The recursive solution can be described as follows:
 * 1. Find an empty cell (denoted by '.').
 * 2. For each number from '1' to '9':
 *    a. Check if placing the number in the empty cell is valid.
 *    b. If valid, place the number and recursively attempt to solve the rest of the board.
 *    c. If the recursive call returns true, the board is solved; if false, reset the cell and try the next number.
 * 3. If no numbers are valid for the empty cell, return false (backtrack).
 * 4. If all cells are filled correctly, return true.
 *
 * The time complexity of this algorithm is O(9^(n*n)), where n is the size of the board (9 for standard Sudoku).
 * The space complexity is O(n*n) due to the recursion stack and board storage.
 */

