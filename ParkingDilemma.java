/*
There are many cars parked in a parking lot. 
The parking lot is a straight line with a parking spot for every meter. 
There are n cars currently parked and a roofer wants to cover them with a roof. 
The requirement is that at least k cars are covered by the roof. 
Determine the minimum length of the roof that will cover k cars. 
https://leetcode.com/discuss/interview-question/402014/IBM-or-OA-2019-or-Parking-Dilemma
int car[n] the parking spots where all cars are parked, int k the number of cars that have
to be covered by the roof, return the minimum length of a roof that can cover the k cars.
*/

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
     * Complete the 'carParkingRoof' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. LONG_INTEGER_ARRAY cars
     *  2. INTEGER k
     */

    public static long carParkingRoof(List<Long> cars, int k) {
    // Write your code here
        if (cars.size() == 0 || k < 0) {
            return 0;
        }
        //sort the list 
        Collections.sort(cars);
        long minimumDistance = Long.MAX_VALUE;
        //walk through the list and update the min distance each time
        for (int i = 0; i <= cars.size() - k; i++) {
            minimumDistance = Math.min(minimumDistance, cars.get(i + k - 1) - cars.get(i));
        }

        return minimumDistance + 1;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int carsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Long> cars = IntStream.range(0, carsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Long::parseLong)
            .collect(toList());

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        long result = Result.carParkingRoof(cars, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}