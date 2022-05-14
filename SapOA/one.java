package SapOA;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;


public class one {
    // https://leetcode.com/discuss/interview-question/339640/sap-online-assessment-minimum-sum
    public static int solution(int[] array, int k){
        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);  // maxheap

        for (int i = 0 ; i<array.length ; i++){
            pq.offer(array[i]);
        }

        for (int j = 0 ; j<k ; j++){
            double next = (double) pq.poll();
            pq.offer( (int) Math.ceil(next/2) );
        }
    
        while(!pq.isEmpty()){
            result += pq.poll();
            // System.out.println(result);
        }
        return result;
    }

    public static void main (String[] args){
        int input0[] = {10, 20, 7};
        int k0 = 4;
        int output0  = 14;

        // System.out.println(solution(input0, k0));
        System.out.println(solution(input0, k0)  == output0);

    }   
}

class two {
    // https://leetcode.com/problems/monotone-increasing-digits/
    // https://leetcode.com/discuss/interview-question/828566/sap-new-grad-2021-online-assessment-usa
    private static boolean checkIncreasing(int input){
        int digits = String.valueOf(input).length();
        Stack<Integer> stack = new Stack<>();
        
        int inputRevised = input;

        for (int i = 0 ; i < digits; i++){
            stack.push(inputRevised % 10);
            inputRevised /= 10;
        }

        int top = stack.pop();

        while(!stack.empty()){
            // if(top >= stack.peek()){
            if(top > stack.peek()){
                return false;
            } 
            top = stack.pop();
        }

        return true;
    }


    private static int new_concatDigit(int sofar, int compare, int nextDigit, int digits){

        int tmp = Integer.parseInt( String.valueOf(sofar).concat(String.valueOf(nextDigit))); 
        int compareFirstX = Integer.parseInt( String.valueOf(compare).substring(0, digits) ); // this will always be at least tmp.

        if (checkIncreasing(tmp)) {
            return tmp;
        } 
        // it's not increasing... 
        // scenario 1 i don't need to change what i've built up so far.
        // eg. 322
        // 3,2 -> 29,2 -> 299
        else if ( sofar*10 +9  <= compareFirstX) {
            // System.out.println(compareFirstX);
            // System.out.println("first if + ");
            return sofar*10 +9;
        }
        
        // i need to change what i've built up so far

        // scenario 3: tmp = 53, then try new_concat(4, 9). tmp= 49
        // tmp = 5553, then try new_concat(499, 9). tmp = 49

        int modu = 1;

        while(!checkIncreasing ((int) ( Math.floor(sofar*10/modu)*modu -1)))  {
            modu *= 10;
        }
        // tmp = (int) ( Math.round(sofar/modu)*modu -1) *10 +9;
        tmp = (int) ( Math.floor(sofar*10/modu)*modu -1);
        // System.out.println(tmp);
        return tmp;
    }

    public static int solution_1(int input){
        if (checkIncreasing(input)){
            return input;
        }
        
        int digits = String.valueOf(input).length();
        Stack<Integer> stack = new Stack<>();

        int tmp = input;

        for (int i = 0 ; i < digits; i++){
            stack.push(tmp % 10);
            tmp /= 10;
        }

        int result = stack.pop();
        int j = 2;

        while(!stack.empty() ){
            result = new_concatDigit(result, input, stack.pop(), j++ );
        }

        return result;
        // it's too slow
    }

    public static int solution(int input){
        int digits = String.valueOf(input).length();
        Stack<Integer> stack = new Stack<>();
        
        int tmp = input;

        for (int i = 0 ; i < digits; i++){
            stack.push(tmp % 10);
            tmp /= 10;
        }

        
        int top = stack.pop();
        int result = top;
        int j = digits;
        int repeats = 0;
        int repeater = top;
        boolean emptied = true;

        while(!stack.empty() ){
            if(top > stack.peek()){
                emptied = false;
                result = repeats == 0 ? result -1 : result;
                break;
            } 

            j--;
            result *= 10;
            top = stack.pop();
            result += top;

            repeats = repeater == top ? repeats + 1: 0;
            repeater = top;
        }
        if (emptied){
            return input;
        }
        System.out.println(result);
        for(int r = 0 ; r<repeats ; r++){
            result /= 10;
            result--;
        }
        // result--;
        for(int i = 0 ; i<j-1 + repeats; i++){
            result *=10;
            result +=9;
        }

        return result;
        //a little better but not that much.
    }

    public static void main(String[] args){
        int[] test0 = {573, 569};
        int[] test1 = {1234, 1234};
        int[] test2 = {999, 999};
        int[] test3 = {9, 9};
        int[] test4 = {322, 299};
        int[] test5 = {8888, 8888};
        int[] test6 = {100, 99};
        int[] test7 = {5554, 4999};
        int[] test8 = {10, 9};
        int[] test9 = {399443, 389999};
        int[] test10 = {677440, 669999};
        int[] test11 = {999999998, 899999999};


        int[][] tests = {test0, test1, test2, test3, test4, test5, test6, test7, test8, test9, test10, test11};
        // int[][] tests = {test11};

        for(int i = 0 ; i<tests.length; i++){
            int input = tests[i][0];
            int output = solution(tests[i][0]); 
            int answer = tests[i][1];
            boolean detailed = false;

            if (detailed){
                System.out.print("Test case" + String.valueOf(i) + ": ");
                System.out.print( ( output == answer ) ? "passed: " : "FAILED: " );
                System.out.print( String.valueOf(input) + " -> " + String.valueOf( output ) );
                System.out.print( (input == output ) ? " = ": " =/= " );
                System.out.println(String.valueOf(answer));
            } else {
                System.out.print("Test case" + String.valueOf(i) + ": ");
                System.out.println( ( output == answer ) ? "passed " : "FAILED: " + String.valueOf(input) + " -> " + String.valueOf( output ) + " =/= " + String.valueOf(answer));
            }


        }
        

    }
}

class three {
    // https://leetcode.com/discuss/interview-question/1442801/SAP-or-interview-question
    public static int[] solution(int[] arr1, int[] arr2){

        Queue<Integer> que = new LinkedList<>();

        Map<Integer, Integer> freqMap = new HashMap<>();

        int key, value;
        for(int i = 0; i<arr1.length; i++ ){
            key = arr1[i];
            if(!freqMap.containsKey(key)){
                freqMap.put(key, 0);
                que.offer(key);
            }
            value = freqMap.get(key);
            freqMap.replace(key, value + 1);      
        }
        for (int j = 0 ; j<arr2.length; j++){
            key = arr2[j];
            if(!freqMap.containsKey(key)){
                freqMap.put(key, 0);
                que.offer(key);
            }
            value = freqMap.get(key);
            freqMap.replace(key, value + 1);
        }

        List<Integer> result = new ArrayList<>();
        // int[] foo = new int[que.size()];
        // int[] foo = {};
        // int index = 0;

        while(!que.isEmpty()){
            key = que.poll();
            value = freqMap.get(key);
            for(int t = 0 ; t<value ; t++){
                result.add(key);
                // foo[index] = key;
                // index ++;
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
        // return foo;
    }

    public static void main(String[] args){
        int[][] input0 = { {1, 5,10, 5, 15, 4}, {4, 6, 35, 8, 2, 19, 2, 5, 0, 15} };
        int[] answer0 = {1, 5, 5, 5, 10, 15, 15, 4, 4, 6, 35, 8, 2, 2, 19, 0 };

        int[] output = solution(input0[0], input0[1]);

        System.out.println(Arrays.equals(output, answer0));
        // for(int i = 0 ; i<output.length; i++){
        //     System.out.print(String.valueOf(output[i]) + " ");
        // }
        // System.out.println("");
    }
}

class four {
    // https://leetcode.com/discuss/interview-question/421553/interview-question-sap
    // https://leetcode.com/problems/create-target-array-in-the-given-order/
    public int[] solution(int[] nums, int[] index) {
        List<Integer> target= new ArrayList<>();
        for (int j = 0 ; j<nums.length ; j++){
            target.add(index[j], nums[j]);
        }
        return target.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args){

    }
}

class five {

}

