/*************************************************************************
 *  Compilation:  javac LargestOfFive.java
 *  Execution:    java LargestOfFive 35 10 32 1 8
 *
 *  @author: Atharva Patil
 *
 *  Takes five distinct integers as command-line arguments and prints the 
 *  largest value
 *
 *
 *  % java LargestOfFive 35 10 32 1 8
 *  35
 *
 *  Assume the inputs are 5 distinct integers.
 *  Print only the largest value, nothing else.
 *
 *************************************************************************/

public class LargestOfFive {

    public static void main (String[] args) {

        // WRITE YOUR CODE HERE
        int n1 = Integer.parseInt(args[0]);
        int n2 = Integer.parseInt(args[1]);
        int n3 = Integer.parseInt(args[2]);
        int n4 = Integer.parseInt(args[3]);
        int n5 = Integer.parseInt(args[4]);

        if(n1 > n2 && n1> n3 && n1 > n4 && n1 > n5)
        {
            System.out.println(n1);
        }
        else{
            if (n2 > n3 && n2 > n4 && n2 >n5)
            {
                System.out.println(n2);
            }
            else{
                if (n3 > n4 && n3>n5)
                {
                    System.out.println(n3);
                }
                else{
                    if (n4 > n5)
                    {
                        System.out.println(n4);
                    }
                    else{
                        System.out.println(n5);
                    }
                }
            }
        }

    }
}