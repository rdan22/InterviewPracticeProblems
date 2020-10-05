import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'variantsCount' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER s0
     *  3. INTEGER k
     *  4. INTEGER b
     *  5. INTEGER m
     *  6. LONG_INTEGER a
     */

    public static long variantsCount(int n, int s0, int k, int b, int m, long a) {
    // Write your code here
        long result = 0;
        int[] s = new int[n];
        int[] prodArr = new int[n*n];
        s[0] = s0;
        for(int i = 1; i < n; i++) {
            s[i] = 1 + s[i-1] + (k * s[i - 1] + b) % m;
        }
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int product = s[i] * s[j];
                if(product <= a) {
                    result++;
                }
            }
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int s0 = Integer.parseInt(bufferedReader.readLine().trim());

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        long a = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.variantsCount(n, s0, k, b, m, a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
