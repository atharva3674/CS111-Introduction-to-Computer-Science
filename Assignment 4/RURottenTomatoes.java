/*************************************************************************
 *  Compilation:  javac RURottenTomatoes.java
 *  Execution:    java RURottenTomatoes
 *
 *  @author: Atharva Patil 
 *
 * RURottenTomatoes creates a 2 dimensional array of movie ratings 
 * from the command line arguments and displays the index of the movie 
 * that has the highest sum of ratings.
 *
 *  java RURottenTomatoes 3 2 5 2 3 3 4 1
 *  0
 *************************************************************************/

public class RURottenTomatoes {

    public static void main(String[] args) {

		// WRITE YOUR CODE HERE
		int [][] a = new int[Integer.parseInt(args[0])][Integer.parseInt(args[1])];
		int count = 0;

		for(int row = 0; row < a.length; row++){
			for(int col = 0; col < a[row].length; col++){
				a[row][col] = Integer.parseInt(args[count + 2]);
				count++;
			}

		}


		int[] colAvg = new int[Integer.parseInt(args[1])];

		for(int col = 0; col < Integer.parseInt(args[1]) ; col++){
			for(int row = 0; row < a.length; row++){
				colAvg[col] += a[row][col];
			}
		}

		int isLargest = colAvg[0];
		int index = 0;

		for(int i = 0; i < colAvg.length; i++){
			for(int j = i + 1; j < colAvg.length; j++){

				if(isLargest < colAvg[j] ){
					isLargest = colAvg[j];
					index = j;
				}
			}
		}
	
		System.out.println(index);
		
	}
}
