package ch7ex19;

import java.util.*;
import java.awt.*;

public class TicTacToe {

    public static final int WIDTH = 3; // grid width
    public static final int HEIGHT = 3; // grid height
    ArrayList<Point> cellsToSet = new ArrayList<Point>();
    Boolean gameTie = false;
    public int player = 1;

    public enum Cell {
        EMPTY { // empty square - stored at ordinal 0
            public String getSymbol() {
                return "_";
            }
        },
        NOUGHT { // O - stored at ordinal 1
            public String getSymbol() {
                return "O";
            }
        },
        CROSS { // X - stored at ordinal 2
            public String getSymbol() {
                return "X";
            }
        };

        public abstract String getSymbol();
    }

    private Cell[][] board;

    // constructs gameboard with empty cells
    public TicTacToe() {
        board = new Cell[WIDTH][HEIGHT];
        for (int row = 0; row < WIDTH; row++) {
            for (int col = 0; col < WIDTH; col++) {
                board[row][col] = Cell.EMPTY;
            }
        }
    }

    public String toString() {
        String result = "";

        for (Cell[] row : board) {
            for (Cell data : row) {
                result += data.getSymbol();
            }
            result += "\n";
        }
        return result;
    }

    public int selectNextPlayer() {
        if (player == 1)
            player = 2;
        else
            player = 1;
        return player;
    }

    public Point selectSquare() {
        Random r = new Random();
        int row, col;
        Point p;

        while (true) {
            row = r.nextInt(WIDTH);
            col = r.nextInt(HEIGHT);
            p = new Point(row, col);

            if (cellsToSet.contains(p)) {
                continue;
            } else {
                cellsToSet.add(new Point(row, col));
                return p;
            }
        }
    }

    public void setCell(int row, int col, int value) {
        board[row][col] = Cell.values()[value];
    }

    public String playGame() {
        Point pointSelected;

        do {
            player = selectNextPlayer();
            pointSelected = selectSquare();
            setCell((int) (pointSelected.getX()), (int) (pointSelected.getY()), player);
        } while (!checkForWinner());

        if (!gameTie)
            return "\nPlayer '" + Cell.values()[player].getSymbol() + "' won!";
        else
            return "\nGame is a draw!";
    }

    public boolean checkForWinner() {
        boolean horizontalWin, verticalWin, diagonalWin1, diagonalWin2;

        diagonalWin1 = (board[0][0] != Cell.EMPTY && board[0][0] == board[1][1] && board[1][1] == board[2][2]);
        diagonalWin2 = (board[0][2] != Cell.EMPTY && board[2][0] == board[1][1] && board[1][1] == board[0][2]);

        if (diagonalWin1 || diagonalWin2) { // set of 3 noughts or crosses along first or second diagonal?
            return true;
        } else {
            for (int row = 0; row < WIDTH; row++) {
                for (int col = 0; col < WIDTH; col++) {
                    // set of 3 noughts or crosses along rows?
                    horizontalWin = (board[row][0] != Cell.EMPTY && board[row][0] == board[row][1]
                            && board[row][1] == board[row][2]);
                    // set of 3 noughts or crosses along columns?
                    verticalWin = (board[0][col] != Cell.EMPTY && board[0][col] == board[1][col]
                            && board[1][col] == board[2][col]);
                    // return true if one of the above criteria to win is met
                    if (horizontalWin || verticalWin)
                        return true;
                }
            }
        }
        // criteria to win not met
        if (cellsToSet.size() < 9) {
            return false;
        } else {
            gameTie = true;
            return true; // break out of do-while loop in playGame()
        }
    }

    public static void main(String[] args) {
        int count = 0, maxGames = 4;

        while (count < maxGames) {
            System.out.println("\nGame #" + ++count);
            System.out.println();
            TicTacToe gameboard = new TicTacToe();
            String winner = gameboard.playGame();
            System.out.println(gameboard + winner);
            System.out.println("_______________");
        }
    }
}

// diagonalWin1 set
// setCell(0, 0, player);
// setCell(1, 1, player);
// setCell(2, 2, player);

// diagonalWin2 set
// setCell(0, 2, player);
// setCell(1, 1, player);
// setCell(2, 0, player);

// horizontalWin set
// setCell(0, 0, player);
// setCell(0, 1, player);
// setCell(0, 2, player);

// verticalWin set
// setCell(0, 1, player);
// setCell(1, 1, player);
// setCell(2, 1, player);

// hw2_ch7_p329_pdf334_ex19
