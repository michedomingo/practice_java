package ch7ex19;

public class TicTacToe {

    public static final int WIDTH = 3; // grid width
    public static final int HEIGHT = 3; // grid height

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

    public void setCell(int row, int col, Cell value) {
        // if the row is less than 0 or bigger than the board len, return error
        board[row][col] = value;
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

    public void playGame() {

    }

    public boolean checkForWinner() {
        boolean horizontalWin, verticalWin, diagonalWin1, diagonalWin2;

        diagonalWin1 = (board[0][0] != Cell.EMPTY && board[0][0] == board[1][1] && board[1][1] == board[2][2]);
        diagonalWin2 = (board[0][2] != Cell.EMPTY && board[2][0] == board[1][1] && board[1][1] == board[0][2]);
        // set of 3 noughts or crosses along first or second diagonal?
        if (diagonalWin1 || diagonalWin2) {
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
        return false;
    }

    public static void main(String[] args) {
        TicTacToe gameboard = new TicTacToe();
        System.out.println(gameboard);
        // diagonalWin1 set
        gameboard.setCell(0, 0, Cell.CROSS);
        gameboard.setCell(1, 1, Cell.CROSS);
        gameboard.setCell(2, 2, Cell.CROSS);

        System.out.println(gameboard);
        System.out.println(gameboard.checkForWinner());

    }
}

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
