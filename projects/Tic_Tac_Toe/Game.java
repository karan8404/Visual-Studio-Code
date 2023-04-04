package Tic_Tac_Toe;

public class Game {
    public char[][] board = new char[3][3];
    public boolean player=true;

    public void displayBoard() {
        System.out.printf("%c|%c|%c\n-|-|-\n", board[0][0], board[0][1], board[0][2]);
        System.out.printf("%c|%c|%c\n-|-|-\n", board[1][0], board[1][1], board[1][2]);
        System.out.printf("%c|%c|%c", board[2][0], board[2][1], board[2][2]);
    }

    public boolean checkWin(){
        for (int i = 0; i < 3; i++) {
            if(board[i][0]==board[i][1]&& board[i][1]==board[i][2])//checking rows
                return true;
            if(board[0][i]==board[1][i] && board[1][i]==board[2][i])//checking columns
                return true;
        }
        if(board[0][0]==board[1][1]&& board[1][1]==board[2][2])//left diagonal
            return true;
        if(board[2][0]==board[1][1] && board [1][1]==board[0][2])//right diagonal
            return true;

        return false;
    }

    public void makeMove(int loc){
        loc--;
        board[loc/3][loc%3]=player?'X':'O';

        player=!player;
    }

    public static void main(String[] args) {
        Game game = new Game();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                game.board[i][j] = ' ';
            }
        }
        game.makeMove(1);
        game.makeMove(5);
        game.makeMove(2);
        System.out.println(game.checkWin());
        game.displayBoard();
    }
}