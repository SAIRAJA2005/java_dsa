import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String secondLine = scanner.nextLine();
        List<Integer>arr = new ArrayList<>(n);
        for(String numStr : secondLine.trim().split(" ")){
            arr.add(Integer.parseInt(numStr));
        }
        int target = scanner.nextint();

        Map<Integer, Integer> pairs = new HashMap <Integer,Integer>(n);
        for(int i = 0 ; i < arr.size() ; i++){
            int diff = target - arr.get(i);
            if(pairs.containsKey(diff)){
                System.out.println(pairs.get(diff) + " " + i);
                break;
            }
            pairs.put(arr.get(i),i);
        }
        scanner.close();

    }
}
