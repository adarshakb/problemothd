MatrixRotation.java
===============
The bank manager at my local bank recently gave me the algorithm to access the bank's vault. I thought I'd pass on the algorithm to you all for "safe keeping". Basically the vault has a USB port which you'll need to plug in to. Once plugged in the vault will send you an NxN matrix such as the one below.

Monday-Friday the key to the vault is to rotate the matrix 90 degrees clockwise. On Saturday and Sunday you have to rotate the matrix 90 degrees counter-clockwise. My dog accidentally got locked in the vault and the bank manager is no where to be found. Can someone help me write a program to get him out?

	matrix={{1,2,3,4,5},
	        {6,7,8,9,10},
	        {11,12,13,14,15},
	        {16,17,18,19,20},
	        {21,22,23,24,25}}

	#Rotated 90 degrees clocfkwise
	matrix={{21, 16, 11, 6, 1}, 
	        {22, 17, 12, 7, 2},
	        {23, 18, 13, 8, 3},
	        {24, 19, 14, 9, 4},
	        {25, 20, 15, 10, 5}}
	Bonus points for fewer characters of code.

PalindromicNumbers.java
======================
Palindromic Numbers

A palindromic number is a number that reads the same forwards as it does backwards. 123321 is a palindromic number where as 321321 is not. Negative numbers may be considered palindromic or not; it's up to you until someone proves otherwise.

Your mission, should you choose to accept it, is to create a program to return whether a number is a palindromic number or not. To make things slightly more interesting you may not use a string or array in your solution. Thus doing something like "123.toString()" is not allowed.