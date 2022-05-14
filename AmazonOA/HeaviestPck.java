package AmazonOA;

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

// https://leetcode.com/discuss/interview-question/1747893/Amazon-OA-2022-or-SDE-1
public class HeaviestPck {
    public static int getHeaviestPackage(int[] pcks){
        Stack<Integer> stack = new Stack<>();
        
        int result = 0; 
        

        for(int w = 0 ; w<pcks.length; w++){
            stack.push(pcks[w]);
        }

        int sum = stack.pop();

        while(!stack.empty()){
            if (sum > stack.peek()){
                sum += stack.pop();
            } else {
                result = Math.max(result, sum);
                sum = stack.pop();
            }
        }
        result = Math.max(result, sum);

        return result;
    }

    public static void main(String[] args){
        int[] i0 = {2, 19, 3, 7};
        int o0 = 21;
        int[] i1 = {2, 3, 7, 19};
        int o1 = (2+3+7+19);
        int[] i2 = {19,7,3,2};
        int o2 = 19;

        int[][] inputs = {i0, i1, i2};
        int[] outputs = {o0, o1, o2 };
        
        for( int j = 0 ; j<inputs.length; j++){
            System.out.println("test case " + String.valueOf(j) + " " + String.valueOf( getHeaviestPackage(inputs[j]) == outputs[j] ));
        }
        
    }
}
