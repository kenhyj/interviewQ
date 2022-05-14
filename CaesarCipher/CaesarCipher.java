package CaesarCipher;



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

// https://www.hackerrank.com/challenges/one-week-preparation-kit-caesar-cipher-1
public class CaesarCipher {
    
}

class Result {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
    // Write your code here
    char[] charArray = s.toCharArray();
    char smA = "a".charAt(0);
    char smZ = "z".charAt(0);
    char capA = "A".charAt(0);
    char capZ = "Z".charAt(0);
    
    for (int j = 0 ; j<s.length(); j++){
        int ascii =  (charArray[j]+ (k % 26) );
        
        if ( smA <= charArray[j] && charArray[j] <= smZ ){
            charArray[j] = ascii > smZ ? (char) ( (ascii % smZ) + smA -1) : (char) (charArray[j]+ (k % 26) );
        } else if (capA <= charArray[j] && charArray[j] <= capZ) {
            charArray[j] = ascii > capZ ? (char) ( (ascii % capZ) + capA -1) : (char) (charArray[j]+ (k % 26) ); 
        }
        // charArray[j] = (char) (charArray[j]+ (k % 26) );    
        
    }
    
    String newString = new String(charArray);
    return newString;
    }
}

// public class Solution {
//     public static void main(String[] args) throws IOException {
//         BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//         BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//         int n = Integer.parseInt(bufferedReader.readLine().trim());

//         String s = bufferedReader.readLine();

//         int k = Integer.parseInt(bufferedReader.readLine().trim());

//         String result = Result.caesarCipher(s, k);

//         bufferedWriter.write(result);
//         bufferedWriter.newLine();

//         bufferedReader.close();
//         bufferedWriter.close();
//     }
// }
