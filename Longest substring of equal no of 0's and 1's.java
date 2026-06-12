import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string of 0's and 1's: ");
        String str = sc.next();

        Map<Integer, Integer> m = new HashMap<>();
        int sum = 0, len = 0;
        m.put(sum, -1);

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                sum -= 1;
            } else {
                sum += 1;
            }

            if (m.containsKey(sum)) {
                len = Math.max(len, i - m.get(sum));
            } else {
                m.put(sum, i);
            }
        }

        System.out.println("Length of longest substring containing equal no of 0's and 1's: " + len);
        sc.close();
    }
}
