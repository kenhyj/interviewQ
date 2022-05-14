package QueueStacks;

import java.io.*;
import java.util.*;
// https://www.hackerrank.com/challenges/one-week-preparation-kit-queue-using-two-stacks/

class Que {
    private Stack<Integer> inStack = new Stack<>();  // last is on top of stack
    private Stack<Integer> outStack = new Stack<>(); // first is on top of stack
    
    private void in2outQ(){
        while(!this.inStack.isEmpty()){
            this.outStack.add(this.inStack.pop());
        }
    }
    
    private void out2inQ(){
        while(!this.outStack.isEmpty()){
            this.inStack.add(this.outStack.pop());
        }
    }
    
    public void enque(int entry){
        this.out2inQ();
        this.inStack.add(entry);
    }
    public void deque(){
        this.in2outQ();
        this.outStack.pop();
    }
    
    public void printHead(){
        this.in2outQ();
        System.out.println(this.outStack.peek());
    }
}

public class QueueStacks { // change this to Solution for hackerrank submission

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        // this might help? https://www.hackerrank.com/challenges/java-stdin-and-stdout-1/problem


        Que que = new Que();
        
        Scanner scanner = new Scanner(System.in);
        // int queriesNum = scanner.nextInt(); // number of queries
        int queriesNum = Integer.valueOf(scanner.nextLine());
        
        for (int  m = 0 ; m < queriesNum ; m ++ ) {
            doCall(scanner.nextLine() , que);
        }        
        scanner.close();
    }
        
    public static void doCall(String line, Que q){
        String[] stdinStr = line.split("\\s+");
        int command = Integer.valueOf(stdinStr[0]);
        switch (command) {
            case 1:
                q.enque(Integer.valueOf(stdinStr[1]));
                break;
            case 2:
                q.deque();
                break;
            case 3: 
                q.printHead();
                break;
        }
    }        

}