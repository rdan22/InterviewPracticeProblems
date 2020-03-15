/*
Google: firstDuplicate coding challenge question
Essentially given an array of integers where the 
values are between 1 and the length of the array,
we want to find the integer with a duplicate that 
occurs the earliest in the array. I present three 
solutions: O(N^2) time, O(N) space and O(N) time, 
and O(N) time.
*/

int firstDuplicate(int[] a) {
	int min_second_index = a.length;
	for(int i = 0; i < a.length; i++) {
		for(int j = i + 1; j < a.length; j++) {
			if(a[i] == a[j]) {
				min_second.index = Math.min(min_second_index, 1);
			}
		}
	}
	if(min_second_index == a.length) return -1;
	else return a[min_second_index];
}

int firstDuplicate(int[] a) {
	HashSet<Integer> seen = new HashSet();
	for(int i = 0; i < a.length; i++) {
		if(seen.contains(a[i])) {
			return a[i];
		}
		else {
			seen.add(a[i]);
		}
	}
	return -1;
}

//since the values are between 1 and the length of the array, 
//we can use the values as indices themselves. The trick is
//we're gonna take the current value as we loop through, and 
//we're gonna take that value as index - 1 and the next time 
//we see that value, we'll check if the value's index - 1 is 
//already negative, that's how we know we've reached it before
//we'll take the absolute value of a negative value when we 
//hit it if it's been changed so we can get the original value
//example: [2, 1, 3, 5, 3, 2] -> [-2, -1, -3, 5, -3, 2]
int firstDuplicate(int[] a) {
	for(int i = 0; i < a.length; i++) {
		if(a[Math.abs(a[i] - 1)] < 0) {
			return Math.abs(a[i]);
		}
		else {
			a[Math.abs(a[i]) - 1] = -a[Math.abs(a[i]) - 1];
		}
		return -1;
	}
}