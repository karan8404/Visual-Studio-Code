import java.util.ArrayList;
import java.util.List;

public class problem54 {
    // print a spiral matrix
    // https://leetcode.com/problems/spiral-matrix/

    int ceil, floor, left, right;
    int iStep = 0, jStep = 1;
    int i = 0, j = 0;

    public List<Integer> spiralOrder(int[][] matrix) {
        ceil = -1;
        floor = matrix.length;
        left = -1;
        right = matrix[0].length;

        List<Integer> spiral = new ArrayList<>();

        while ((ceil < floor - 1) && (left < right - 1)) {
            if (j == right) {// if right boundary is hit
                j--;
                ceil++;
                iStep = 1;
                jStep = 0;
                nextStep();
                continue;
            } else if (i == floor) {// if floor boundary is hit
                i--;
                right--;
                iStep = 0;
                jStep = -1;
                nextStep();
                continue;
            } else if (j == left) {// if left boundary is hit
                j++;
                floor--;
                iStep = -1;
                jStep = 0;
                nextStep();
                continue;
            } else if (i == ceil) {// if ceil boundary is hit
                i++;
                left++;
                iStep = 0;
                jStep = 1;
                nextStep();
                continue;
            }
            spiral.add(matrix[i][j]);
            nextStep();
        }

        return spiral;
    }

    public void nextStep() {
        i += iStep;
        j += jStep;
    }

}
