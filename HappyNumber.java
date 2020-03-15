class Solution {
	public boolean isHappy(int n) {

		HashSet<Integer> set = new HashSet<>();
		while (squareSum(n) != 1) {
			n = squareSum(n);
			if (!set.add(n)) {
				return false;
			}
		}
		return true;
	}

	public int squareSum(int n) {
		int sum = 0;
		while (n > 0) {
			sum += (n % 10) * (n % 10);
			n /= 10;
		}
		return sum;
	}
}