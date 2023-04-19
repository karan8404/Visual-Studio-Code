package Tic_Tac_Toe;

import java.util.ArrayList;
import java.util.Scanner;

public class Game 
{

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        BitBoard board = new BitBoard();
        int input;

        while (!board.checkTie()) 
        {
            System.out.println("Enter the location to enter[1-9]");
            input = sc.nextInt();

            if (!board.makeMove(input)) 
            {
                System.out.println("Invalid move");
                continue;
            }

            board.displayBoard();
            if (board.checkWin()) 
            {
                System.out.println(board.getWinner() + " Won");
                sc.close();
                System.exit(0);
            }
            
            System.out.println("Best Move-->"+bestMove(board));
        }
        System.out.println("Game Tied!");
        sc.close();
    }

    public static int bestMove(BitBoard board){
        int bestBoardIndex=-1;

        if (board.isPlayerTurn()) 
        {
            int maxEval = Integer.MIN_VALUE;

            for (BitBoard child : getMoves(board)) 
            {
                int eval = minimax(child);
                if(eval>=maxEval){
                    maxEval=eval;
                    bestBoardIndex=child.lastLoc;
                }
            }
            return bestBoardIndex;
        } 
        else 
        {
            int minEval = Integer.MAX_VALUE;
            for (BitBoard child : getMoves(board)) 
            {
                int eval=minimax(child);
                if(eval<=minEval){
                    minEval=eval;
                    bestBoardIndex=child.lastLoc;
                }            }
            return bestBoardIndex;
        }
    }

    public static int minimax(BitBoard board) 
    {//TODO fix minimax
        if (board.checkTie())
            return 0;
        if (board.checkWin())
            return board.isPlayerTurn()?-1:1;// if players move and win found bot must've won.

        if (board.isPlayerTurn()) 
        {
            int maxEval = Integer.MIN_VALUE;

            for (BitBoard child : getMoves(board)) 
            {
                int eval = minimax(child);
                maxEval = Math.max(eval, maxEval);
            }
            return maxEval;
        } 
        else 
        {
            int minEval = Integer.MAX_VALUE;
            for (BitBoard child : getMoves(board)) 
            {
                int eval=minimax(child);
                minEval=Math.min(eval, minEval);
            }
            return minEval;
        }

    }

    public static ArrayList<BitBoard> getMoves(BitBoard board) 
    {
        BitBoard currBoard = new BitBoard();
        ArrayList<BitBoard> moves = new ArrayList<>(9);
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board.pos(i, j).isEmpty()) 
                {
                    currBoard = board.clone();
                    currBoard.makeMove(i * 3 + j + 1);
                    currBoard.lastLoc=i*3+j+1;

                    moves.add(currBoard);
                    currBoard = new BitBoard();
                }
        return moves;
    }
}