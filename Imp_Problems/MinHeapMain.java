import java.util.*;

class MinHeap{
    
    private List<Integer>arr;

    public MinHeap(){
        arr = new ArrayList<>();
    }
    public void offer (int val){
        arr.add(val);
        heapifyUp(arr.size() - 1);
    }
    public int peek(){
        return arr.get(0);
    }
    public int poll(){
        int result = peek();
        swap(0, arr.size() - 1);
        arr.remove(arr.size() - 1);
        return result;
    }
    public void buildHeap(List<Integer>newArr){
        arr = new ArrayList<>(newArr);
        for(int i = (arr.size() / 2) - 1 ; i >= 0 ; i--){
            heapifyDown(i);
        }
    }

    private void swap(int i, int j){
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
    public void heapifyDown(int nodeIndex){
        int minIndex = nodeIndex;
        int leftIndex = 2 * nodeIndex + 1;
        int rightIndex = 2 * nodeIndex + 2;
        if(leftIndex < arr.size() && arr.get(leftIndex) < arr.get(nodeIndex)){
            minIndex = leftIndex;
        }
        if(rightIndex < arr.size() && arr.get(rightIndex) < arr.get(nodeIndex)){
            minIndex = rightIndex;
        }
        if(minIndex != nodeIndex){
            swap(minIndex, nodeIndex);
            heapifyDown(minIndex);
        }

    }
    public void heapifyUp(int nodeIndex){
        int parentIndex = (nodeIndex - 1) / 2;
        if(nodeIndex > 0 && arr.get(nodeIndex) < arr.get(parentIndex)){
            swap(nodeIndex, parentIndex);
            heapifyUp(parentIndex);
        }
    }
}


public class MinHeapMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        MinHeap heap = new MinHeap();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            if (line.startsWith("insert")) {
                int val = Integer.parseInt(line.split(" ")[1]);
                heap.offer(val);
            } else if (line.startsWith("extractMin")) {
                try {
                    System.out.println(heap.poll());
                } catch (NoSuchElementException e) {
                    // Optionally handle empty heap
                }
            } else if (line.startsWith("heapify")) {
                String[] parts = line.split(" ");
                int k = Integer.parseInt(parts[1]);
                List<Integer> arr = new ArrayList<>();
                for (int j = 0; j < k; j++) {
                    arr.add(Integer.parseInt(parts[2 + j]));
                }
                heap.buildHeap(arr);
            }
        }
        sc.close();
    }
}