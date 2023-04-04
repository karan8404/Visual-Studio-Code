package Tic_Tac_Toe;

import java.util.Scanner;
public class Game {
    public char[][] board = new char[3][3];
    public boolean player = true;

    public void displayBoard() {
        System.out.printf("%c|%c|%c\n-|-|-\n", board[0][0], board[0][1], board[0][2]);
        System.out.printf("%c|%c|%c\n-|-|-\n", board[1][0], board[1][1], board[1][2]);
        System.out.printf("%c|%c|%c\n", board[2][0], board[2][1], board[2][2]);
    }

    public boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2])// checking rows
                return true;
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i])// checking columns
                return true;
        }
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2])// left diagonal
            return true;
        if (board[2][0] != ' ' && board[2][0] == board[1][1] && board[1][1] == board[0][2])// right diagonal
            return true;

        return false;
    }

    public boolean makeMove(int loc) {
        loc--;
        if (board[loc / 3][loc % 3] != ' ') {
            System.out.println("Position already occupied");
            return false;
        }
        board[loc / 3][loc % 3]=player?'X':'O';
        player = !player;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Game game = new Game();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                game.board[i][j] = ' ';
            }
        }

        for(int i=0;i<9;i++){
            int input;
            System.out.println("Enter the location.");
            input=sc.nextInt();
            if(!game.makeMove(input)){
                i--;
                continue;
            }
            game.displayBoard();
            if(game.checkWin()){
                System.out.println("Player Won!");
                System.exit(0);
            }
        }

        System.out.println("It is a Tie!");
        sc.close();
    }
}