package matrIx3d;

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

// https://www.hackerrank.com/challenges/cube-summation/problem?isFullScreen=true

class Cube {
    int[][][] matrix = {};

    public Cube(int n){
      for (int i = 1 ; i< n+1 ; i++){
          for (int j =1; j< n +1; j++) {
              for (int k =1 ; k< n+1 ; k++) {
                  Block b = new Block(0, i, j, k);
              }
          }
      }  
    } 
}

class Block {
    public int value;
    public int xCoord, yCoord, zCoord;
    public int xySum, zSum; 
    
    public Block(int item, int x, int y, int z){
        this.value = item;
        this.xCoord = x;
        this.yCoord = y;
        this.zCoord = z;
    }
}

class Result {

    /*
     * Complete the 'cubeSum' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY operations
     */

    public static List<Integer> cubeSum(int n, List<String> operations) {
    // Write your code here
        List<Integer> result = new ArrayList<>();
        return result;
    }

}

public class MatrIx3d {
    public static void main() {

        //test case 1

        //sample input 1
        // 2
        // 4 5
        // UPDATE 2 2 2 4
        // QUERY 1 1 1 3 3 3
        // UPDATE 1 1 1 23
        // QUERY 2 2 2 4 4 4
        // QUERY 1 1 1 3 3 3
        // 2 4
        // UPDATE 2 2 2 1
        // QUERY 1 1 1 1 1 1
        // QUERY 1 1 1 2 2 2
        // QUERY 2 2 2 2 2 2     

        // sample output 1
        
        // Returns - int[]: the results of each QUERY operation

    }
}
