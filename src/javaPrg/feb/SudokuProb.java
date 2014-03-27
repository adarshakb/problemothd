package javaPrg.feb;

public class SudokuProb {

	public static void main(String[] args) {
		SudokuProb solver = new SudokuProb();
		
		try {
			
			//Correct input
			System.out.println(solver.sudoku(new int[][]{
					{5,3,4,6,7,8,9,1,2},
					{6,7,2,1,9,5,3,4,8},
					{1,9,8,3,4,2,5,6,7},
					
					{8,5,9,7,6,1,4,2,3},
					{4,2,6,8,5,3,7,9,1},
					{7,1,3,9,2,4,8,5,6},
					
					{9,6,1,5,3,7,2,8,4},
					{2,8,7,4,1,9,6,3,5},
					{3,4,5,2,8,6,1,7,9}
					
				}));
			
			//wrong input  (2,2) and (5,2) is interchanged
			System.out.println(solver.sudoku(new int[][]{
					{1,2,3,4,5,6,7,8,9},
					{2,5,4,5,6,7,8,9,1},
					{3,4,5,6,7,8,9,1,2},
					
					{4,3,6,7,8,9,1,2,3},
					{5,6,7,8,9,1,2,3,4},
					{6,7,8,9,1,2,3,4,5},
					
					{7,8,9,1,2,3,4,5,6},
					{8,9,1,2,3,4,5,6,7},
					{9,1,2,3,4,5,6,7,8}
					
				}));
			
			//wrong input: random numbers put in. 
			System.out.println(solver.sudoku(new int[][]{
					{1,2,3,4,5,6,7,8,9},
					{2,3,4,5,6,7,8,9,1},
					{3,6,5,6,7,8,9,1,2},
					
					{4,5,6,7,8,9,1,2,3},
					{5,6,7,8,9,1,2,3,4},
					{6,7,8,9,1,2,3,4,5},
					
					{7,8,9,1,2,3,3,5,6},
					{8,9,1,2,3,4,5,6,7},
					{9,1,2,3,4,5,6,7,8}
					
				}));
		} catch (Exception e) {
			//handle exception here and log it
		}
	}
	
/*
 * QUESTION:

Write a method that checks whether a filled out grid is a valid solution. 

You may use a matrix of ints to represent the grid.

You may assume that no values less than 1 or greater than 9 will appear in the grid.
 */
	/*
	 * assumptions
	 * sudoku is given in a 9*9 2D integer array in java
	 * 
	 * Logic:
	 * Check each row and each column and each 3*3 matrix add upto 45.
	 * 
	 * Complexity:
	 * where n is the number of rows/columns in the input.
	 * 
	 * Time o(n)
	 * space o(n) in number of objects
	 */
	public boolean sudoku(int[][] inp) throws Exception {
		
		if(!(inp.length > 0 && inp[0].length > 0 && inp.length == inp[0].length))
			throw new Exception("Exception with input values");
	
		Thread[] horizontal = new Thread[inp.length];
		summerHorizontal[] sumH = new summerHorizontal[inp.length];
		Thread[] vertical = new Thread[inp.length];
		summerVertical[] sumV = new summerVertical[inp.length];
		summerGrid gridObj = new summerGrid(inp, 0);
		Thread grid = new Thread(gridObj);
		grid.start();
		
		for(int i=0;i<inp.length;i++) {
			sumH[i] = new summerHorizontal(inp, i);
			sumV[i] = new summerVertical(inp, i);
			
			horizontal[i] = new Thread(sumH[i]);
			vertical[i] = new Thread(sumV[i]);
			
			horizontal[i].start();
			vertical[i].start();
		}
		
		
		for(int i=0;i<inp.length;i++) {
			horizontal[i].join();
			vertical[i].join();
			
			if ((sumH[i].isAns() && sumV[i].isAns()) == false) {
				return false;
			}
		}
		
		grid.join();

		return true && gridObj.isAns();
	}
	
	public class summerHorizontal implements Runnable {
		int[][] inp;
		int num;
		
		private boolean ans = true;
		
		
		public summerHorizontal(int[][] inpIn,int numIn) {
			inp = inpIn;
			num = numIn;
			
		}

		@Override
		public void run() {
			int sum1 = 0;
			for(int i=0;i<inp.length;i++) {
					sum1 += inp[i][num];
			}
			
			if(sum1 != 45 ) {
				setAns(false);
			}
				
		}

		public void setAns(boolean ans) {
			this.ans = ans;
		}

		public boolean isAns() {
			return ans;
		}

	}
	public class summerVertical implements Runnable {
		int[][] inp;
		int num;
		
		private boolean ans = true;
		
		
		public summerVertical(int[][] inpIn,int numIn) {
			inp = inpIn;
			num = numIn;
			
		}

		@Override
		public void run() {
			int sum1 = 0;
			for(int i=0;i<inp.length;i++) {
					sum1 += inp[num][i];
			}
			
			if(sum1 != 45 ) {
				setAns(false);
			}
				
		}

		public void setAns(boolean ans) {
			this.ans = ans;
		}

		public boolean isAns() {
			return ans;
		}

	}
	public class summerGrid implements Runnable {
		int[][] inp;
		int num;
		
		private boolean ans = true;
		
		
		public summerGrid(int[][] inpIn,int numIn) {
			inp = inpIn;
			num = numIn;
			
		}

		@Override
		public void run() {
			for(int i=0;i<3;i+=3) {
				for(int j=0;j<3;j+=3) {
					int tmp = 	inp[i][j] + inp[i][j+1] + inp[i][j+2] + 
								inp[i+1][j] + inp[i+1][j+1] + inp[i+1][j+2] + 
								inp[i+2][j] + inp[i+2][j+1] + inp[i+2][j+2] ;
					if(tmp != 45) {
						setAns(false);
					}
				}
			}
		}

		public void setAns(boolean ans) {
			this.ans = ans;
		}

		public boolean isAns() {
			return ans;
		}
	}
}
