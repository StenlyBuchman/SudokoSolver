package packagee;

public class Main {
    public static void main(String[] args) {
        int[][][] board = new int[9][9][10];

        int[][] initialBoard = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        SudokuSolver solver = new SudokuSolver();
        
 
        solver.initializeBoard(board, initialBoard);
        
        if (solver.solveSudoku(board)) {
            System.out.println("לוח הסודוקו נפתר בהצלחה:");
            solver.printBoard(board);
        } else {
            System.out.println("לא נמצא פתרון ללוח הסודוקו.");
        }
    }
}