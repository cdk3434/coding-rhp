package practice1;

// java.lang imports (auto-included by JVM, listed for clarity)
import java.lang.String;    // Used for String str1, str2
import java.lang.Math;      // Used for Math.max()
import java.lang.System;    // Used for System.out.println()

// Utility imports
import java.util.Arrays;    // Available for Arrays.toString() / deepToString() on dp table
import java.util.Scanner;   // Used for reading user input (replaces cin >>)

// I/O imports
import java.io.PrintStream; // Underlies System.out (PrintStream)

public class longest_common_subsequence {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);  // replaces cin

        System.out.print("Enter the string values: ");
        String str1 = sc.next();   // replaces cin >> str1
        String str2 = sc.next();   // replaces cin >> str2

        int m = 0;
        int n1 = str1.length();
        int n2 = str2.length();

        // 2D dp array — replaces vector<vector<int>> dp(n1+1, vector<int>(n2+1, 0))
        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {  // replaces str1[i-1]==str2[j-1]
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);  // replaces max()
                }
                m = Math.max(m, dp[i][j]);
            }
        }

        System.out.println("Length of longest common subsequence: " + m);  // replaces cout

        sc.close();
    }
}
