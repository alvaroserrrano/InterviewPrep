package NQueen;



/*
 * We can improve runtime by noticing there is no point in placing
 * 2 queens in the same row/column-->We only need 1 queen per row 
 * We will check incremental addition
 * BACKTRACKING
 * We will check the board on each incremental addition(function isValid
 * Otherwise, we will recursively invoke a new solution
 * We stop until all queens are placed on the board
 */

public class NQueenProblem {
	
	final int N = 4;
	
	//Utility function to print solution
	void printSolution(int [][]board) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(" " + board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/*
	 * A utility function to check if a queen can be placed on board[row][col]
	 * THIS FUNCTION  is called when "col" queens are already placed 
	 * in columns from 0 to col-1.
	 * We need to check only left side for attacking queens
	 */
	boolean isSafe(int board[][], int row, int col) {
		int i, j;
		//check row on left side
		for(i = 0; i <col; i++)
			if(board[row][i] == 1)
				return false;
		//check upper diagonal on left side
		for(i = row, j = col; i >= 0 && j >= 0; i--, j--)
			if(board[i][j]  == 1)
				return false;
		//check lower diagonal on left side
		for (i=row, j=col; j>=0 && i<N; i++, j--) 
	        if (board[i][j]  == 1) 
	            return false; 
		
		return true;
	}
	
	
	/*
	 * A recursive utility function to solve NQueen problem
	 */
	boolean solveNQUtil(int[][]board, int col) {
		/*
		 * If all queens are placed-->return true
		 */
		if(col >= N)
			return true;
		for(int i = 0; i < N; i++) {
			/*
			 * Check if queen can be placed in board[i][col]
			 */
			if(isSafe(board, i, col)) {
				board[i][col] = 1;
				//Recursion to place the rest of queens
				if(solveNQUtil(board, col +1) == true)
					return true;
				/*
				 * If placing queen in board[i][col]
				 * does not solve the problem,
				 * then remove queen BACKTRACK
				 */
				board[i][col] = 0;
			}
			
		}
		/*
		 * If queen cannot be placed in any row in this col 
		 * then return false
		 */
		return false;
	}
	
	/*
	 * This function solves the problem using backTracking.
	 * It uses solveNQUtil to solve the problem
	 * It return false is queens cannot be placed
	 * Otherwise returns true and prints placement of queens with 1s
	 * This prints a feasible solution(There may be more)
	 */
	boolean solveNQ() {
		int[][]board = {{0, 0, 0, 0},
				{0, 0, 0, 0},
				{0, 0, 0, 0},
				{0, 0, 0, 0}};
		if(solveNQUtil(board, 0) == false) {
			System.out.printf("Solution does not exist");
			return false;
		}
		printSolution(board);
		return true;
	}
	
	//Driver program for testing
	public static void main(String args[]) {
		NQueenProblem Queen = new NQueenProblem();
		Queen.solveNQ();
	}//main
	
	
}//End of class
