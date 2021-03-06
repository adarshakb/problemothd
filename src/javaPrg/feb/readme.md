	King's Gold
===============
Many, many moons ago there was a fair king who oversaw 10 villages. As the king, he required a village tax of 1 gold bar per day per village. Each gold bar is supposed to weigh 1000g and have the village name etched in to it. However, the king has learned through an informant that one village has been cheating him the whole time and only giving him a bar that weighs 999g.

The king is furious and orders a scale to be brought in to test the weight of the gold bars. Assuming the king has access to all the gold bars ever sent to him, how can he figure out which village has been cheating him the whole time by using the scale only once?

Vigenère cipher
=================
The Vigenère cipher made its rounds in the mid-1550s up until the end of the American Civil War. It was very easy for soldiers to encode messages and pass them around to all the allied camps.

The cipher requires a key and a message. It works like this:

Key:
REDDIT
Message:
TODAYISMYBIRTHDAY
REDDITREDDITREDDI
TODAYISMYBIRTHDAY
--------------------------
KSGDGBJQBEQKKLGDG

Using a 0 based alphabet (A=0), R is the 17th letter of the alphabet and T is the 19th letter of the alphabet. (17 + 19) mod 26 = 11 which is where K resides in the alphabet. Repeat for each key/message letter combination until done.

Today's problem of the day is two part. The first part is to implement a Vigenère cipher in the programming language of your choice. Feel free to post solutions or links to solutions in the comments.

The second part is to try and implement something to crack the message below (the key is 5 or less characters).

ZEJFOKHTMSRMELCPODWHCGAW

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

King's Wine
=============
In celebration of our king finding the village that was cheating him he decides to throw a celebration for the other 9 villages. In preparation for the celebration he orders 1000 barrels of the finest wine.

When the members of the uninvited village find out about the party they send an assassin to poison one of the barrels of wine. The poison takes 7 days to kill so the party guests won't realize what is happening for awhile.

However, after poisoning a random barrel the king's guard finds out and has the assassin executed. There is no time to order more wine so the king devises a genius plan to have his 10 loyal servants taste test the wine to find the poisoned barrel just in time for the party in 10 days. What is the plan that he devises so that he is left with 999 barrels of wine for the party?

PalindromicNumbers.java
======================
Palindromic Numbers

A palindromic number is a number that reads the same forwards as it does backwards. 123321 is a palindromic number where as 321321 is not. Negative numbers may be considered palindromic or not; it's up to you until someone proves otherwise.

Your mission, should you choose to accept it, is to create a program to return whether a number is a palindromic number or not. To make things slightly more interesting you may not use a string or array in your solution. Thus doing something like "123.toString()" is not allowed.

Clock Hands
============
Write a program to find the minimum angle between two hands on a 24 hour clock. For instance, the angle at 6:00 is 90 degrees and the angle at 18:00 is also 90 degrees. At 6:17 the degree is 3.5 and at 18:17 it's 176.5 (hooray for supplementary angles).

For fun, program this one up in a language you've never used before. Here is a list of esoteric languages to help you decide. There are some truly interesting languages on that list. Feel free to use a "standard" language as well if there's one out there that you've been looking to learn.

ProductOfAnArray.java
=================

QUESTION: 

Given an array of integers, produce an array whose values are the product of every other integer

excluding the current index.

Example: 

[4, 3, 2, 8] -> [3*2*8, 4*2*8, 4*3*8, 4*3*2] -> [48, 64, 96, 24]

SudokuProb.java
===============
IMPORTANT DETAILS: 

A Sudoku puzzle consists of a 9x9 grid, where the objective is to fill the grid with the digits 1-9 

such that each digit appears only once in each: 

- Row 
- Column 
- 3x3 Sub-grid (Note: The sub-grids do not overlap) 

QUESTION: 

Write a method that checks whether a filled out grid is a valid solution. 

- You may use a matrix of ints to represent the grid. 
- You may assume that no values less than 1 or greater than 9 will appear in the grid.