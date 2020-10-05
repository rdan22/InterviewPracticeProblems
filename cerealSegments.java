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
     * Complete the 'segment' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER x
     *  2. INTEGER_ARRAY arr
     */

    public static int segment(int x, List<Integer> arr) {
    // Write your code here
        int[] array = arr.toArray();
        int[] min = new int[x];
        int minVal = 0;
        List<List<Integer>> subArray = new ArrayList<ArrayList<>>();
        List<Integer> innerCon = new ArrayList<Integer>();
        for(int i = 0; i < array.length - x + 1; i++) {
            for(int j = 0; j < x; j++) {
                innerCon.add(arr[j]);
            }
            subArray.add(innerCon);
        }
        for(List l : subArray)
            for(int i = 0; i < x; i++) {
            }
        }
    }

}
