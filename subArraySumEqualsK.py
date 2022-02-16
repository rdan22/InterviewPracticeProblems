"""
Given an array of integers nums and an integer k, 
return the total number of continuous subarrays whose sum equals to k.

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2

Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
"""
def subarraySum(nums, k):

    #If cumulative sum i.e. sum[i] for the sum up to the ith index
    #Up to two indices is the same, the sum of the elements lying
    #between those indices must be 0. Therefore, if the cumulative
    #sum up to two indices, say i and j, is at a difference of k, 
    #the sum of the elements lying between indices i and j must be k.
    
    #We can make use of a hashMap which stores the cumulative sums up to
    #all indices possible along with the number of times the same sum
    #occurs. We store the data in the form sum_1, no._of_occurrences_of_sum_i.
    #We traverse over the array and keep on finding the cumulative sum.
    #Every time we encounter a new sum, we make a new entry in the hashMap
    #that corresponds to it. If it occurs again, we increment the count 
    #corresponding to that sum. For every sum encountered, we also determine
    #the number of times that sum - k has occurred already, since it will
    #determine the number of times a subarray with sum k has occurred up
    #to the current index. We increment count by the same amount. After complete
    #traversal, count gives the required result. 
    count = 0
    sum = 0
    hashMap = {}
    hashMap[0] = 1
    for i in range(len(nums)):
        sum += nums[i]
        if((sum - k) in hashMap):
            count += hashMap[sum - k]
        hashMap[sum] = hashMap.get(sum, 0) + 1
    
    return count
    
    #Time complexity: O(n) - only traverse nums once
    #Space complexity: O(n) - worst case hashMap contains n distinct entries

print(subarraySum([1, 1, 1], 2))
print(subarraySum([1, 2, 3], 3))