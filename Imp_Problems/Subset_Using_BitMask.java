/**
 * The class Subset_Using_BitMask reads a list of integers, calculates all possible subsets using
 * bitmasking, and counts the subsets that sum up to a target value.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Subset_Using_BitMask{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer>lst = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            lst.add(scanner.nextInt());
        }
        int target = scanner.nextInt();

        int count = 0;
        int maskCount = 1 << n;
        for(int mask = 0 ; mask < maskCount ; mask++){
            int sum = 0;
            for(int bit = 0 ; bit < n ; bit++){
                if((mask & (1  << bit)) != 0){
                    sum += lst.get(bit);
                }
            }
            if(sum == target){
                count++;
            }
        }
        System.out.println(count);
    }
}