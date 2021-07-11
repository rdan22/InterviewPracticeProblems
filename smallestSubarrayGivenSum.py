import sys

def smallestSubarrayGivenSum(A, targetSum):
	#far left value is changing
	#so we need another index that stays static 
	#and then increases as we want to shrink the left hand size
	windowStart = 0
	currentWindowSum = 0
	minWindowSize = sys.maxint
	for windowEnd in range(len(A)):
		currentWindowSum += A[windowEnd]
		#the second that we actually exceed the targetSum, we ask
		#can we do better? well this requires a while loop to shrink the LHS
		while(currentWindowSum >= targetSum):
			#record the best you're at so far
			#delta of how large our window is
			minWindowSize = min(minWindowSize, windowEnd - windowStart + 1)
			#since we remove the value on the far left of the array, 
			#we need to subtract it from our current window sum
			currentWindowSum -= A[windowStart]
			#now we need to increment window start to shrink the LHS
			windowStart += 1

	return minWindowSize

print(smallestSubarrayGivenSum([4, 2, 2, 7, 8, 1, 2, 8, 10], 8))