package helix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class MatrixHelixMorph {

    /**
     * @param inMatrix
     * @return a matrix that is morphed into a helix version of inMatrix
     */


    public static int[][] helix(int[][] inMatrix) {
        if (inMatrix == null || inMatrix.length == 1) {
            return inMatrix;
        }


        int c = inMatrix[0].length;
        int r = inMatrix.length;
        int dir = 0;

        int[][] outMatrix = inMatrix.clone();
        int[][] dirs = {{0, 1, r - 1, -1}, {-1, 0, 0, 1}, {0, -1, 1, 1}, {1, 0, c - 1, -1}};

        for (int y = 0; y < r; y++) {
            outMatrix[y] = inMatrix[y].clone();
        }

        int[] rc = {c - 1, 1};
        int[] newrc;

        for (int y = 1; y < r; y++) {
            for (int x = 0; x < c; x++, rc = newrc) {
                outMatrix[rc[1]][rc[0]] = inMatrix[y][x];
                newrc = new int[]{rc[0] + dirs[dir][0], rc[1] + dirs[dir][1]};
                if (dirs[dir][3] == 1 ? newrc[(dir + 1) % 2] < dirs[dir][2] : newrc[(dir + 1) % 2] > dirs[dir][2]) {
                    dirs[(dir + 3) % 4][2] += dirs[(dir + 3) % 4][3];
                    dir = (dir + 1) % 4;
                    newrc = new int[]{rc[0] + dirs[dir][0], rc[1] + dirs[dir][1]};
                }
            }
        }

        return outMatrix;


    }


}
