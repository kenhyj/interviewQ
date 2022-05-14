package AmazonQ1;

import java.util.*;

class Result {
    /*
     * Complete the 'sortBoxes' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY boxList as parameter.
     */
public static List <String> sortBoxes ( List <String> boxList) {
// Write your code here
    PriorityQueue<String>oldPQ=new PriorityQueue<>(boxList.size(), (a,b)->a.substring(a.indexOf(" ")).compareTo(b.substring(b.indexOf(" ")))==0?a.compareTo(b):a.substring(a.indexOf(" ")).compareTo(b.substring(b.indexOf(" "))) );
    Queue<String> newQ=new LinkedList<>();
    List<String>result=new ArrayList<>(boxList.size());
    Iterator<String>iter=boxList.iterator();
    while(iter.hasNext()){
        String entry=iter.next().trim();
    String[] entryHelp=entry.split("\\s+");
    if(entryHelp[1].trim().matches("[0-9]+")){
        newQ.offer(entry);
    } else {
    oldPQ.offer(entry);}
    // System.out.println(iter.next());
    }
    while(!oldPQ.isEmpty()){String old=oldPQ.poll();
    result.add(old);
    System.out.print(old);
    System.out.print(" + ");
    }
    while(!newQ.isEmpty()){
    String newS =newQ.remove();
    result.add(newS);
    System.out.print(newS);
    System.out.print(" + ");
    }
    return result;
    }
}