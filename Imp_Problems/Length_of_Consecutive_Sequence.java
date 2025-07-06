
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Length_of_Consecutive_Sequence {

    public static int findLength(List<Integer> lst) {
        if(lst.isEmpty()) return 0;
        int maxLength = 0;
        int currentLength = 1;
        lst.sort(Integer::compareTo);
        for(int i = 1; i < lst.size(); i++){
            if(lst.get(i) == lst.get(i - 1) + 1){
                currentLength++;
            } else if(lst.get(i) != lst.get(i - 1)){
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
            }

        }

        maxLength = Math.max(maxLength, currentLength);
        return maxLength;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> lst = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            lst.add(scanner.nextInt());
        }
        System.out.print(findLength(lst));
        scanner.close();
    }
}
