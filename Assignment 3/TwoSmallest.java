/*************************************************************************
 *  Compilation:  javac TwoSmallest.java
 *  Execution:    java TwoSmallest 1.1 6.9 0.3
 *
 *  @author: Atharva Patil 
 *
 *  The program TwoSmallest takes a set of double command-line
 *  arguments and prints the smallest and second-smallest number, in that
 *  order. It is possible for the smallest and second-smallest numbers to
 *  be the same (if the sequence contains duplicate numbers).
 *
 *  Note: display one number per line
 *
 *  % java TwoSmallest 17.0 23.0 5.0 1.1 6.9 0.3
 *  0.3
 *  1.1
 *
 *  % java TwoSmallest 17.0 23.0 5.0 1.1 6.9 0.3
 *  0.3
 *  0.3
 *************************************************************************/

public class TwoSmallest {

    public static void main(String[] args) {

    // WRITE YOUR CODE HERE
    double low = Double.MAX_VALUE;
    double low1 = Double.MAX_VALUE;
    int count = 0;

    while(count < args.length){
        if(count == 0){
            low = Double.parseDouble(args[count]);
        }
        
        if(count == 1){
            low1 = Double.parseDouble(args[count]);
        }

        if(low>low1){
            double a = low1;
            low1 = low;
            low = a;
        }

        if(low1> Double.parseDouble(args[count]) && count != 1){
            low1 = Double.parseDouble(args[count]);
        }    

        count++;
    }

    if(low>low1){
        System.out.println(low1);
        System.out.println(low);
    }
    else{
        System.out.println(low);
        System.out.println(low1);
    }

}
}
