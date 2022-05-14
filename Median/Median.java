package Median;

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

public class Median {
    public static void main (String args[]){
        double[] outputs = { 3, 3, 1.5, 5, 5, 5.5} ;
        int[][] inputsPrim = { {1, 2, 3, 4, 5}, {3, 2, 5, 1, 4}, {1, 2}, {1, 4, 6, 8}, {4, 1, 6 , 8}, {1, 4, 7, 10} };
        List<List<Integer>> inputs = new ArrayList<>();

        for (int m = 0 ; m<inputsPrim.length; m++){
            List<Integer> list = Arrays.stream(inputsPrim[m]).boxed().collect(Collectors.toList());
            inputs.add(list);
            //  List<Integer> to int[]
            // https://stackoverflow.com/questions/960431/how-to-convert-listinteger-to-int-in-java
            // int[] to List<Integer>
            // https://stackoverflow.com/questions/1073919/how-to-convert-int-into-listinteger-in-java
        }

        while()
}

class Result {
    
    
    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
  
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
  
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
  
    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
  
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);
  
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    /*
     * Complete the 'findMedian' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int findMedian(List<Integer> arr) {
    // Write your code here
    Iterator<Integer> iter= arr.iterator();
    int[] rray = {};


    PriorityQueue<Double> minHeap = new PriorityQueue<>();
    while (iter.hasNext()){
        double entry = iter.next();
        minHeap.offer(entry);
    }

    if (arr.size() % 2 == 0) {
        
    } else {
        double median = 0;
        for (int j = 0 ; j < (arr.size() /2) + 1; j++){
            median = minHeap.poll();
        }
        return median;
    }

}

// public class Solution {
//     public static void main(String[] args) throws IOException {
//         BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//         BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//         int n = Integer.parseInt(bufferedReader.readLine().trim());

//         List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//             .map(Integer::parseInt)
//             .collect(toList());

//         int result = Result.findMedian(arr);

//         bufferedWriter.write(String.valueOf(result));
//         bufferedWriter.newLine();

//         bufferedReader.close();
//         bufferedWriter.close();
//     }
// }
