package Chapter1;

public class Question7 {
	
	/*
	 * 	90 degree rotation of a m*n matrix would be shown like:
	    * * * ^ * * *
	 	* * * | * * *
	 	* * * | * * *
	 	* * * | * * *
	 * 
	 * should change to: 
	 * 
	  	* * * *
	  	* * * *
	  	* * * *
		- - - >
	 	* * * *
	 	* * * *
	 	* * * *
	 *
	 * So, if we see carefully: the first row becomes the last column, second row becomes the second last column and so on and last row becomes the first column.
	 * */
	
	private void rotateMatrixBy90Deg(char[][] matrix,int rows, int cols) {
		//Initializing a matrix with initial matrix's rows as columns and columns as rows
		char[][] rotatedMatrix = new char[cols][rows];
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				rotatedMatrix[j][rows-i-1] = matrix[i][j];
			}
		}
		System.out.println("\nThe matrix after rotation is:");
		printMatrix(rotatedMatrix, cols, rows);
	}
	
	private void printMatrix(char[][] matrix,int rows, int cols) {
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int m = 4;
		int n = 7;
		char[][] matrix = {
				{'*', '*', '*', '^', '*', '*', '*'},
				{'*', '*', '*', '|', '*', '*', '*'},
				{'*', '*', '*', '|', '*', '*', '*'},
				{'*', '*', '*', '|', '*', '*', '*'}
		};
		Question7 obj = new Question7();
		System.out.println("The initial matrix is:");
		obj.printMatrix(matrix, m, n);
		obj.rotateMatrixBy90Deg(matrix,m,n);
	}
}
