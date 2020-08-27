/* Problem: https://www.hackerrank.com/challenges/cut-the-sticks/problem
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

    static void cutTheSticks(int[] arr) {
        Arrays.sort(arr);

        System.out.println(arr.length);
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > arr[i-1]) {
                System.out.println(arr.length - i);
            }
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        cutTheSticks(arr);


        scanner.close();
    }
}
