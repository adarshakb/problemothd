package javaPrg.mar;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
public class Solution {
    public static void main(String args[] ) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int C = Integer.parseInt(br.readLine());
    	List<String> answer = new ArrayList<String>();
    	
    	for(int i=0;i<C;i++) {
    		StringTokenizer tmpTokens = new StringTokenizer(br.readLine());
    		int n = Integer.parseInt(tmpTokens.nextToken());
    		int k = Integer.parseInt(tmpTokens.nextToken());
    		int q = Integer.parseInt(tmpTokens.nextToken());
    		
    		int[][] inpArray = new int[q][k];
    		int[] guessArray = null;
    		List<List<String>> impossibleNumbers = null;
    		for(int a=0;a<q;a++) {
    			tmpTokens = new StringTokenizer(br.readLine());
    			impossibleNumbers = new ArrayList<List<String>>();
    			
    			for(int b=0;b<k;b++) {
    				inpArray[a][b] = Integer.parseInt(tmpTokens.nextToken());
    				impossibleNumbers.add(new ArrayList<String>());
    			}
    			int bi = Integer.parseInt(tmpTokens.nextToken());
    			
    			if(bi==k) {
        			guessArray = new int[k];
    				guessArray = Arrays.copyOf(inpArray[a], inpArray[a].length);
    				break;
    			}
    			if(bi==0) {
    				for(int b=0;b<k;b++) {
        				impossibleNumbers.get(b).add(inpArray[a][b]+"");
        			}
    				continue;
    			}
    		}
    		boolean done = false;
    		if(guessArray != null) {
    			for(int[] tmp:inpArray) {
    				if(!Arrays.equals(guessArray, tmp)) {
    					answer.add("No");
    					done = true;
    					break;
    				}
    			}
    		}
    		
    		if(done)
    			continue;
    		
    		boolean ans = true;
    		for(int xx=0;xx<q;xx++) {
    			for(int yy=0;yy<k;yy++) {
    				if(impossibleNumbers.get(xx).contains(inpArray[xx][yy]+"")) {
    					ans = false;
    					break;
    				}
    			}
    		}
    		
    		if(ans) {
    			answer.add("Yes");
    		} else {
    			answer.add("No");
    		}
    	}
    	
    	for(String tmp: answer)
    		System.out.println(tmp);
    }
}
