package SwpNodes;

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

// compile
/**
 * cd SwpNodes
 * javac SwpNodes.java
 * you must run this every time you make changes and want to run it
 */

// run
/**
 * make sure directory is at top of SwpNodes, not on SwpNodes
 * java SwpNodes.SwpNodes
 */

class Node {
    public int data;
    public Node left, right;
    public int depth;

    public Node(int item) {
        data = item;
        this.left = this.right = null;
    }

    public Node(int item, int d) {
        this.data = item;
        this.left = this.right = null;
        this.depth = d;
    }
}

class BinaryTree {
    public Node root;
    private List<Node> array;

    public BinaryTree() {
        this.root = new Node(1, 1); // for this question it assumes the tree has minimal a root.
        // the question assumes that the max number of nodes is 1024
    }

    public BinaryTree(List<List<Integer>> indexes) {
        this.root = new Node(1, 1);

        Queue<Node> que = new LinkedList<>();
        que.offer(this.root);

        Iterator<List<Integer>> outerIt = indexes.iterator();
        while (outerIt.hasNext()) {
            Node nn = que.remove();
            Iterator<Integer> innerIt = outerIt.next().iterator();
            for (int i = 0; i < 2; i++) {
                int nodeval = innerIt.next();
                if (i < 1 && nodeval > 0) {
                    nn.left = new Node(nodeval, nn.depth + 1);
                    que.offer(nn.left);
                } else if (i > 0 && nodeval > 0) {
                    nn.right = new Node(nodeval, nn.depth + 1);
                    que.offer(nn.right);
                }
            }
        }
    }

    public List<Integer> traverseInOrder() {
        this.array = new ArrayList<>();
        inordertraversal(this.root);
        List<Integer> ff = new ArrayList<>();
        this.array.forEach(node -> ff.add(node.data));
        // return this.array;
        return ff;
    }

    private void inordertraversal(Node node) {
        if (node.left != null) {
            inordertraversal(node.left);
        }
        this.array.add(node);
        if (node.right != null) {
            inordertraversal(node.right);
        }
    }

    public void swap(int level) {
        swapHelp(level, this.root);
    }

    private void swapHelp(int level, Node node){
        if (node.depth % level ==0) {
            Node holdNode = node.left;
            node.left = node.right;
            node.right = holdNode;
        } 
        if (node.left != null){
            swapHelp(level, node.left);
        }
        if (node.right != null) {
            swapHelp(level, node.right);
        }
    }

}

class Result {

    // indexes has a max size of 1024 and min size of 1
    // queries has a max size of 100 and min size of 1. each entry in queries k is
    // 1<=k<= index.size()
    public static void swapNodesPrintParam(List<List<Integer>> indexes, List<Integer> queries) {
        Iterator<List<Integer>> outerIter = indexes.iterator();
        while (outerIter.hasNext()) {
            Iterator<Integer> innerIter = outerIter.next().iterator();
            while (innerIter.hasNext()) {
                System.out.print(innerIter.next() + " ");
            }
            System.out.println();
        }
        System.out.print("\n\n");
        Iterator<Integer> qIter = queries.iterator();
        while (qIter.hasNext()) {
            System.out.print(qIter.next() + " ");
        }
    }

    /*
     * Complete the 'swapNodes' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts following parameters:
     * 1. 2D_INTEGER_ARRAY indexes
     * 2. INTEGER_ARRAY queries
     */
    public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
        // Write your code here

        // this is the value I will return at the end.
        List<List<Integer>> finale = new ArrayList<>();

        // create Binary tree
        BinaryTree btree = new BinaryTree(indexes); 

        // start looking into swapping
        Iterator<Integer> qIterator = queries.iterator();
        while(qIterator.hasNext()){
            // do a swap of k.
            btree.swap(qIterator.next()); 
            // record the in order traversal of the binary tree
            List<Integer> row = btree.traverseInOrder();
            // add it to the final result 2d matrix.
            finale.add(row);
        }   
        return finale;
    }
}

// https://www.hackerrank.com/challenges/swap-nodes-algo/problem
public class SwpNodes {
    public static void main(String[] args) {

        int ind = 3; // change this for selecting test case.
        ind--;
        // first test case ind =1
        int[][] i1 = { { 2, 3 }, { -1, -1 }, { -1, -1 } };
        int[] q1 = { 1, 1 };
        // second test case ind =2
        int[][] i2 = { { 2, 3 }, { -1, 4 }, { -1, 5 }, { -1, -1 }, { -1, -1 } };
        int[] q2 = { 2 };
        // third test case ind =3
        int[][] i3 = { { 2, 3 }, { 4, -1 }, { 5, -1 }, { 6, -1 }, { 7, 8 }, { -1, 9 }, { -1, -1 }, { 10, 11 },
                { -1, -1 }, { -1, -1 }, { -1, -1 } };

        int[] q3 = { 2, 4 };

        int[][][] i = { i1, i2, i3 };
        int[][] q = { q1, q2, q3 };

        List<List<Integer>> indexes = new ArrayList<>();

        for (int j = 0; j < i[ind].length; j++) {
            List<Integer> innerInd = new ArrayList<>(2);
            innerInd.add(i[ind][j][0]);
            innerInd.add(i[ind][j][1]);
            indexes.add(innerInd);
        }

        List<Integer> queries = new ArrayList<>();
        for (int k=0; k<q[ind].length ; k++){
            queries.add(q[ind][k]);
        }
        

        List<List<Integer>> result = Result.swapNodes(indexes, queries);

        // Result.swapNodesPrintParam(indexes, queries);
        // print result
        Iterator<List<Integer>> outIter = result.iterator();
        while (outIter.hasNext()) {
            Iterator<Integer> inIter = outIter.next().iterator();
            while (inIter.hasNext()) {
                System.out.print(" " + inIter.next());
            }
            System.out.println();
        }
    }
}