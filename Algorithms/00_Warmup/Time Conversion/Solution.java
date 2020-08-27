/* Problem: https://www.hackerrank.com/challenges/time-conversion/problem
 * Language: Java 8
 */

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    static String timeConversion(String s) {
        
        String hh = s.substring(0, 2);
        String mm = s.substring(3, 5);
        String ss = s.substring(6, 8);
        
        int hhi = Integer.parseInt(s.substring(0, 2));

        char c = 'P';
        char c2 = 'A';

        if(s.charAt(8) == c && hhi != 12) {
            hhi += 12;
            hh = String.valueOf(hhi); 
        } else if(hhi == 12 && s.charAt(8) == c2) {
            hh = "00";  
        }
        

        String result = hh + ":" + mm + ":" + ss;
        System.out.println(result);
        return result;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
