package interviewPrep;

import java.io.*;

public class printMatrixClockwise {

	//Given a N by M matrix of numbers, print out the matrix in a clockwise spiral.
	/* matrix well-formed and uniform? assuming yes -- meaning there are no extra elements in arrays and the matrix is exactly a rectangular shape.

		 assuming starting at 0,0
		
		 clockwise start is:
		
		 go right
		 go down
		 go left
		 go up
		
		 in a repeated pattern until all barriers have been hit
		
		 we need to keep track of the boundary wall positions:
		
		 top
		 right
		 bottom
		 left
	*/
	
	
	
	/*
	 * rowIndex = 3, columnIndex = 4
		top = right = bottom = left = null
		currentPosition = 0,0
		
		start at currentPosition, top = 0
		
		go right until rightBoundary (null || columnIndex + 1), rightBoundary = 4, cp = 0,4
		go down until bottomBoundary (null || rowIndex) + 1, bottomBoundary = 3, cp = 3,4
		go left until leftBoundary (null || -1), leftBoundary = 0, cp = 3,0
		go up until topBoundary (0), top = 1, cp = 1,0
		
		go right until rightBoundary (4), rightBoundary = 3, cp = 1,3
		go down until bottomBoundary(3), bottomBoundary = 2, cp = 2,3
		go left until leftBoundary(0), leftBoundary = 1, cp = 2,1
		
		if at any point going in any direction hits our boundary, the loop should stop
		
		if going right, (cp.y + 1 = rightBoundary), break
		if going down, (cp.x + 1 = bottomBoundary), break
		if going left, (cp.y - 1 = leftBoundary), break
		if going up, ( cp.x - 1 = topBoundary), break
	 */
	
	
	static void spiralPrint(int m, int n, int a[][]) {
		//m is number of rows
		//n is number of columns
		
		/*
		 * k- starting row index
		 * m- ending row index
		 * l- starting column index
		 * n- ending column index
		 * i- iterator
		 */
		int i, k = 0, l = 0;
		
		while(k < m && l < n) {
			
			//Print first row from remaining rows
			for(i = l; i < n; ++i) {
				System.out.print(a[k][i] + " ");
			}
			k++;
			
			//Print last column from the remaining
			for (i = k; i < m; ++i) {
				System.out.print(a[i][n-1] + " ");
			}
			n--;
			
			//Print last row from remaining
			if(k < m) {
				for(i = n - 1; i >= l; --i) {
					System.out.print(a[m-1][i] + " ");
				}
				m--;
			}
			
			//Print first column from remaining
			if(l<n) {
				for(i = m-1; i>= k; --i) {
					System.out.print(a[i][l] + " ");
				}
				l++;
			}
			
		}//while
	}//method
	
	//DRIVER PROGRAM
	
	public static void main(String[] args) {
		//Number of rows
		int R = 3;
		
		//Number of columns
		int C = 6;
		
		//Matrix
		int [][] a = { {1,  2,  3,  4,  5,  6}, 
                {7,  8,  9,  10, 11, 12}, 
                {13, 14, 15, 16, 17, 18} 
              }; 
		spiralPrint(R,C, a);

	}//main

}//class
