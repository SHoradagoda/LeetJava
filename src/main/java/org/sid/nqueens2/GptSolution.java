package org.sid.nqueens2;

public class GptSolution {
    public int totalNQueens(int n) {
        int[] res = new int[1];
        boolean[][] chessboard = new boolean[n][n];
        dfs(0, n, chessboard, res);
        return res[0];
    }

    private void dfs(int curRow, int n, boolean[][] chessboard, int[] res) {
        if (curRow == n) {
            res[0]++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(curRow, i, chessboard)) {
                chessboard[curRow][i] = true;
                dfs(curRow + 1, n, chessboard, res);
                chessboard[curRow][i] = false;
            }
        }
    }

    private boolean isValid(int curRow, int col, boolean[][] chessboard) {
        for (int i = 0; i < curRow; i++) {
            if (chessboard[i][col]) return false;
        }
        for (int i = curRow - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j]) return false;
        }
        for (int i = curRow - 1, j = col + 1; i >= 0 && j < chessboard.length; i--, j++) {
            if (chessboard[i][j]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new GptSolution().totalNQueens(4));
    }
}
