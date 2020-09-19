package Chapter1;

public class Question8 {

	//If any element in an M*N matrix is 0, the row and column of that matrix should become 0
	//We have to separately handle 0th row and column
	//complexity: O(m*n)
	private void fillMatrixRowsAndColsByZero(int[][] matrix,int rows, int cols) {
		boolean rowZero = false;
		boolean colZero = false;
		
		for(int j=0;j<cols;j++) {
			if(matrix[0][j] == 0) {
				rowZero = true;
			}
		}
		
		for(int i=0;i<rows;i++) {
			if(matrix[i][0] == 0) {
				colZero = true;
			}
		}
		
		for(int i=1;i<rows;i++) {
			for(int j=1;j<cols;j++){
				if(matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		for(int i=1;i<rows;i++) {
			for(int j=1;j<cols;j++){
				if(matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		
		for(int i=0;i<rows;i++) {
			if(rowZero) {
				matrix[i][0] = 0;
			}
		}
		
		for(int j=0;j<cols;j++) {
			if(colZero) {
				matrix[0][j] = 0;
			}
		}
		
		System.out.println("The final matrix is:");
		printMatrix(matrix, rows, cols);
	}
	
	
	private void printMatrix(int[][] matrix,int rows, int cols) {
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
		int[][] matrix = {
				{0, 1, 1, 1, 0, 1, 1},
				{1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1},
				{0, 1, 1, 1, 1, 1, 1}
		};
		Question8 obj = new Question8();
		System.out.println("The initial matrix is:");
		obj.printMatrix(matrix, m, n);
		obj.fillMatrixRowsAndColsByZero(matrix, m, n);
	}
}
