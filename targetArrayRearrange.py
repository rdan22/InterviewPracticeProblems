"""
Solution 2:
The idea is to create two pointers i, j, and initialize them to 0 and 1. We are going to create two passes, 
in the first pass we will put the values that are smaller than the target will be on the left side and in 
the next pass put the values that are greater than x on the right side of the array. In the first pass, we 
check if the value is smaller than the target if it’s smaller then we just increase the value of i by 1. If 
the first condition failed, then we will check if the value at the jth index is smaller than the target, if 
it is smaller than the target then we are going to swap values at the ith and jth index and increase the i 
by one. Every time, we are going to increase the value of j by 1. If the value of j becomes equal to the length 
of the array, then we will break out of the loop. We will decrease the value of j by 1, so it can become equal 
to the length of the array. We will do the same for values that are greater than the target, but conditions 
will be reversed, and the loop only runs until i will be less than j.
"""

def solution1(nums, target):
    i, j = 0, len(nums) - 1
    output = [target] * len(nums)

    for k in range(len(nums)):
        if nums[k] < target:
            output[i] = nums[k]
            i += 1
        elif nums[k] > target:
            output[j] = nums[k]
            j -= 1

    return output

def solution2(nums, target):
    i, j = 0, 1

    while j < len(nums):
        if nums[i] < target:
            i += 1
        elif nums[j] < target:
            nums[i], nums[j] = nums[j], nums[i]
            i += 1
        j += 1

    j -= 1

    while i < j:
        if nums[j] > target:
            j -= 1
        elif nums[i] > target:
            nums[i], nums[j] = nums[j], nums[i]
            j -= 1
        i += 1

    return nums

print(solution1([9, 12, 5, 10, 14, 3, 10], 10))
print(solution1([-3, 4, 3, 2], 2))
print(solution2([9, 12, 5, 10, 14, 3, 10], 10))
print(solution2([-3, 4, 3, 2], 2))