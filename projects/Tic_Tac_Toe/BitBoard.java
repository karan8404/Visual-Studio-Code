package Tic_Tac_Toe;

public class BitBoard {
    public Pos[][] board;
    public boolean player;
    public int lastLoc;

    public BitBoard() {
        board = new Pos[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = new Pos();
            }
        }
        player = true;
        lastLoc = -1;
    }

    public Pos pos(int i, int j) {
        return board[i][j];
    }

    public Pos pos(int loc) {
        return board[loc / 3][loc % 3];
    }

    public void displayBoard() {
        System.out.printf("%c|%c|%c\n-|-|-\n", board[0][0].getMark(), board[0][1].getMark(), board[0][2].getMark());
        System.out.printf("%c|%c|%c\n-|-|-\n", board[1][0].getMark(), board[1][1].getMark(), board[1][2].getMark());
        System.out.printf("%c|%c|%c\n", board[2][0].getMark(), board[2][1].getMark(), board[2][2].getMark());
    }

    public boolean makeMove(int loc) {
        loc--;
        if (pos(loc).isEmpty()) {
            pos(loc).setMark(player);
            player = !player;
            lastLoc = loc;
            return true;
        } else {
            System.out.println("Invalid Move!");
            return false;
        }
    }

    public boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (pos(i, 0).equals(pos(i, 1)) && pos(i, 1).equals(pos(i, 2)))// checking rows
                return true;
            if (pos(0, i).equals(pos(1, i)) && pos(1, i).equals(pos(2, i)))// checking rows
                return true;
        }
        if (pos(0, 0).equals(pos(1, 1)) && pos(1, 1).equals(pos(2, 2)))// left diagonal
            return true;
        if (pos(0, 2).equals(pos(1, 1)) && pos(1, 1).equals(pos(2, 0)))// right diagonal
            return true;
        return false;
    }

    public boolean checkTie(){
        for (Pos[] column : board) {
            for (Pos pos : column) {
                if(pos.isEmpty())
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BitBoard board = new BitBoard();

        board.makeMove(1);
        board.makeMove(5);
        board.makeMove(7);

        board.displayBoard();
    }

    public static class Pos {
        boolean hasMark;
        boolean mark;// true='X',false='O'

        public Pos() {
            hasMark = false;
        }

        boolean isEmpty() {
            return !hasMark;
        }

        char getMark() {
            if (isEmpty())
                return ' ';
            return (mark ? 'X' : 'O');
        }

        void setMark(boolean player) {
            // if player set 'X' else set 'O'
            mark = player;
            hasMark = true;
        }

        void clearMark() {
            hasMark = false;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj.getClass() == this.getClass()))
                return false;
            Pos objPos = (Pos) (obj);

            if (this.isEmpty() || objPos.isEmpty())
                return false;
            if (this.mark == objPos.mark)
                return true;
            return false;
        }
    }
}