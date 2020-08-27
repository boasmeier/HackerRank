/* Problem: https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
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

    public static int[] climbingLeaderboard(Integer[] scores, int[] alice) {
        int an = alice.length;
        int sn = scores.length;
        int[] ranks = new int[an];
        
        List<Integer> list = Arrays.asList(scores);
        Set<Integer> set = new TreeSet<Integer>(list);
        List<Integer> l = new ArrayList<>(set);
        int[] scoresDis = new int[l.size()];

        for(int i = 0; i < l.size(); i++){
            scoresDis[i] = l.get(i);
        }

        for(int i = 0; i < an; i++) {
            if (alice[i] >= scores[0]) {
                ranks[i] = 1;
            } else if (alice[i] < scores[sn - 1]) {
                ranks[i] = l.size() + 1;
            } else {
                ranks[i] = binarySearch(scoresDis, alice[i]);
            }
        }

        return ranks;
    }

    // Returns index of x if it is present in arr[], 
    // else return -1 
    private static int binarySearch(int[] arr, int x) { 
        int l = 0; 
        int r = arr.length - 1;
        int m = l + (r - l) / 2;

        while (l <= r) {
            if (x > arr[m]) {
                l = m;   // limit binary search to upper half of previous limitation
                if (x < arr[m+1]) {
                    return (arr.length - m);
                } else if (x == arr[m+1]) {
                    return (arr.length - m) - 1;
                } else {
                    m = (l + r) / 2; // calc new mid of upper half
                }

            } else if (x < arr[m]) {
                r = m;   // limit binary search to lower half of previous limitation
                if (x >= arr[m-1]) {
                    return (arr.length - m) + 1;
                } else {
                    m = (l + r) / 2;     // calc new mid of lower half
                }
            } else {
                return (arr.length - m);
            } 
        }

        return -1;
    } 

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        Integer[] scores = new Integer[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

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