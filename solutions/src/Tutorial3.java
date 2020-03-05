import java.util.Scanner;
import java.lang.*;
public class Tutorial3 {

    Scanner sc = new Scanner(System.in);

    public void chinesZodiac(){
        System.out.print("Enter a year: ");
        int year = sc.nextInt();
        int index = (year % 12);
        String[] zodiac = { "monkey", "rooster", "dog", "pig", "rat", "ox",
                "tiger", "rabbit", "dragon", "snake", "horse", "sheep", };
        System.out.println(zodiac[index]);
    }

    public void ascDsc(){
        System.out.print("Input first number: ");
        double x = sc.nextDouble();
        System.out.print("Input second number: ");
        double y = sc.nextDouble();
        System.out.print("Input third number: ");
        double z = sc.nextDouble();
        if (x < y && y < z)
        {
            System.out.println("Increasing order");
        }
        else if (x > y && y > z)
        {
            System.out.println("Decreasing order");
        }
        else
        {
            System.out.println("Neither increasing or decreasing order");
        }
    }


    public static void main(String[] args)
        {
            Scanner sc = new Scanner(System.in);
            Tutorial3 obj= new Tutorial3();
            obj.chinesZodiac();

        }
    }

