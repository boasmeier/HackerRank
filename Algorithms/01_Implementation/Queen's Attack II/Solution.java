/* Problem: https://www.hackerrank.com/challenges/queens-attack-2/problem
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

    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {

        //Calc reachable fields if there where no obstacles for every possible direction.
        int up = n - r_q;
        int right = n - c_q;
        int down = r_q - 1;
        int left = c_q - 1;
        int upRight = Math.min(up, right);
        int downRight = Math.min(down, right);
        int downLeft = Math.min(down, left);
        int upLeft = Math.min(up, left);
        
        //Calc reachable fields up to the first obstacle ABOVE the queen. 
        for (int i = 0; i < k; i++) {
            if (obstacles[i][1] == c_q && obstacles[i][0] >= r_q + 1) {
                int distToObstacle = obstacles[i][0] - (r_q + 1);
                if (distToObstacle == 0) {
                    up = 0;
                    break;
                } else if (distToObstacle < up) {
                    up = distToObstacle;
                }
            }
        }

        //Calc reachable fields up to the first obstacle RIGHT of queen.
        for (int i = 0; i < k; i++) {
            if (obstacles[i][1] >= c_q + 1 && obstacles[i][0] == r_q) {
                int distToObstacle = obstacles[i][1] - (c_q + 1);
                if (distToObstacle == 0) {
                    right = 0;
                    break;
                } else if (distToObstacle < right) {
                    right = distToObstacle;
                }
            }
        }

        //Calc reachable fields up to the first obstacle UNDER the queen.
        for (int i = 0; i < k; i++) {
            if (obstacles[i][1] == c_q && obstacles[i][0] <= r_q - 1) {
                int distToObstacle = (r_q - 1) - obstacles[i][0];
                if (distToObstacle == 0) {
                    down = 0;
                    break;
                } else if (distToObstacle < down) {
                    down = distToObstacle;
                }
            }
        }

        //Calc reachable fields up to the first obstacle LEFT of queen.
        for (int i = 0; i < k; i++) {
            if (obstacles[i][1] <= c_q - 1 && obstacles[i][0] == r_q) {
                int distToObstacle = (c_q - 1) - obstacles[i][1];
                if (distToObstacle == 0) {
                    left = 0;
                    break;
                } else if (distToObstacle < left) {
                    left = distToObstacle;
                }
            }
        }

        //Calc reachable fields up to the first obstacle diagonally UPWARDS to the RIGHT starting from the queen.
        for (int i = 0; i < k; i++) {
            if (obstacles[i][1] >= c_q + 1 && obstacles[i][0] >= r_q + 1 && obstacles[i][0] - obstacles[i][1] == r_q - c_q) {
                int distToObstacle = obstacles[i][0] - (r_q + 1);
                if (distToObstacle == 0) {
                    upRight = 0;
                    break;
                } else if (distToObstacle < upRight) {
                    upRight = distToObstacle;
                }
            }
        }

        //Calc reachable fields up to the first obstacle diagonally DOWN to the RIGHT starting from the queen.
        for (int i = 0; i < k; i++) {
            if (obstacles[i][1] >= c_q + 1 && obstacles[i][0] <= r_q - 1 && (obstacles[i][1] - c_q) == (r_q - obstacles[i][0])) {
                int distToObstacle = (r_q - 1) - obstacles[i][0];
                if (distToObstacle == 0) {
                    downRight = 0;
                    break;
                } else if (distToObstacle < downRight) {
                    downRight = distToObstacle;
                }
            }
        }

        //Calc reachable fields up to the first obstacle diagonally DOWN to the LEFT starting from the queen.
        for (int i = 0; i < k; i++) {
            if (obstacles[i][1] <= c_q - 1 && obstacles[i][0] <= r_q - 1 && obstacles[i][0] - obstacles[i][1] == r_q - c_q) {
                int distToObstacle = (r_q - 1) - obstacles[i][0];
                if (distToObstacle == 0) {
                    downLeft = 0;
                    break;
                } else if (distToObstacle < downLeft) {
                    downLeft = (r_q - 1) - obstacles[i][0];
                }
            }
        }

        //Calc reachable fields up to the first obstacle diagonally UPWARDS to the LEFT starting from the queen.
        for (int i = 0; i < k; i++) {
            if (obstacles[i][1] <= c_q - 1 && obstacles[i][0] >= r_q + 1 && (obstacles[i][0] - r_q) == (c_q - obstacles[i][1])) {
                int distToObstacle = obstacles[i][0] - (r_q + 1);
                if (distToObstacle == 0) {
                    upLeft = 0;
                    break;      
                } else if (distToObstacle < upLeft) {
                    upLeft = distToObstacle;
                }
            }
        }

        return up + right + down + left + upRight + downRight + downLeft + upLeft;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");
        int r_q = Integer.parseInt(r_qC_q[0]);  // Convert queens position to different coordinate system. C is same but R is mirrored.
        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            obstacles[i][0] = Integer.parseInt(obstaclesRowItems[0]);
            obstacles[i][1] = Integer.parseInt(obstaclesRowItems[1]);
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        System.out.println(result);

        scanner.close();
    }
}
