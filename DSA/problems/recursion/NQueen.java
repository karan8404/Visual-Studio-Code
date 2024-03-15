package recursion;

public class NQueen {
    static int N;

    static boolean Nqueen(int[][] board, int row) {
        for (int i = 0; i < N; i++) {

        }
        return false;
    }

    static void placeQueen(int[][] board, int row, int col) {
        for(int i=0;i<N;i++){
            board[row][i]=1;
            board[i][col]=1;
        }

        for(int i=0;row+i<N;i++){
            
        }
    }
}
