package powerXN;

// https://leetcode.com/problems/powx-n/

class Solution {
    public double myPow(double x, int n) {       
        if ( x == 1 || n == 0 ){
            return 1;
        }
        if (x == 0) {
            return 0; 
//              remember that 0 ^ 0 is 1. but 0 ^ not zero is zero.
        }
        
        if ( x == -1 && n % 2 == 0)  { 
            return 1;
        } else if (x == -1) {
            return -1;
//             we already checked for return +1 cases in the above.
        }
        
        int expAbs = Math.abs(n); // edge case can't store -2147483648 absolute it'll just be MIN INT VALUE
        // calculate the result
        // double result = powerHelper(Math.abs(x), expAbs);
        double result = powerHelper(x, n);
               
        
        // // deal with complicated ones like negative base or 
        // if (x < 0 && expAbs % 2 != 0 ) {
        //     result *= -1;
        // } 
        // // deal with negative exponents
        // if (n < 0) {
        //     result = 1/result;
        // }
        
        return result;
        
    }
    
    // this will only work with absolute base or absolute exponents
    // we will not deal with x or n being zero here. 
    public double powerHelper(double x, int n) { // n cannot deal with +2147483648 > MAX INT VAL
        // base case
        if ( n == 0) {
            return 1; 
        }
        // inductive case
        if ( n < 0 ) {
            return (n%2 == 0) ? powerHelper(x*x, n/2) : 1/x * powerHelper(x, n + 1) ;
        }
        return (n%2 == 0) ? powerHelper(x*x, n/2) : x * powerHelper(x, n - 1);
    }
}

class TestTuple {
    double base;
    int exp;
    double ans;
    public TestTuple(double x, int n, double res) {
        this.base = x;
        this.exp = n;
        this.ans = res;
    }

}

public class powerXN {
    // https://leetcode.com/problems/powx-n/
    public static void main () {

        int ind = 1; // pick test case here.
        ind--;
        // test cases
        TestTuple case1 = new TestTuple(0, 0, 0);
        // insert new test cases here.

        TestTuple[] cases = {case1};
        TestTuple tc = cases[ind];
        

        Solution sol = new Solution();
        System.out.print(sol.myPow(tc.base, tc.exp) == tc.ans);
    }
}


