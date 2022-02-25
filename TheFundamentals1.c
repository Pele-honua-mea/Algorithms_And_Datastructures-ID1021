/**
@author: Pele Honua Mea
@date: 2022-02-24
@brief:
    ¤ functions: two different approaches for the same output. The functions, iterative and recursive, read characters
    from stdin until a newline character is read and then print them on stdout in reverse order.
        ¤ function iterative: gets characters from the user's input one by one and stores them in an array called str.
        To have the content of the array printed in reversed order, we need to start printing the characters from the last
        element of the array to the first one.
        ¤ function recursive: gets one character from the user's input at a time and if the newline has not been reached yet
        (base condition not met), it puts the character on a "stack" when the function calls itself (until the condition is
        met -> loop broken). It does that with all input characters and at the end the last added character will be
        the first one to go from the "stack".

@expectedOutput:
Depends on the user's input.

@question 1: Is it easier to implement this function recursively or iteratively?
Depends on the programmer. For me the iterative function is more intuitive, hence easier to implement. However, if we take into
account the amount of required steps, the recursive function seems much "easier" to implement than the iterative one.

@question 2: Are there other pros/cons of the two approaches?
Recursion:
+ can reduce time complexity to O(N) by using memoization technique (uses more memory, but makes it faster),
+ good for small inputs (only!) --> fast to write & debug, easy to look at (not as cluttered as iterative function),
+ efficient way to traverse tree traversals (recursive calls till the wanted value is found)

- requires more memory, since the function adds to the stack with each recursive call and needs to keep the values until the
base condition is satisfied.
- slow if not implemented correctly (overhead due to repeated function calls --> time complexity becomes very high,
even exponential),
- if the base condition is specified incorrectly (never becomes false) it creates an infinite loop that may lead to system CPU
crash.

Iteration:
+ good for larger inputs and the time complexity is usually significantly lesser than that of recursion --> time complexity
(usually polynomial-logarithmic) is balanced against an expanded code size.
+/- a mistake causing an infinite loop would stop program execution, but would not cause system errors like recursion.
- involves larger size of code.

Conclusion:
Even though recursion is less cluttered and is 'nicer-looking' than iteration, it may cause may way too many problems, as it's
not efficient for larger inputs.

**/

#include <stdio.h>

void iterative(void);
void recursive(void);

int main(void){


	printf("Enter your string: ");
	fflush(stdout);
	iterative(); //calls iterative function
	printf("\n");

	printf("Enter your string: ");
	fflush(stdout);
	recursive(); //calls recursive function
	return 0;
}


void iterative(void){
	char str[100]; //initialization of an array holding 100 characters
	int n = 0;
	int i = 0;
	while(1){
		str[n] = getchar(); //input char
		if(str[n] != '\n'){
			n++;
		}
		else{
			break; //when it reaches newline it breaks
		}
	}
	//the last input is a newline so we want to ignore it
	for(i = n-1; i >= 0; i--){
		putchar(str[i]);
	}

}

void recursive(void){
	char c;
	c = getchar();
	if(c != '\n')
		recursive();
	putchar(c);
}
