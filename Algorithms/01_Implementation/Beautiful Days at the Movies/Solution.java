/* Problem: https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problemimport java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    public static int beautifulDays(int i, int j, int k) {
        int beatifulDayCount = 0;
        for(int x = i; x <= j; x++) {
            if((x - reverseInt(x)) % k == 0) {
                beatifulDayCount++;
            }
        }
        return beatifulDayCount;
    }

    private static int reverseInt(int i) {
        String s = Integer.toString(i);
        String z = new String();
        int n = s.length();

        for(int j = 0; j < n; j++) {
            z += s.substring((n-1)-j, n-j);
        }

        return Integer.parseInt(z);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

 * Language: Java 8
 */

