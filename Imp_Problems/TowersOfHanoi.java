/*
 * Algorithm:
 * The Towers of Hanoi is a classic problem that involves moving a set of disks from one peg to another, using an auxiliary peg.
 * The rules are:
 * 1. Only one disk can be moved at a time.
 * 2. A disk can only be moved if it is the uppermost disk on a peg.
 * 3. No disk may be placed on top of a smaller disk.
 * 
 * The solution involves recursively moving the disks between the pegs.
 * The number of moves required to solve the problem with n disks is 2^n - 1.
 * 
 * The recursive solution can be described as follows:
 * 1. Move the top n-1 disks from the source peg to the auxiliary peg.
 * 2. Move the nth disk from the source peg to the destination peg.
 * 3. Move the n-1 disks from the auxiliary peg to the destination peg.
 * * The base case is when there is only one disk, which can be moved directly from the source peg to the destination peg.
 * * The time complexity of this algorithm is O(2^n), where n is the number of disks.
 * The space complexity is O(n) due to the recursive call stack.
 * * This implementation also counts the number of moves made during the process.

   -> Pseudo Code :

   fun(n , source, destination, auxiliary)
        if n == 1 then
            move disk 1 from source to destination
        else
            fun(n - 1 , source, auxiliary, destination)
            move disk n from source to destination
            fun(n - 1, auxiliary, destination, source)
 */




public class TowersOfHanoi {

    // Static variable to count the number of moves
    private static int moveCount = 0;

    public static void solveTowersOfHanoi(int n, char source, char destination, char auxiliary) {
        if (n == 1) {
            moveCount++; // Increment the move count
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        solveTowersOfHanoi(n - 1, source, auxiliary, destination);
        moveCount++; // Increment the move count
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        solveTowersOfHanoi(n - 1, auxiliary, destination, source);
    }

    public static void main(String[] args) {
        int n = 3; // Number of disks
        solveTowersOfHanoi(n, 'A', 'C', 'B');
        System.out.println("Total moves: " + moveCount); // Print the total number of moves
    }
}