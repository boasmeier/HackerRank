/* Problem: https://www.hackerrank.com/challenges/between-two-sets/problem
 * Language: Java 8
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        Collections.sort(a);
        Collections.sort(b);

        int maxA = a.get(a.size()-1);
        int minB = b.get(0);

        boolean isFactor = true;
        int xCounter = 0;

        for (int i = maxA; i <= minB; i++) {
            for( int ai : a) {
                if(i % ai != 0) {
                    isFactor = false;
                    break;
                }
            }

            for(int bi : b) {
                if(bi % i != 0) {
                    isFactor = false;
                    break;
                }
            }
            if(isFactor) {
                xCounter++;
            }
            isFactor = true;
        }

        System.out.println(xCounter);
        return xCounter;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
