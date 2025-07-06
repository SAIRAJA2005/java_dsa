import java.util.PriorityQueue;
import java.util.Scanner;

public class Kth_Largest_Element {

    public static int find_kth_Largest_num(int[] arr ,int n, int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        for(int i = 0 ; i < k ; i++){
            heap.offer(arr[i]);
        }
        for(int i = k ; i < n ; i++){
            if(arr[i] > heap.peek()){
                heap.poll();
                heap.offer(arr[i]);
            }
        }
        return heap.peek();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); 
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        System.out.println(find_kth_Largest_num(arr, n, k));
    }
}
