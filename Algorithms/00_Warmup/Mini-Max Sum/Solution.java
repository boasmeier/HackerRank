/* Problem: https://www.hackerrank.com/challenges/mini-max-sum/problem
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

    static void miniMaxSum(int[] arr) {
        long sum1 = 0;
        long sum2 = 0;
        long sum3 = 0;
        long sum4 = 0;
        long sum5 = 0;
        List<Long> list = new LinkedList<>();

        // Calc sum1 (without i = 4)
        for (int i = 0; i < arr.length -1; i++) {
            sum1 += arr[i];
        }
        list.add(sum1);

        // Calc sum2 (without i = 3)
        for (int i = 0; i < arr.length; i++) {
            if (i != 3) {
                sum2 += arr[i];
            }
        }
        list.add(sum2);

        // Calc sum3 (without i = 2)
        for (int i = 0; i < arr.length; i++) {
            if (i != 2) {
                sum3 += arr[i];
            }
        }
        list.add(sum3);

        // Calc sum3 (without i = 1)
        for (int i = 0; i < arr.length; i++) {
            if (i != 1) {
                sum4 += arr[i];
            }
        }
        list.add(sum4);

        // Calc sum3 (without i = 0)
        for (int i = 0; i < arr.length; i++) {
            if (i != 0) {
                sum5 += arr[i];
            }
        }
        
        list.add(sum5);
        System.out.print(Collections.min(list) + " " + Collections.max(list));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];
        String[] arrItems = scanner.nextLine().split(" ");
        
        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);
        scanner.close();
    }
}

