package recursion;
public class NQueen {
    static int N;

    static boolean Nqueen(int[][] board, int row) {
        if (row == N) {
            return true;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;
                if (Nqueen(board, row + 1)) {
                    return true;
                }

                board[row][col] = 0;
            }
        }

        return false;
    }

    static boolean isSafe(int[][] board, int row, int column) {
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] == 1)
                return false;
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][column] == 1)
                return false;
        }

        // int min=row<column?row:column;

        return true;
    }

}
