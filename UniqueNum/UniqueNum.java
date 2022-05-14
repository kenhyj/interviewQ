package UniqueNum;

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


// https://www.hackerrank.com/challenges/one-week-preparation-kit-lonely-integer
public class UniqueNum {
    public static void main(String[] args){


        int[] test0 = {1, 2, 3, 4, 3, 2, 1};
        int[] test1 = {4, 3, 3, 2, 2, 1, 1};
        int[] test2 = {1, 3, 4, 2, 3, 1, 2};
        int[] test3 = {1, 1, 2, 2, 3, 3, 4};

        int[] outputs = {4, 4, 4, 4};
        int[][] tests = {test0, test1, test2, test3 };

        List<List<Integer>> foo = new ArrayList<>();
        for (int m = 0 ; m<tests.length ;m++){
            List<Integer> list = Arrays.stream(tests[m]).boxed().collect(Collectors.toList());
            foo.add(list);
        }

        Iterator<List<Integer>> fooIter= foo.iterator();
        int i = 0;
        while (fooIter.hasNext()){
            List<Integer> input = fooIter.next();
            System.out.println("test case" + String.valueOf(i) + ( Result.lonelyinteger(input) == outputs[i] ? " passed": " failed") );
            i ++;
        }
    }
    
}


class Result {

    /*
     * Complete the 'lonelyinteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */
    public static int usingSets(List<Integer> a){
        Set<Integer> seen = new HashSet<>();
        Set<Integer> dupes = new HashSet<>();
        Iterator<Integer> iter = a.iterator();
        while(iter.hasNext()){
            int entry = iter.next();
            if (seen.contains(entry)){
                dupes.add(entry);
            } else {
                seen.add(entry);
            }
        }
        seen.removeAll(dupes);
        Iterator<Integer> uniques = seen.iterator();
        int unique = -1;
        while (uniques.hasNext()){
            unique = uniques.next();
        }
        return unique;
    }

    public static int usingSums(List<Integer> a){
        Iterator<Integer> listIter = a.iterator();
        int listSum = 0;
        
        Set<Integer> iset = new HashSet<>(a.size()/2 +1);
        
        while(listIter.hasNext()){
            int entry = listIter.next();
            iset.add(entry);
            listSum += entry;
        }
        
        Iterator<Integer> setIter = iset.iterator();
        int setSum = 0;
        while(setIter.hasNext()){
            setSum += setIter.next();      
        }
        
        return 2*setSum - listSum;
    }


    public static int lonelyinteger(List<Integer> a) {
    // Write your code here
        // return usingSets(a);
        return usingSums(a);
    }


}

// public class Solution {
//     public static void main(String[] args) throws IOException {
//         BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//         BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//         int n = Integer.parseInt(bufferedReader.readLine().trim());

//         List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//             .map(Integer::parseInt)
//             .collect(toList());

//         int result = Result.lonelyinteger(a);

//         bufferedWriter.write(String.valueOf(result));
//         bufferedWriter.newLine();

//         bufferedReader.close();
//         bufferedWriter.close();
//     }
// }
