package AmazonOA;

// https://www.gohired.in/2014/08/19/connect-n-ropes-with-minimum-cost/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import javax.print.attribute.PrintRequestAttribute;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ConnectNRopes {

    public static long returnSum(int[] ropes){
        long result = 0; 

        // min heap
        PriorityQueue<Long> mheap= new PriorityQueue<>(ropes.length);
        for (int i = 0 ; i < ropes.length ; i ++){
            mheap.add( (long) ropes[i]);
        }
        // created heaps. 

        while(mheap.size() > 1){
            long firstNSecond = mheap.poll() + mheap.poll();
            result += firstNSecond;
            mheap.add(firstNSecond);
        }


        return ropes.length == 1 ? mheap.poll() : result;
    }
    public static void main(String args[]){
        int[] i0 = {4, 3, 2, 6};
        long o0 = 29;

        int[] i1 = {5};
        long o1 = 5;

        int[] i2 = {4, 5};
        long o2 = 9;

        int[][] inputs = {i0, i1, i2};
        long[] outputs = {o0, o1, o2};

        for (int i = 0 ; i<inputs.length; i++){
            long result = returnSum(inputs[i]);
            System.out.println ("Test case" + String.valueOf(i) + " " + String.valueOf(result == outputs[i]) );
        }

    }
}
