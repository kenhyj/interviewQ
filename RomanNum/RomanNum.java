package RomanNum;

class Solution {
    public int romanToInt(String s) {

        return helper3(s);
    }

    private int helper3(String s){
        int i = 0 ;
        String cc, ss;
        int sum = 0;
        while (i < s.length()) {
            ss = s.substring(i, i+1);
            if (ss.equals("I")){
                try {
                    cc = s.substring(i+1, i+2);
                    if (cc.equals("V") || cc.equals("X")) {
                        i+= 2;
                        sum += cc.equals("V")? 4: 9;
                    } else {
                        i += 1;
                        sum += 1;
                    }
                }
                catch(IndexOutOfBoundsException e){
                    i += 1;
                    sum += 1;
                }
            } else if (ss.equals("V")){
                i += 1;
                sum += 5;
            } else if (ss.equals("X")) {
                try {
                    cc = s.substring(i+1, i+2);
                    if (cc.equals("L") || cc.equals("C")) {
                        i += 2;
                        sum += cc.equals("L")? 40: 90;
                    } else {
                        i += 1;
                        sum += 10;
                    }
                }
                catch(IndexOutOfBoundsException e){
                    i += 1;
                    sum += 10;
                }
            } else if (ss.equals("L") ){
                i += 1;
                sum += 50;
            } else if (ss.equals("C")){
                try {
                    cc = s.substring(i+1, i+2);
                    if (cc.equals("D") || cc.equals("M")) {
                        i += 2;
                        sum += cc.equals("D")? 400: 900;
                    } else {
                        i += 1;
                        sum += 100;
                    }
                }
                catch(IndexOutOfBoundsException e){
                    i += 1;
                    sum += 100;
                }
            } else if (ss.equals("D")){
                i += 1;
                sum += 500;
            } else if (ss.equals("M")){
                i += 1;
                sum += 1000;
            }
        }
        return sum;
    }
}

public class RomanNum {

    public static void main(String[] args) {
        // test cases
        // test 1
        String s1 = "III";
        int a1 = 3;
        // test 2
        String s2 = "LVIII";
        int a2 = 58;
        // test 3
        String s3 = "MCMXCIV";
        int a3 = 1994;
        // test 4
        String s4 = "CM";
        int a4 = 900;
        // test 5
        String s5 = "IV";
        int a5 = 4;
        // test 6
        String s6 = "MCDLXXVI";
        int a6 = 1476;

        String[] inputs = { s1, s2, s3, s4, s5, s6 };
        int[] outputs = { a1, a2, a3,a4,a5, a6 };

        Solution sol = new Solution();

        for (int i = 0; i < inputs.length; i++) {
            int x = sol.romanToInt(inputs[i]);
            int y = outputs[i];
            System.out.println ( "test case " + String.valueOf(i+1) + " " + ( x == y ? "passed": ("failed " +  String.valueOf(x) + " vs " + String.valueOf(y)) ) );
        }
    }
}
