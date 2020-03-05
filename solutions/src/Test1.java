import java.util.*;
import java.lang.*;

public class Test1 {

    void delay (double time){
        System.out.println("");
    }


    private static int fibIt(int n) {
        int stepsIt=0;
        int x = 0, y = 1, z = 1;
        for (int i = 0; i < n; i++) {
            stepsIt++;
            x = y;
            y = z;
            z = x + y;
        }

        System.out.println("Total steps: " + stepsIt);
        return z;
    }

    public static void main(String[] args){
        int num1=2;
        int num2= num1++ *3; // ++num1 gives 9 and num++ gives 6 as result
        System.out.println(num2);

      int a=7;
      int b=2;

      float c=7/2;
      System.out.println("c");

      int t=-1;
      int r=-1* t++ +3;
      System.out.println("r --> "+r + " t-->"+t);  // r=4 and t=0

      int k=-1;
      int l=-1* ++k +3;
      System.out.println("L -->"+l+" K-->"+k);  //  l=3 and k=0

        for(int i = 0; i < 10; i ++) {
            if (i % 3 == 0)
                continue;
            if (i % 2 == 0)
                System.out.print("*");
            else
                System.out.print("+");
        }

        System.out.println("Fibonacci series : "+ Test1.fibIt(6));

        Integer h = new Integer(10);
        System.out.println("Value of H is: "+h);
         h=11;
         System.out.println("Value of H is: "+h);
         int j=h+1;
         System.out.println(h+" " +j);




    }

}
