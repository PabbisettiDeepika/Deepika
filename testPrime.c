// To test isprime function

#include <stdio.h>
#include "prime.c"

#define INPUTS_COUNT 15
#define LENGTH 20

void testPrime()
{
	int isSuccessful = 1;
	char inputs[INPUTS_COUNT][LENGTH] = {"-7", "20", "a", "prime", "77len", "anh99", "-99", "0", "1", "25", "17", "6", " ", "----", "<"};
	int isPrimeStatus[INPUTS_COUNT];
	int counter;
	for (counter = 0; counter < INPUTS_COUNT; counter++)
	{
		isPrimeStatus[counter] = isPrime(inputs[counter]);
	}
	for (counter = 0; counter < INPUTS_COUNT; counter++)
	{
		if (isPrimeStatus[counter] == -1)
		{
			isSuccessful = 0;
			printf("Failed(%s)\n", inputs[counter]);
		} 
	}
	if (isSuccessful == 1)
	{
		printf("All tests are passed.\n");
	}
}

void main()
{
	testPrime();
}