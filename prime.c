// To check whether the given number is prime or not

#include <stdio.h>
#include <math.h>
#include <string.h>

int getdigitsCount(int number)
{
	int digitsCount = 0;
	digitsCount = (number == 0)? 1: log10(number) + 1;
	return digitsCount;
}

int isPrime(char userInput[])
{
	int number = atoi(userInput);
	int isNumberPrime = -1;
	int squareRoot;
	if (number == 0 && userInput[0] != '0')
	{
		isNumberPrime = 0;
	}
	else
	{
		if (getdigitsCount(number) != strlen(userInput))
		{
			isNumberPrime = 0;
		}
		else
		{
			if (number == 0 || number == 1)
			{
				isNumberPrime = 0;
			}
			else if (number == 2 || number == 3)
			{
				isNumberPrime = 1;
			}
			else if (number % 2 == 0)
			{
				isNumberPrime = 0;
			}
			else
			{
				isNumberPrime = 1;
				squareRoot = sqrt(number);
				int counter;
				for (counter = 3; counter <= squareRoot; counter = counter + 2)	
				{
					if (number % counter == 0)
					{
						isNumberPrime = 0;
						break;
					}
				}

			}
		}
	}
	return isNumberPrime;
}