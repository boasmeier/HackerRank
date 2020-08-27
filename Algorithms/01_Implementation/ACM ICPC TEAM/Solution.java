/* Problem: https://www.hackerrank.com/challenges/acm-icpc-team/problem
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

    static int[] acmTeam(String[] topic) {
        int n = topic.length;
        int m = topic[0].length();
        int[] teams = new int[m+1];
        int[] res = new int[2];
        

        for(int i = 0; i < n-1; i++) {
            for(int j = i; j < n-1; j++) {
                int counter = 0;
                for(int k = 0; k < m; k++) {
                    if(topic[i].charAt(k) == '1' || topic[j+1].charAt(k) == '1') {
                        counter++;
                    }
                }
                teams[counter] += 1;
            }
        }
        
        for(int i = m; i >= 0; i--) {
            if(teams[i] != 0) {
                res[0] = i;
                res[1] = teams[i];;
                break;
            }
        }

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
