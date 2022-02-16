"""
You are given N numbers on a circle, described by an array A. 
Find the maximum number of neighbouring pairs whose sums are even. 
One element can belong to only one pair. Write a function that, 
given an array A consisting of N integers, returns the maximum number 
of neighbouring pairs whose sums are even.

Examples:
1. Given A = [4, 2, 5, 8, 7, 3, 7], the function should return 2. 
We can create two pairs with even sums: (A[0], A[1]) and (A[4], A[5]).
Another way to choose two pairs is: (A[0], A[1]) and (A[5], A[6]).
2.  Given A = [14, 21, 16, 35, 22], the function should return 1. 
There is only one qualifying pair: (A[0], A[4]).
3. Given A = [5, 5, 5, 5, 5, 5], the function should return 3. 
We can create three pairs: (A[0], A[5]), (A[1], A[2]) and (A[3]), A[4]).
"""
def solution(A):
	
	even = all(A[i] % 2 == 0 for i in range(len(A)))
	odd = all(A[i] % 2 == 1 for i in range(len(A)))

	if(even or odd):
		if(len(A) % 2 == 0): 
			return len(A) / 2
		else:
			return (len(A) - 1) / 2

	length = len(A)
	count = 0
	i = 0

	while(i < length - 1):
		if((A[i] + A[i+1]) % 2 == 0):
			count += 1
			i = i + 2 
		else:
			i = i + 1
	#A[0] is not included yet and sum of first and last term is even
	if((A[length - 1] + A[0]) % 2 == 0 and (A[0] + A[1]) % 2 == 1):
		count += 1

	return count

print(solution([4, 2, 5, 8, 7, 3, 7]))
print(solution([14, 21, 16, 35, 22]))
print(solution([5, 5, 5, 5, 5, 5]))
