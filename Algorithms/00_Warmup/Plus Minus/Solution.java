/* Problem: https://www.hackerrank.com/challenges/plus-minus/problem
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

    static void plusMinus(int[] arr) {
        float positive = 0;
        float negative = 0;
        float zero = 0;
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            if(arr[i] > 0) {
                positive++;
            } else if(arr[i] < 0) {
                negative++;
            } else {
                zero++;
            }
        }

        System.out.println(positive/n);
        System.out.println(negative/n);
        System.out.println(zero/n);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
