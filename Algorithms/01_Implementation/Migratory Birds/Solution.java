/* Problem: https://www.hackerrank.com/challenges/migratory-birds/problem
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

public class Solution {

    static int migratoryBirds(List<Integer> arr) {
        int[] freq = new int[5];
        int type = 1;
        for( int i : arr) {
            switch(i) {
                case 1:
                    freq[0]++;
                break;

                case 2:
                    freq[1]++;
                break;

                case 3:
                    freq[2]++;
                break;

                case 4:
                    freq[3]++;
                break;

                case 5:
                    freq[4]++;
                break;
            }
        }

        int max = 0;
        for(int i = 0; i < 5; i++) {
            if(freq[i] > max) {
                max = freq[i];
                type = i+1;
            }
        }

        return type;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
