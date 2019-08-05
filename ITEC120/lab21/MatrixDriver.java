/**
 * MatrixDriver class - create new 2D arrays and run test cases
 * 
 * @author James Caldwell 
 * @version November 12th, 2014
 */
public class MatrixDriver
{
   public static void main(String[] args)
   {
       
       Matrix matrix = new Matrix();
       
       int[][] testArray = matrix.newMatrix(3,3);
       matrix.fill(testArray,10,4);
       matrix.print(testArray);
       
       
    }
}
