/*
Facebook coding challenge question: You are given an
array of integers. Write a function that returns a 
sorted array containing the squares of those integers.
*/
//need to find a way around squaring separately and 
//sorting separately because otherwise time complexity
//will be too high --> this is an O(N) solution.
int[] sortedSquareArray(int[] array) {

	int[] result = new int[array.length];
	int left = 0;
	int right = array.length - 1;
	for(int i = array.length - 1; i >= 0; i--) {
		if(Math.abs(array[left]) > array[right]) {
			result[i] = array[left] * array[left];
			left++;
		}
		else {
			result[i] = array[right] * array[right];
		}
	}
	return result;
}