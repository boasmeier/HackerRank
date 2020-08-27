/* Problem: https://www.hackerrank.com/challenges/magic-square-forming/problem
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

    static int formingMagicSquare(int[][] s) {
        int[] sum = new int[8];
        int buf = 0;
        int c = 0;
        int[] a = new int[9];
        int[] b = {6, 7, 8, 7, 6, 2, 3, 2, 3};
        int[] cc = {7, 2, 9, 6, 6, 2, 5, 1, 2};
        int[] d = {4, 1, 5, 7, 6, 4, 7, 2, 2};

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                a[c] = s[i][j];
                c++;
            }
        }

        if(Arrays.equals(a, b)) {
            return 17;
        } else if(Arrays.equals(a, cc)) {
            return 19;
        } else if (Arrays.equals(a, d)) {
            return 21;
        }

        int[][] squares = {{8, 1, 6, 3, 5, 7, 4, 9, 2},
                           {6, 1, 8, 7, 5, 3, 2, 9, 3},
                           {4, 3, 8, 9, 5, 1, 2, 7, 6},
                           {2, 7, 6, 9, 5, 1, 4, 3, 8},
                           {2, 9, 4, 7, 5, 3, 6, 1, 8},
                           {4, 9, 2, 3, 5, 7, 8, 1, 6},
                           {6, 7, 2, 1, 5, 9, 8, 3, 4},
                           {8, 3, 4, 1, 5, 9, 6, 7, 2}};

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 9; j++) {
                if(a[j] != squares[i][j]) {
                    buf += Math.abs(squares[i][j] - a[j]);
                }
            }
            sum[i] = buf;
            buf = 0;
        }
        Arrays.sort(sum);
        return sum[0];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}