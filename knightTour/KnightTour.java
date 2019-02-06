package interviewPrep;


/*
 * BACKTRACKING ALGORITHM
 * 
 * IF all squares are visited
 * 		print solution
 * ELSE
 * 		1. Add item to backtracking vector === add move to solution vector
 * 		2. Recursively check if the movement leads to a solution
 * 				(8 possible movements)
 * 			
 * 				IF !solution for that step
 * 					Remove movement in previous step from solution vector
 * 					Try another move
 * 				
 * 				IF !solution for any step
 * 					No solution exists 
 */				

public class KnightTour {

	//chessboard with 8 x 8 cells.
	static int N = 8;
	
	
	//Utility function to check if i, j are valid indexes for N x N board
	static boolean isSafe(int x, int y, int [][] sol) {
		return(x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
	}//isSafe
	
	//Utility function to print solution
	static void printSolution(int [][] sol) {
		for (int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++)
				System.out.print(sol[i][j] + " ");
			System.out.println();
		}
	}//printSolution
	
	/*
	 * SOLVE PROBLEM
	 * Call to solveKTUtil()
	 * 		if !sol -->return false
	 * 		else --> return true and print the tour
	 */
	static boolean solveKT() {
		//Create board
		int sol[][] = new int [8][8];
		
		//Initialize board
		for(int i = 0; i < 8 ; i++) {
			for(int j = 0; j < 8; j++)
				sol[i][j] = -1;
		}
		
		//Define moves of the knight based on x and y coordinates
		int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
		int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};
		
		//Starting position will be a 0
		sol[0][0] = 0;
		
		//Start from (0,0) and explore all tours
		if(!solveKTUtil(0, 0, 1, xMove, yMove, sol)) {
			System.out.println("Solution does not exist");
			return false;
		}else {
			printSolution(sol);
		}
		return true;
			
	}//solveKT
	
	//Recursive and utility function to solve problem
	static boolean solveKTUtil(int x, int y, int moveNum, int []xMove,
			int []yMove, int sol[][]) {
		int k, next_x, next_y;
		
		//Test if numMovements == allSquares
		if(moveNum == N * N)
			return true;
		
		//Try all moves from current coordinate (x=0, y=0)
		for(k = 0; k < 8; k++) {
			next_x = x + xMove[k];
			next_y = y + yMove[k];
			if(isSafe(next_x, next_y, sol)) {
				sol[next_x][next_y] = moveNum;
				if(solveKTUtil(next_x, next_y, moveNum + 1, xMove, yMove, sol))
					return true;
				else
					sol[next_x][next_y] = - 1;//backtracking
			}
		}
		return false;
	}//solveKTUtil
	
	public static void main(String[] args) {
		solveKT();
	}//main
	
}//class
