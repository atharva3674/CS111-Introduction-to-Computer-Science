/*************************************************************************
 *  Compilation:  javac CheckDigit.java
 *  Execution:    java CheckDigit 020131452
 *
 *  @author: Atharva Patil 
 *
 *  Takes a 12 or 13 digit integer as a command line argument, then computes
 *  and displays the check digit
 *
 *  java CheckDigit 048231312622
 *  0
 *
 *  java CheckDigit 9780470458310
 *  0
 * 
 *  java CheckDigit 9780470454310
 *  8
 * 
 *  Print only the check digit character, nothing else.
 *
 *************************************************************************/

public class CheckDigit {

    public static void main (String[] args) {

        // WRITE YOUR CODE HERE
        long number = Long.parseLong(args[0]); 
        int n = 1;
        long sum1 = 0;
        long sum2 = 0;
        long sum = 0;
        long digit1 = 0;
        long digit2 = 0;
        
        while(number > 0){
            if (n == 1){
                digit1 = number % 10;
                sum1 += digit1;
                number = number / 10;
                n++;
            }
            else{
                digit2 = number % 10;
                sum2 += digit2;
                number = number / 10;
                n--;
            }

        }

        sum1 = sum1 % 10;
        sum2 = ((sum2 % 10) * 3) % 10;
        sum = (sum1 + sum2) % 10;
        System.out.println(sum);
        
    }
}