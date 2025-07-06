import java.lang.reflect.Array;
import java.util.Scanner;



public class BucketSort{

    /*
        function bucketSort(array, k) is
        buckets ← new array of k empty lists
        M ← 1 + the maximum key value in the array
        for i = 0 to length(array) do
            insert array[i] into buckets[floor(k × array[i] / M)]
        for i = 0 to k do 
            nextSort(buckets[i])
        return the concatenation of buckets[0], ...., buckets[k]
    */
    public void BucketSort(int[] array , int n){
        
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = scanner.nextInt();
        System.out.println("Enter the elements of the array: ");
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        BucketSort(array, n);
        scanner.close();
    }
}