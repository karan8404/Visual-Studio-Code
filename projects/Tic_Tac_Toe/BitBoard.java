package Tic_Tac_Toe;

public class BitBoard {
    public Pos[] board;
    public boolean player;
    public int lastLoc;

    public BitBoard() {
        board = new Pos[9];
        for (int i = 0; i < board.length; i++) {
            board[i] = new Pos();
        }
        player=true;
        lastLoc=-1;
    }

    public Pos pos(int loc) {
        return board[loc];
    }

    public void displayBoard() {
        System.out.printf("%c|%c|%c\n-|-|-\n", board[0].getMark(), board[1].getMark(), board[2].getMark());
        System.out.printf("%c|%c|%c\n-|-|-\n", board[3].getMark(), board[4].getMark(), board[5].getMark());
        System.out.printf("%c|%c|%c\n", board[6].getMark(), board[7].getMark(), board[8].getMark());
    }

    public boolean makeMove(int loc) {
        if (board[loc].isEmpty()) {
            board[loc].setMark(player);
            player=!player;
            lastLoc=loc;
            return true;
        }
        else{
            System.out.println("Invalid Move!");
            return false;
        }
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
            hasMark=true;
        }

        void clearMark() {
            hasMark = false;
        }
    }
}