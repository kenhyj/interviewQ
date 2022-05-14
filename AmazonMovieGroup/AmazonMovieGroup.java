package AmazonMovieGroup;

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

// https://leetcode.com/discuss/interview-question/1791255/Amazon-or-SDE1(2022-grad)-or-OA-Questions

public class AmazonMovieGroup {

    public static int[][] groupMovies( int[] movies, int k ){
        PriorityQueue<Integer> pq = new PriorityQueue<>(movies.length);
        for (int i = 0 ; i <movies.length; i++){
            pq.offer(movies[i]);
        }
        // movies ranks sorted

        List<List<Integer>> data = new ArrayList<>();
        
        int mini = pq.poll(); // first one.
        List<Integer> group = new ArrayList<>();
        group.add(mini);

        while(!pq.isEmpty()){
            if (mini + k >= pq.peek()){
                group.add(pq.poll());
            } else {
                data.add(group);
                mini = pq.poll();
                group = new ArrayList<>();
                group.add(mini);
            }
        }
        // the final group never gets included into the data
        // let's add it
        data.add(group);


        // int[] ints = {1,2,3};
        // List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());

        Iterator<List<Integer>> oIter = data.iterator();

        int[][] result = new int[data.size()][];

        for (int s = 0 ; s<data.size() ; s++) {
            List<Integer> list = data.get(s);
            int[] igroup = list.stream().mapToInt(Integer::intValue).toArray();
            result[s] = igroup;
        }

        return result;

    }

    public static void main(String[] args){
        int[] m0 = {1, 5, 4, 6, 8 , 9 , 2};
        int k0 = 3;
        int[] m1 = {1, 13, 6, 8, 9, 3, 5};
        int k1 = 4;
        
        int[][] input = groupMovies(m1, k1);

        System.out.print("Number of Groups:");
        System.out.println(input.length);
        for(int i = 0 ; i < input.length; i++){
            for (int j  = 0 ; j < input[i].length ; j++) {
                System.out.print( input[i][j] );
                System.out.print(" ");
            }
            System.out.println("");
        }

    }
    
}
