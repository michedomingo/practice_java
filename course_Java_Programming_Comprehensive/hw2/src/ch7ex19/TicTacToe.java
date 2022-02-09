package ch7ex19;

import java.util.*;
import java.awt.*;

public class TicTacToe {

    public static final int WIDTH = 3; // grid width
    public static final int HEIGHT = 3; // grid height
    ArrayList<Point> fillSquare = new ArrayList<Point>();
    Boolean gameTie = false;
    public int player = 1;

    public enum Cell {
        EMPTY { // empty square - stored as a 0
            public String getSymbol() {
                return "_";
            }
        },
        NOUGHT { // O - stored as a 1
            public String getSymbol() {
                return "O";
            }
        },
        CROSS { // X - stored as a 2
            public String getSymbol() {
                return "X";
            }
        };

        public abstract String getSymbol();
    }

    private Cell[][] board;

    // constructor
    public TicTacToe() {
        board = new Cell[WIDTH][HEIGHT];
        for (int row = 0; row < WIDTH; row++) {
            for (int col = 0; col < WIDTH; col++) {
                board[row][col] = Cell.EMPTY;
            }
        }
    }

    public void setCell(int row, int col, int value) {
        board[row][col] = Cell.values()[value];
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

    public Point fillBoard() {
        Random r = new Random();
        int row, col;
        Point p;

        while (true) {
            row = r.nextInt(WIDTH);
            col = r.nextInt(HEIGHT);
            p = new Point(row, col);

            System.out.println("row: " + row);
            System.out.println("col: " + col);

            if (fillSquare.contains(p)) {
                System.out.println("try again...");
                continue;
            } else {
                fillSquare.add(new Point(row, col));
                return p;
            }
        }
    }

    public String playGame() {
        int count = 0;
        Point filledPoint;

        do {
            System.out.println("\tTurn #" + ++count);
            player = selectNextPlayer();
            System.out.println("\tplayer: " + Cell.values()[player]);

            filledPoint = fillBoard();
            setCell((int) (filledPoint.getX()), (int) (filledPoint.getY()), player);

        } while (!checkForWinner());

        System.out.println("\ncheckForWinner(): " + checkForWinner());

        if (!gameTie)
            return "\nPlayer '" + Cell.values()[player].getSymbol() + "' won!";
        else
            return "\nGame is draw!";
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
        if (fillSquare.size() < 9) {
            return false;
        } else {
            gameTie = true;
            return false;
        }
    }

    public static void main(String[] args) {
        TicTacToe gameboard = new TicTacToe();
        String winner = gameboard.playGame();
        System.out.println(gameboard + winner);
    }
}

// diagonalWin1 set
// setCell(0, 0, player);
// setCell(1, 1, player);
// setCell(2, 2, player);

// diagonalWin2 set
// gameboard.setCell(0, 2, Cell.CROSS);
// gameboard.setCell(1, 1, Cell.CROSS);
// gameboard.setCell(2, 0, Cell.CROSS);

// horizontalWin set
// gameboard.setCell(0, 0, Cell.CROSS);
// gameboard.setCell(0, 1, Cell.CROSS);
// gameboard.setCell(0, 2, Cell.CROSS);

// verticalWin set
// gameboard.setCell(0, 1, Cell.CROSS);
// gameboard.setCell(1, 1, Cell.CROSS);
// gameboard.setCell(2, 1, Cell.CROSS);

// hw2_ch7_p329_pdf334_ex19
