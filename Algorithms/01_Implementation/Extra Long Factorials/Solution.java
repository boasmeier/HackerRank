/* Problem: https://www.hackerrank.com/challenges/extra-long-factorials/problem
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

    static BigInteger extraLongFactorials(int n) {

        // Initialize result 
        BigInteger f = new BigInteger(String.valueOf(n)); // Or BigInteger.ONE

        return n == 0 ? BigInteger.ONE : f.multiply(extraLongFactorials( n - 1 )); 
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        System.out.println(extraLongFactorials(n));

        scanner.close();
    }
}
