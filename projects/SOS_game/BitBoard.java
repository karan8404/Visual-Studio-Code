package SOS_game;

/*CONVENTIONS
 * In case of any boolean value, true represents the first playing and false represents the second player.
 * The first player plays as 'S' by default and the second player plays as 'O' by default.
 * the board has 10 cells by default. Can be changed.
 */
public class BitBoard {
    private Pos[] board;
    protected boolean turn;// true=player1, false=player2
    protected int lastLoc;
    private char firstMark;// 'S' by default
    private char secondMark;// 'O' by default
    private int length;

    public BitBoard() {
        turn = true;
        firstMark = 'S';
        secondMark = 'O';
        lastLoc = -1;
        length = 10;

        board = new Pos[length];

        for (int i = 0; i < length; i++)
            board[i] = new Pos();
    }

    public BitBoard(boolean turn, char firstMark, char secondMark, int length) {
        this.turn = turn;
        this.firstMark = firstMark;
        this.secondMark = secondMark;
        this.length = length;
        lastLoc = -1;

        board = new Pos[length];

        for (int i = 0; i < board.length; i++)
            board[i] = new Pos();
    }

    public Pos pos(int loc) {
        return board[loc];
    }

    public class Pos {
        boolean hasMark;
        boolean mark;// true='S'/firstMark,false='O'/secondMark

        public Pos() {
            hasMark = false;
        }

        boolean isEmpty() {
            return !hasMark;
        }

        char getMark() {
            if (isEmpty())
                return ' ';
            return (mark ? firstMark : secondMark);
        }

        void setMark(boolean mark)// true=firstMark, false=secondMark
        {
            // if player set 'X' else set 'O'
            this.mark = mark;
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
