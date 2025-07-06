import java.util.*;

class HeapSorting {
    
    // Swap elements at index I and J in the list
    private void swap(List<Integer> arr, int I, int J) {
        int temp = arr.get(I);
        arr.set(I, arr.get(J));
        arr.set(J, temp);
    }

    // Heapify the subtree rooted at nodeIndex for size N
    private void heapify(List<Integer> arr, int N, int nodeIndex) {
        int maxIndex = nodeIndex;
        int leftIndex = 2 * nodeIndex + 1;
        int rightIndex = 2 * nodeIndex + 2;

        if (leftIndex < N && arr.get(leftIndex) > arr.get(maxIndex)) {
            maxIndex = leftIndex;
        }

        if (rightIndex < N && arr.get(rightIndex) > arr.get(maxIndex)) {
            maxIndex = rightIndex;
        }

        if (maxIndex != nodeIndex) {
            swap(arr, nodeIndex, maxIndex);
            heapify(arr, N, maxIndex);
        }
    }

    // Build the max heap
    private void buildHeap(List<Integer> arr) {
        for (int I = arr.size() / 2 - 1; I >= 0; I--) {
            heapify(arr, arr.size(), I);
        }
    }

    // Perform heap sort
    public void sort(List<Integer> arr) {
        buildHeap(arr);
        int N = arr.size();
        for (int i = N - 1; i >= 1; i--) {
            swap(arr, 0, i);                // Move max element to end
            heapify(arr, i, 0);      // Heapify the reduced heap
        }
    }
}

public class HeapSortMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();             // Number of elements
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }

        HeapSorting sorting = new HeapSorting();
        sorting.sort(arr);                     // Perform heap sort

        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        scanner.close();
    }
}
