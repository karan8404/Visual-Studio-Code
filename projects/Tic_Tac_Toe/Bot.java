package Tic_Tac_Toe;

import java.util.Scanner;

public class Bot {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BitBoard board = new BitBoard();
        

        //To determine who goes first
        while (true) {
            System.out.println("Would you like to go first[Y/N].");
            char choice = sc.next().charAt(0);

            if (choice == 'Y' || choice == 'y') {
                break;
            } else if (choice == 'N' || choice == 'n') {
                board.player = false;
                break;
            }
        }

        int input;
        while (!board.checkTie())
        {

            if(board.isPlayerTurn())
            {
                System.out.println("Your turn!");
                System.out.println("Enter the location to enter[1-9]");
                input = sc.nextInt();
            }
            else
            {
                System.out.println("Bot Played...");
                //input=Game.get(board)[1];//for getting the best move
                input=Game.getRandomMove(board)[1];
            }

            if (!board.makeMove(input)) {
                System.out.println("Invalid move");
                continue;
            }
            board.displayBoard();
            System.out.println("\n\n");
            
            
            if (board.checkWin()) {
                System.out.println(board.getWinner() + " Won");
                sc.close();
                System.exit(0);
            }
        }
        System.out.println("Game Tied!");
        sc.close();
    }
}
