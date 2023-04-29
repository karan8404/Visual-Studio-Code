package Tic_Tac_Toe;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Game {
    static int called = 0;// how many times minimax is called.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BitBoard board = new BitBoard();
        int input;

        while (!board.checkTie()) {
            System.out.println("Enter the location to enter[1-9]");
            input = sc.nextInt();

            if (!board.makeMove(input)) {
                System.out.println("Invalid move");
                continue;
            }

            board.displayBoard();
            if (board.checkWin()) {
                System.out.println(board.getWinner() + " Won");
                System.out.printf("Minimax called--> %d times", called);
                sc.close();
                System.exit(0);
            }
            int[] eval = getEval(board,9);

            if (eval[0] > 0)
                System.out.println("Player Should Win,eval = " + eval[0]);
            else if (eval[0] == 0)
                System.out.println("Should Tie,eval = " + eval[0]);
            else if (eval[0] < 0)
                System.out.println("Bot Should Win,eval = " + eval[0]);
            else
                System.out.println("Something Broke!,eval = " + eval[0]);

            System.out.println("Best Move-->" + eval[1]);
        }
        System.out.println("Game Tied!");
        System.out.printf("Minimax called--> %d times", called);
        sc.close();
    }

    // gets a random from the move pool
    // which doesnt change the ultimate outcome
    public static Integer[] getRandomMove(BitBoard board,int depth) {
        Stack<Integer[]> moveList = new Stack<>();

        if (board.isPlayerTurn()) {
            for (BitBoard child : getMoves(board)) {
                Integer[] eval =new Integer[2];
                eval[0]=minimax(child, depth);
                eval[1]=child.lastLoc;
                int sign = Integer.signum(eval[0]);

                while (!moveList.isEmpty() && Integer.signum(moveList.peek()[0]) < sign)
                    moveList.pop();

                if(moveList.isEmpty() || Integer.signum(moveList.peek()[0]) == sign)
                    moveList.add(eval);
            }
        } else {
            for (BitBoard child : getMoves(board)) {

                Integer[] eval =new Integer[2];
                eval[0]=minimax(child, depth);
                eval[1]=child.lastLoc;
                int sign = Integer.signum(eval[0]);

                while (!moveList.isEmpty() && Integer.signum(moveList.peek()[0]) > sign)
                    moveList.pop();

                if(moveList.isEmpty() || Integer.signum(moveList.peek()[0]) == sign)
                    moveList.add(eval);
            }
        }

        // generates random number between between 0 and size
        //thus getting a random element from the stack
        return moveList.elementAt((new Random()).nextInt(moveList.size()));
    }

    // eval[0]=evaluation,eval[1]=best move
    public static int[] getEval(BitBoard board,int depth) {
        int bestBoardIndex = -1;
        int res[] = new int[2];
        if (board.isPlayerTurn()) {
            int maxEval = Integer.MIN_VALUE;

            for (BitBoard child : getMoves(board)) {
                int eval = minimax(child, depth);
                if (eval > maxEval) {
                    maxEval = eval;
                    bestBoardIndex = child.lastLoc;
                }
            }
            res[0] = maxEval;
            res[1] = bestBoardIndex;
            return res;
        } else {
            int minEval = Integer.MAX_VALUE;
            for (BitBoard child : getMoves(board)) {
                int eval = minimax(child, depth);
                if (eval < minEval) {
                    minEval = eval;
                    bestBoardIndex = child.lastLoc;
                }
            }
            res[0] = minEval;
            res[1] = bestBoardIndex;
            return res;
        }
    }

    public static int minimax(BitBoard board, int depth) {
        called++;
        if (board.checkWin())
            return (board.isPlayerTurn() ? -1 : 1) * depth;// if players move and win found bot must've won.
        if (board.checkTie())
            return 0;

        if (board.isPlayerTurn()) {
            int maxEval = Integer.MIN_VALUE;

            for (BitBoard child : getMoves(board)) {
                int eval = minimax(child, depth - 1);
                maxEval = Math.max(eval, maxEval);
            }
            return maxEval;
        } else {
            int minEval = Integer.MAX_VALUE;
            for (BitBoard child : getMoves(board)) {
                int eval = minimax(child, depth - 1);
                minEval = Math.min(eval, minEval);
            }
            return minEval;
        }

    }

    public static ArrayList<BitBoard> getMoves(BitBoard board) {
        BitBoard currBoard = new BitBoard();
        ArrayList<BitBoard> moves = new ArrayList<>(9);
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board.pos(i, j).isEmpty()) {
                    currBoard = board.clone();
                    currBoard.makeMove(i * 3 + j + 1);
                    currBoard.lastLoc = i * 3 + j + 1;

                    moves.add(currBoard);
                    currBoard = new BitBoard();
                }
        return moves;
    }
}