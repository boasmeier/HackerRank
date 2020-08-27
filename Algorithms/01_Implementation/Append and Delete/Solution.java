/* Problem: https://www.hackerrank.com/challenges/append-and-delete/problemimport java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static String appendAndDelete(String s, String t, int k) {
        // Count till which digit s and t are the same.
        int sameDigits = 0;
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                break;
            }
            sameDigits++;
        }
        
        // Calc how many remove and append operations need to be done.
        int toRemove = s.length() - sameDigits;
        int toAppend = t.length() - sameDigits;
        int operations = toRemove + toAppend;

        // Return Yes if operations are less or equals k or else return No
        if(operations > k) {
            return "No";
        } else if(operations == k) {
            return "Yes";
        } else if(operations % 2 != 0 && k % 2 == 0) {
            return "No";
        } else {
            return "Yes";
        }
        //return operations <= k ? "Yes" : "No";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

 * Language: Java 8
 */

