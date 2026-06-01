import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
        int flag = 0;
        
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                flag = flag | (1 << (str.charAt(i) - '0'));
            }
        }
        
        System.out.println(flag == (1 << 10) - 1 ? "Yes" : "No");
    }
}
