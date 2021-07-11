import sys

def maxSumSubarray(A, k):
	maxValue = -sys.maxint - 1
	currentRunningSum = 0

	for i in range(len(A)):
		#go ahead and add the current value to the running sum
		currentRunningSum += A[i]
		#is i >= k - 1 => why this? 
		#value of i says how far we are in the array
		#when we get to the point where we're at k - 1, we've reached
		#the end of the sliding window range, so we have the k elements
		if(i >= k - 1):
			#is the current running sum greater than the max value we have
			#update the max value
			maxValue = max(maxValue, currentRunningSum)
			#this is essentially subtracting from the left, while 
			#we increment our running sum from the right
			currentRunningSum -= A[i -(k - 1)]

	return maxValue

print(maxSumSubarray([4, 2, 1, 7, 8, 1, 2, 8, 1, 0], 3))
