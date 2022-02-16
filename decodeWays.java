/* In this problem I wanted to utilize a dynamic programming approach with 
memoization. It utilizes an iterative approach as opposed to a recursive 
one so that the time complexity of the solution is O(N) and the space 
complexity is O(N) where N represents the length of the string. I first checked
edge cases such as if the string is null, and I also check to see if the character at 
the first position is 0. In both cases, I return 0. Then I initialize my dp array and
iterate over the length of the string. I obtain the value of the string at each 
position in the string as an int. Then I check if the value is less than 26 and the   
character previous is no 0 -> if so then I check if the character at the current 
position is 0 -> if it is, then depending on the position in the string I update the dp
array to be either 1 or the value in the previous pos. Otherwise I add both the value 
before it to the value in the previous position. Otherwise, if the character is not 0
I update the dp array with the value before it. If it is 0, we just return 0. By the end
of the iteration, the last position in our dp array will contain the number of possible
decodings. 
*/
class Solution {
    public int numDecodings(String s) {
        if(s==null || s.isEmpty()) {
            return 0;
        }
        if(s.charAt(0)=='0') {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for(int i=1;i<dp.length;i++) {
            int val = (((int)(s.charAt(i-1) - '0'))*10) 
                + (s.charAt(i) - '0');
            if(val<=26 && s.charAt(i-1)!='0') {
                if(s.charAt(i)-'0'==0) {
                    dp[i] = (i==1 ? 1:dp[i-2]);
                }
                else {
                    dp[i] = dp[i-1] + (i==1 ? 1:dp[i-2]); 
                }
            }
            else{
                if(s.charAt(i)-'0'!=0) {
                    dp[i] = dp[i-1]; 
                }
                else {
                    return 0;
                }
            }
        }  
        return dp[s.length()-1];
    }
}