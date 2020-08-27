/* Problem: https://www.hackerrank.com/challenges/repeated-string/problem
 * Language: Java 8
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static long repeatedString(String s, long n) {

        int len = s.length();
        long remainder = n%len;
        long reps = n/len;
        long aCount = 0;
        long res = 0;

        for(int i = 0; i < len; i++) {
            if(s.charAt(i) == 'a') {
                aCount++;
            }
        }
        res = aCount*reps;

        for(int i = 0; i < remainder; i++) {
            if(s.charAt(i) == 'a') {
                res++;
            }
        }

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
