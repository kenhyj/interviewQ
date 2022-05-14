import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// returns true or false if given number is prime number.
public class PrimeNumber {

    public static boolean primer(int number) {
        if (number < 1) {
            System.out.println("Please use a positive number");
            return false;
        } 
        if (number == 1 ) {
            System.out.println("1 is divisible by only one but its quotient is one. Prime numbers are only divisible by one and its quotients are not one.");
            return false; 
        } 
        if (number != 2 && number % 2 == 0 ) {
            System.out.println("All even numbers (except two) are divisible by 2");
            return false;
        } 

        for (int i = 3; i <= Math.sqrt(number); i = i+2) { // there's no need to check even divisor.
            if ( number % i  == 0 ) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // primer( Integer.parseInt(args[1]) );
        primer(2);

        // todo
    }
}