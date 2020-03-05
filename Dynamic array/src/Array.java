import java.util.Scanner;

public class Array {

    public static void main(String args[]) {

            Scanner sc= new Scanner(System.in);
            System.out.println("Please Enter no. of rows: ");
            int m=sc.nextInt();
            System.out.println("Please enter number of columns");
            int n=sc.nextInt();

            int array[][]=new int[m][n];
            System.out.println("Enter values");
            for(int i=0;i<array.length;i++){   // array.length = no of row=m

                for(int j=0; j<array[i].length;j++){  // array[0].length = no of columns = n

                    array[i][j]= sc.nextInt();
                }
            }


            for(int i=0; i<m;i++){

                for(int j=0;j<n;j++){
                    System.out.print(array[i][j] + " ");
                }

                System.out.println();
            }


    }

}
