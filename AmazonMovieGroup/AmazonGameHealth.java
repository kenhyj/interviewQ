package AmazonMovieGroup;

// https://leetcode.com/discuss/interview-question/1791255/Amazon-or-SDE1(2022-grad)-or-OA-Questions

public class AmazonGameHealth {
    public static Long getMinHealth(int[] power, int armor){
        long sum = 0;
        int biggest = 0; 

        for (int i = 0 ; i < power.length; i++){
            int entry = power[i];
            biggest = Math.max(biggest, entry);
            sum += (long) entry;
        }

        return 1 + ( sum - (long) biggest ) + (long) (biggest - armor > 0 ? biggest - armor : 0);
    }
    
    public static void main(String[] args){


        int[] power0 = {1, 2, 6, 7};
        int armor0 = 5;
        int hp0 = 12;

        
        int[] power1 = {1, 2, 3};
        int armor1 = 1;
        int hp1 = 6;


        int[][] powers = {power0, power1};
        int[] armors = {armor0, armor1};
        int[] hps = {hp0, hp1};

        for (int i = 0 ; i < powers.length ; i++){
            System.out.println( getMinHealth(powers[i] , armors[i])  == hps[i]);
        }
        
    }
}
