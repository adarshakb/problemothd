package javaPrg.feb;

public class SudokuProb {

	public static void main(String[] args) {
		SudokuProb solver = new SudokuProb();
		
		try {
			
			//Correct input
			System.out.println(solver.sudoku(new int[][]{
					{1,2,3,4,5,6,7,8,9},
					{2,3,4,5,6,7,8,9,1},
					{3,4,5,6,7,8,9,1,2},
					
					{4,5,6,7,8,9,1,2,3},
					{5,6,7,8,9,1,2,3,4},
					{6,7,8,9,1,2,3,4,5},
					
					{7,8,9,1,2,3,4,5,6},
					{8,9,1,2,3,4,5,6,7},
					{9,1,2,3,4,5,6,7,8}
					
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
	 * Check each row and each column add upto 45. This will check all the 3 conditions.
	 * Do this in parallel to reduce time.
	 * 
	 * Complexity:
	 * where n is the number of rows/columns in the input.
	 * 
	 * Space: o(n) - only extra pointer variables/storage for rows/columns used.
	 * 
	 * Time: o(n) 
	 */
	public boolean sudoku(int[][] inp) throws Exception {
		
		if(!(inp.length > 0 && inp[0].length > 0 && inp.length == inp[0].length))
			throw new Exception("Exception with input values");
		
		boolean ans = true;
		
		Thread[] horizontal = new Thread[inp.length];
		Thread[] verticle = new Thread[inp.length];
		summer[] values = new summer[2*inp.length];
		
		
		for(int i=0,j=0;i<inp.length;i++) {
			values[j] = new summer(inp, true, i);
			horizontal[i] = new Thread(values[j]);
			j++;
			values[j] = new summer(inp, false, i);
			verticle[i] = new Thread(values[j]);
			j++;
			
			horizontal[i].start();
			verticle[i].start();
		}
		
		for(int i=0;i<inp.length;i++) {
			horizontal[i].join();
			verticle[i].join();
			
			if(values[i].getValue() != 45 || values[i+1].getValue() != 45)
				return false;
		}
		
		return true;
	}
	
	public class summer implements Runnable {
		private int[][] inp;
		private boolean horizontal = true;
		int num = 0;
		private long value = 0;
		
		public summer(int[][] inpIn, boolean horizontalIn,int numIn) {
			inp = inpIn;
			horizontal = horizontalIn;
			num = numIn;
		}
		
		@Override
		public void run() {
			setValue(0);
			for(int i=0;i<inp.length;i++) {
				if(horizontal) {
					value += inp[num][i];
				} else {
					value += inp[i][num];
				}
			}
		}
		
		public long getValue() {
			return value;
		}
		
		public void setValue(long valueIn) {
			value = valueIn;
		}
	}
}
