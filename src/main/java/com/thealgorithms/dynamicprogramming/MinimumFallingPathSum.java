import java.util.*;

public class Solution {
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[n - 1][i] = matrix[n - 1][i];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int downLeft = (i + 1 < n && j - 1 >= 0) ? dp[i + 1][j - 1] : Integer.MAX_VALUE;
                int downRight = (i + 1 < n && j + 1 < n) ? dp[i + 1][j + 1] : Integer.MAX_VALUE;
                int down = (i + 1 < n) ? dp[i + 1][j] : Integer.MAX_VALUE;
                dp[i][j] = matrix[i][j] + Math.min(down, Math.min(downLeft, downRight));
            }
        }
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) mini = Math.min(mini, dp[0][i]);
        return mini;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
        System.out.println(minFallingPathSum(matrix));
    }
}
