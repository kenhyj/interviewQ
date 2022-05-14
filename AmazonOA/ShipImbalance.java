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

// https://leetcode.com/discuss/interview-question/1815277/Amazon-OA-2022-shipment-Imbalance-Variant
// https://leetcode.com/problems/sum-of-subarray-ranges/

// try to do this in less than time O(n^2)
public class ShipImbalance {
    public static int getSegments(int[] pcks, int k){
        int result = 0;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        if (max - min <= k){
            result++; 
        }

        return result;
        // we know that the answer is n <= result <= n^2
    }

    public static void main(String args[]){
        int i0[] = {1, 3,6};
        int a0 = 5;

        int inputs[][] = {i0};
        int answers[] = {a0};
    }
}
