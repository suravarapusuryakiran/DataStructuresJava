// Find highest value in column and compute their sum as well as lowest value in row and compute their sum
import java.util.Scanner;

public class JaggedArray {


    public static int sumHighestEachCol(int[][] array) {

        int maxColumn = 0;
        int numRows = array.length;

        for (int i = 0; i < numRows; i++) {      // To find maximum length of column
            if (array[i].length > maxColumn) {
                maxColumn = array[i].length;
            }
        }


            int[] result = new int[maxColumn];  // creating an empty array with max column length

                for (int j = 0; j < maxColumn; j++)
                    for(int i = 0; i < array.length;i++)
                        if (j < array[i].length && result[j] < array[i][j])
                            result[j]=array[i][j];

            int sum=0;

            // Display result

            for(int i=0;i<result.length;i++){
                System.out.println("Maximum element in column"+(i+1)+":"+ result[i]);
                sum=sum+result[i];
            }

            return sum;
        }


        public static int sumLowestEachRow(int[][] array) {

            int sum = 0;

            int[] result = new int[array.length];    // import point
            for (int i = 0; i < array.length; i++)
            {
                int minNum = array[i][0];           // import point//
                for (int j = 0; j < array[i].length; j++) {
                    if(minNum>array[i][j]) {
                        minNum=array[i][j];
                    }

                    result[i]=minNum;
                }
            }
            // Display results

            for(int i=0;i<result.length;i++){
                System.out.println("Minimum element in row"+ (i+1) + " : " + result[i] );
                sum=sum+result[i];
            }
            return  sum;
        }





    public static void sum(int array[][]) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sum += array[j][i];
            }
        }
        System.out.println("sum is: "+sum);
    }


    public  static void main(String args[]){


        Scanner sc= new Scanner(System.in);
        System.out.println("Enter number of Rows");
        int m= sc.nextInt();
        int sumOfColumn=0;
        int sumOfRow=0;

        int array[][]=new int [m][];

        for(int i=0;i<array.length;i++){

            System.out.println("Please enter number of columns in" + (i+1)+ "Row");
            int n=sc.nextInt();
            array[i]=new int[n];   // Here the size of columns for each row is fixed, So finally we get array in size according to user
        }

        System.out.println("Enter Values:");

        for(int i=0; i<array.length;i++){

            for(int j=0;j<array[i].length;j++){

                array[i][j]=sc.nextInt();
            }
        }

        for(int i=0; i<array.length;i++) {

            for (int j = 0; j < array[i].length; j++) {

                System.out.print(array[i][j] + "  ");
            }

            System.out.println();

        }

       // JaggedArray.compute(array);

        int sumoOfHighestEachColumn=JaggedArray.sumHighestEachCol(array);
        int sumOfLowestEachRow=JaggedArray.sumLowestEachRow(array);

        System.out.println("Sum of highest values in column: " + sumoOfHighestEachColumn);
        System.out.println("Sum of highest values in column: " + sumOfLowestEachRow);
        System.out.println("Subtraction result is : " + (sumoOfHighestEachColumn- sumOfLowestEachRow ) );

    }

}
