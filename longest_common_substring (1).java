package practice1;

// java.lang classes (String, Math, System) are auto-imported, listed here for clarity
import java.lang.String;   // Used for String a, String b, String lcs
import java.lang.Math;     // Available for Math.max() if needed in future extensions
import java.lang.System;   // Used for System.out.println / printf

// Utility imports
import java.util.Arrays;   // Available for Arrays.toString() / deepToString() on dp table
import java.util.Scanner;  // Available for reading user input if extended

// I/O imports
import java.io.PrintStream; // Underlies System.out (PrintStream)

public class longest_common_substring {

    public static void main(String[] args) {
        String a = "morning";
        String b = "evening";

        System.out.println("String A: " + a);
        System.out.println("String B: " + b);
        System.out.println("Length of Longest Common Substring: " + lcSubString(a, b));
        printLCS(a, b);
    }

    // Returns the length of the Longest Common Substring
    public static int lcSubString(String a, String b) {
        int max = 0;
        char[] rarr = a.toCharArray();  // rows
        char[] carr = b.toCharArray();  // columns

        // dp[i][j] = length of common substring ending at a[i-1] and b[j-1]
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (rarr[i - 1] == carr[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];  // extend the match
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                    }
                } else {
                    dp[i][j] = 0;  // reset on mismatch
                }
            }
        }

        // Print DP table
        System.out.println("\nDP Table:");
        System.out.print("    ");
        for (char c : carr) System.out.printf("%3c", c);
        System.out.println();
        for (int i = 0; i <= a.length(); i++) {
            if (i == 0) System.out.print("  ");
            else System.out.printf("%c ", rarr[i - 1]);
            for (int j = 0; j <= b.length(); j++) {
                System.out.printf("%3d", dp[i][j]);
            }
            System.out.println();
        }

        return max;
    }

    // Finds and prints the actual Longest Common Substring
    public static void printLCS(String a, String b) {
        int max = 0;
        int endIndex = 0;
        char[] rarr = a.toCharArray();
        char[] carr = b.toCharArray();

        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (rarr[i - 1] == carr[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        endIndex = i;  // track where the substring ends in 'a'
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        // Extract the substring using endIndex and max length
        String lcs = a.substring(endIndex - max, endIndex);
        System.out.println("Longest Common Substring: \"" + lcs + "\"");
        System.out.println("Length: " + max);
    }
}
