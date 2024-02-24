package org.sid.nqueens2;

public class Solution {
    public int totalNQueens(int n) {

        int matches = 0;
        int[][] coordinates = new int[n][2];
        for (int y = 0; y < n; y++) {
            // Q0 -  0, y
            coordinates[0] = new int[]{0, y};
            boolean found = true;
            for ( int t =0;t<n;t++) {
                for (int q = 1; q < n; q++) {
                    boolean placed = false;
                    for (int qy = t; qy < n; qy++) {
                        //If can place queen on q,qy the add
                        if (canPlace(coordinates, q, qy)) {
                            coordinates[q] = new int[]{q, qy};
                            placed = true;
                            break;
                        }
                    }
                    if (!placed) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    matches++;
                }
            }

        }

        return matches;
    }

    private boolean canPlace(int[][] coordinates, int q, int qy) {
        for ( int i =0;i<q;i++) {
            int[] pos = coordinates[i];
            if ( pos[1] == qy ) {
                return false;
            }
            int xDiff = q - i;
            int yDiff = Math.abs(qy - pos[1]);
            if ( xDiff == yDiff) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().totalNQueens(5));
    }
}