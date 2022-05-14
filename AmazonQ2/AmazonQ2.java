package AmazonQ2;

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

public class AmazonQ2 {

    public static List<List<Integer>> omniSubsets = new ArrayList<>();

    public static List<Long> bestCombo(List<Integer> popularity, int k) {
        // List<Long> result = new ArrayList<>(k);
        // PriorityQueue<Long> comboMaxPQ = new PriorityQueue<>(k,
        // Comparator.reverseOrder()); // maxheap
        // while(!comboMaxPQ.isEmpty()){
        // result.add(comboMaxPQ.poll());
        // }

        List<Long> result = new ArrayList<Long>(k);
        PriorityQueue<Long> comboMinPQ = new PriorityQueue<>(k); // minheap

        List<List<Integer>> subsets = produceSubsets(popularity);

        sumFromAllSubsets(subsets, comboMinPQ, k);
        if (comboMinPQ.size() >= k && comboMinPQ.peek() < 0) {
            comboMinPQ.poll();
            comboMinPQ.add((long) 0); // for the empty set.
        } else {
            comboMinPQ.add((long) 0);
        }

        while (!comboMinPQ.isEmpty()) {
            result.add(comboMinPQ.poll());
        }
        Collections.reverse(result);

        return result;
    };

    public static List<List<Integer>> produceSubsets(List<Integer> popularity) {
        int n = popularity.size();
        for (int r = 1; r < n + 1; r++) {
            // combinationUtil(subsetsAll, popularity, n, r, 0, new
            getSubsetHelp(popularity, n, r, 0, new ArrayList<Integer>(Collections.nCopies(r, 0)), 0);
        }
        return omniSubsets;
    }

    public static void getSubsetHelp(List<Integer> arr, int n, int r, int index, List<Integer> data, int i) {
        // Current combination is ready to be printed,
        // print it
        if (index == r) {
            List<Integer> toInsert = new ArrayList<>();
            for (int j = 0; j < r; j++) {
                // System.out.print(data.get(j) + " ");
                toInsert.add(data.get(j));
            }
            // System.out.println("");
            omniSubsets.add(toInsert);
            return;
        }

        // When no more elements are there to put in data[]
        if (i >= n)
            return;

        // current is included, put next at next
        // location
        data.set(index, arr.get(i));
        getSubsetHelp(arr, n, r, index + 1, data, i + 1);

        // current is excluded, replace it with
        // next (Note that i+1 is passed, but
        // index is not changed)
        getSubsetHelp(arr, n, r, index, data, i + 1);
    }

    public static void sumFromAllSubsets(List<List<Integer>> subsets, PriorityQueue<Long> pq, int k) {
        Iterator<List<Integer>> iter = subsets.iterator();
        while (iter.hasNext()) {
            List<Integer> subset = iter.next();
            long summed = sumFromSubset(subset);
            if (pq.size() >= k) {
                long top = pq.peek();
                if (top < summed) {
                    pq.poll();
                    pq.offer(summed);
                }
            } else {
                pq.offer(summed);
            }
        }
    }

    public static long sumFromSubset(List<Integer> subset) {
        Iterator<Integer> iter = subset.iterator();
        long sum = 0;
        while (iter.hasNext()) {
            sum += (long) iter.next();
        }
        return sum;
    }

    public static void main(String[] args) {
        // int[] t1 = { 3, 5, -2 };
        // 8 5 3 3 1 0 -2;
        int[] t1 = {-8, -5, -3, -3, -1, 0, 2}; // 2 2 1 1 0 0 -1 -1 
        

        List<Integer> list = Arrays.stream(t1).boxed().collect(Collectors.toList());

        // List<List<Integer>> allsubs = produceSubsets(list);

        // Iterator<List<Integer>> outerIt = allsubs.iterator();
        // while (outerIt.hasNext()) {
        // List<Integer> inner = outerIt.next();
        // Iterator<Integer> innerIt = inner.iterator();
        // while (innerIt.hasNext()) {
        // System.out.print(innerIt.next());
        // System.out.print(" ");
        // }
        // System.out.println("");
        // }

        List<Long> theSums = bestCombo(list, 8);
        Iterator<Long> iIter = theSums.iterator();
        System.out.print("{ ");
        while (iIter.hasNext()) {
            System.out.print(iIter.next());
            System.out.print(", ");
        }
        System.out.print("}");
    }
}