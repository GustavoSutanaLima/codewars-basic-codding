package challenges;

public class TicTacToeChecker {

    public static void main(String[] args) {

        int[][] myBoard = {{1, 0, 2},{2, 0, 1},{1, 0, 2}};

        System.out.println(isSolved(myBoard));

    }

    public static int isSolved(int[][] board) {

        //i had to hardcode this solution, nothing came to mind ;(
        for (int i = 0; i< board.length; i++) {
            if (board[i][0] != 0 && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return board[i][0];
            }
            else if (board[0][i] != 0 && board[0][i] == board[1][i] && board[0][i]  == board[2][i]) {
                return board[0][i];
            }
            else if (board[0][0] != 0 && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
                return board[0][0];
            }
            else if (board[2][0] != 0 && board[2][0] == board[1][1] && board[1][1] == board[0][2]) {
                return board[2][0];
            }
        }
        
        if (arrayOfArraysSum(board)== 13 || arrayOfArraysSum(board) == 14)
            return 0;

        return -1;
    }

    private static int arrayOfArraysSum(int[][] arrayOfArrays) {
        //irá segurar a soma dos elementos do array:
        int sum = 0;

        for (int i = 0; i < arrayOfArrays.length; i++) {
            for (int j = 0; j < arrayOfArrays[i].length; j++) {
                sum+=arrayOfArrays[i][j];
            }
        }

        return sum;
    }

}
