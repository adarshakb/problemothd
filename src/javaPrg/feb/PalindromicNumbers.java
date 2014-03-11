package javaPrg.feb;

public class PalindromicNumbers {
	public static void main(String args[]) {
		//since java get arguments as String. convert it		
		System.out.println("Is Palindromic:\n" +
				"\n121 " + isPalindromic(121l) +
				"\n1221 " + isPalindromic(1221l) +
				"\n12343 " +isPalindromic(12343l) +
				"\n12213 " + isPalindromic(12213l) +
				"\n64277 " + isPalindromic(64277l) +
				"\n121.121 " + isPalindromic(121.121) +
				"\n121.21 " + isPalindromic(121.21) +
				"\n0.1 " + isPalindromic(0.1) +
				"\n1.0 " + isPalindromic(1.0) +
				"\n1.1 " + isPalindromic(1.1) +
				"\n10.01 " + isPalindromic(10.01) +
				"\n92.2945 " + isPalindromic(92.2945) +
				"\n2213312.22 " + isPalindromic(2213312.22) +
				"\n12343.21 " + isPalindromic(12343.21) +
				"\n12.34321 " + isPalindromic(12.34321));
	}
	
	private static boolean isPalindromic(double inp) {
		long tmp= (long)inp;
		double num = inp;
		while(tmp > 0 && num != (long)num) {
			tmp/=10;
			num*=10;
		}
		if(tmp == 0 && num == (long)num) {
			return isPalindromic((long)num);
		}
		return false;
	}
	
	private static boolean isPalindromic(long inp) {
		inp = inp<0?-inp:inp;
		long tmp = 0,tmp2 = inp;
		while(inp > 0) {
			tmp = tmp*10+inp%10;
			inp /= 10;
		}
		return tmp==tmp2;
	}
}
