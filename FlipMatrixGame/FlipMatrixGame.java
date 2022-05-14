package FlipMatrixGame;

public class FlipMatrixGame {
    
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

// Flipping the Matrix
// https://www.hackerrank.com/challenges/flipping-the-matrix/problem?h_r=internal-search

class Result {

    /*
     * Complete the 'flippingMatrix' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int flippingMatrix(List<List<Integer>> matrix) {
    // Write your code here
        List<List<Integer> flip = new ArrayList<>();
        Iterator<List<Integer>> outerIter = matrix.iterator();
        
        int maxi = 0;        
        return maxi;
    }
    public static int 

}

// public class Solution {
//     public static void main(String[] args) throws IOException {
//         BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//         BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//         int q = Integer.parseInt(bufferedReader.readLine().trim());

//         IntStream.range(0, q).forEach(qItr -> {
//             try {
//                 int n = Integer.parseInt(bufferedReader.readLine().trim());

//                 List<List<Integer>> matrix = new ArrayList<>();

//                 IntStream.range(0, 2 * n).forEach(i -> {
//                     try {
//                         matrix.add(
//                             Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                                 .map(Integer::parseInt)
//                                 .collect(toList())
//                         );
//                     } catch (IOException ex) {
//                         throw new RuntimeException(ex);
//                     }
//                 });

//                 int result = Result.flippingMatrix(matrix);

//                 bufferedWriter.write(String.valueOf(result));
//                 bufferedWriter.newLine();
//             } catch (IOException ex) {
//                 throw new RuntimeException(ex);
//             }
//         });

//         bufferedReader.close();
//         bufferedWriter.close();
//     }
// }
