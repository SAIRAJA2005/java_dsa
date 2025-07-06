import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GreedyCoinChange {

    public static int Change(List<Integer> lst, int sum) {
        int count = 0;
        Collections.sort(lst);

        for (int i = lst.size() - 1; i >= 0; i--) {
            while (lst.get(i) <= sum) {
                sum -= lst.get(i);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lst.add(scanner.nextInt());
        }

        int sum = scanner.nextInt();

        System.out.println(Change(lst, sum));
        scanner.close();
    }
}
