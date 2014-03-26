package javaPrg.feb;

import java.math.BigInteger;
import java.util.Arrays;

public class ProductOfAnArray {
	
	public static void main(String[] args) {
		
		try {
			System.out.println(Arrays.toString(ProductOfAnArray.calcArray( new int[]{4,3,2,8} )));
			System.out.println(Arrays.toString(ProductOfAnArray.calcArray( new int[]{4,0,2,8} )));
			System.out.println(Arrays.toString(ProductOfAnArray.calcArray( new int[]{4,0,2,0} )));
			System.out.println(Arrays.toString(ProductOfAnArray.calcArray( new int[]{} )));
			System.out.println(Arrays.toString(ProductOfAnArray.calcArray( new int[]{4,3,2,8,3,2,4,6,7,3,2,4} )));
			System.out.println(Arrays.toString(ProductOfAnArray.calcArray( new int[]{4,3,2,8,3,2,4,6,7,3,2,4} )));
			System.out.println(Arrays.toString(ProductOfAnArray.calcArray( new int[]{4432432,23423423,34234,23423428,4324243,24232,2342344,64234234,4324247,4234233,234422,234244} )));
		} catch (Exception e) {
			//debug exception here and log.
		}
	}
	
	
	
	/*
	 * Problem:
	 * Given an array of integers, produce an array whose values are the product of every other integer 
	 * excluding the current index.
	 * 
	 * Assumptions. 
	 * Input array cannot be modified.
	 * input is an integer array
	 * "produce an array" - type not specified for output array
	 * 
	 * Logic explanation:
	 * 
	 * Assume we have array [a,b,c,d]
	 * Let multiple be multiple of each element in array.
	 * Hence multiple = 0 if one of the element is 0;
	 * To produce the output.
	 * 		Ans at i -> multiple divided by the value at i.
	 * 			if 2 numbers are 0 then entire output will be 0 because atleast one 0 will be a multiple
	 * 			if 1 number is 0 then every thing else will be 0 except that index whole value is to be determined
	 * 
	 * 
	 * Complexity:
	 * 
	 * 		Time: o(n) - > where n is the length of the array.
	 * 				
	 * 		Space: o(n) - > where n is the length of the array.
	 */
	public static BigInteger[] calcArray(final int[] inp) throws Exception {
		if(inp == null)
			throw new Exception("input is null");
		
		int cnt = 0;
		BigInteger multiple = new BigInteger("1");
		boolean foundZero = false;
		
		for (int i : inp) {
			if(i==0) {
				cnt++;
				foundZero = true;
				if(cnt < 2)
					continue;
				else
					break;
			}
			multiple = multiple.multiply(BigInteger.valueOf(i));
		}
		
		
		BigInteger ans[] = new BigInteger[inp.length];
		
		for(int i=0;i<inp.length;i++) {
			if(foundZero) {
				if(cnt < 2) {
					ans[i] = (inp[i] == 0) ? multiple : new BigInteger("0");
				}
				else {
					ans[i] = new BigInteger("0");
				}
			}
			else {
				ans[i] = multiple.divide(BigInteger.valueOf(inp[i]));
			}
		}
		return ans;
	}

}
