package packagee;

public class SudokuSolver {
	private static final int SIZE = 9; 
    private static final int EMPTY = 0;  

    public void initializeBoard(int[][][] board, int[][] initialBoard) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                board[row][col][0] = initialBoard[row][col];
                if (initialBoard[row][col] == EMPTY) {
                    for (int k = 1; k <= SIZE; k++) {
                        board[row][col][k] = 1; 
                    }
                }
            }
        }
    }

    public boolean solveSudoku(int[][][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col][0] == EMPTY) {
                    for (int num = 1; num <= SIZE; num++) {
                        if (isSafe(board, row, col, num)) {
                            board[row][col][0] = num;
                            if (solveSudoku(board)) {
                                return true;
                            }
                            board[row][col][0] = EMPTY; 
                        }
                    }
                    return false;
                }
            }
        }
        return true; 
    }

    private boolean isSafe(int[][][] board, int row, int col, int num) {
        for (int c = 0; c < SIZE; c++) {
            if (board[row][c][0] == num) return false;
        }
        for (int r = 0; r < SIZE; r++) {
            if (board[r][col][0] == num) return false;
        }
        int boxRowStart = row - row % 3;
        int boxColStart = col - col % 3;
        for (int r = boxRowStart; r < boxRowStart + 3; r++) {
            for (int c = boxColStart; c < boxColStart + 3; c++) {
                if (board[r][c][0] == num) return false;
            }
        }
        return true;
    }

    public void printBoard(int[][][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print(board[row][col][0] + " ");
            }
            System.out.println();
        }
    }
}
