/* Problem: https://www.hackerrank.com/challenges/non-divisible-subset/problem
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

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        int[] remainder = new int[k];
        int counter = 0;

        for(int i : s) {
            remainder[i%k] += 1;
        }

        if(k == 1) return 1;
        if(remainder[0] != 0) counter = 1;
            
        if(k%2==0 && remainder[k/2] != 0) {
            counter++;
            remainder[k/2] = 0;
        } 
                

        for(int i = 1; i <= k/2; i++) {
            counter += Math.max(remainder[i], remainder[k-i]);
        }

        return counter;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
