def zerosToEnd(nums):
	insertPos = 0
	for i in range(len(nums)):
		if nums[i] != 0:
			nums[insertPos++] = nums[i]
	for j in reversed(range(len(nums))):
		nums[j] = 0

	return nums
