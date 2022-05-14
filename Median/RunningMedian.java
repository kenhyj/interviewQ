package Median;
public class RunningMedian {
    
}

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
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Double> runningMedian(List<Integer> a) {
    // Write your code here
    // min Heap will keep track of all numbers greater than the current median
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    // max heap will keep track of all numbers less than the current median
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    
    // the array that keeps track of median changes over each iteration
    List<Double> double_array = new ArrayList<>();
        
    Iterator<Integer> iter = a.iterator();
    
    while (iter.hasNext()) {
        int v = iter.next();
        System.out.print(v + ", ");
        if (maxHeap.isEmpty() || maxHeap.peek() > v ) {
            maxHeap.offer(v);
        } else {
            minHeap.offer(v);
        }         
        if ( maxHeap.size() > minHeap.size() + 1 ) {
            minHeap.offer(maxHeap.poll()); // both heap size are equal now
        } else if ( maxHeap.size() + 1 < minHeap.size() ) {
            maxHeap.offer(minHeap.poll()); // both heap size are equal now
        }  
        if ( maxHeap.size() > minHeap.size()) {
            double median = maxHeap.peek(); // retrieve median
            double_array.add(median);
        } else if ( maxHeap.size() < minHeap.size()) {
            double median = minHeap.peek(); // retrieve median
            double_array.add(median);  
        } else {
            double median = (maxHeap.peek() + minHeap.peek() );
            median /= 2;
            double_array.add(median);
        }            
    }
    return double_array;
    }

}

// public class Solution {
//     public static void main(String[] args) throws IOException {
//         BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//         BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//         int aCount = Integer.parseInt(bufferedReader.readLine().trim());

//         List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
//             try {
//                 return bufferedReader.readLine().replaceAll("\\s+$", "");
//             } catch (IOException ex) {
//                 throw new RuntimeException(ex);
//             }
//         })
//             .map(String::trim)
//             .map(Integer::parseInt)
//             .collect(toList());

//         List<Double> result = Result.runningMedian(a);

//         bufferedWriter.write(
//             result.stream()
//                 .map(Object::toString)
//                 .collect(joining("\n"))
//             + "\n"
//         );

//         bufferedReader.close();
//         bufferedWriter.close();
//     }
// }
