// ways to arrange number number is n!
// ways to pick/permute r out of n is npr = n!/(n-r)!
// ways to pick r and arrange/combine out of n is ncr n!/(n-r)! * r!

// swapping a number logic a=a+b b=a-b a = a-b

import java.lang.*;
import java.util.Scanner;

public class BionomialExpression {

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        // Factorial and binomial

//        System.out.println("Enter total number of pens");
//        int pens=sc.nextInt();
//
//        System.out.println("Choose desired pens out of "+pens+" pens");
//        int desired=sc.nextInt();
//
//        int ways= NCR(pens,desired);
//
//        System.out.println("Bionomial expression of "+pens+" c "+ desired+" is: "+ways);
//

        // Fibonacci

        System.out.println("Find out Fibonacci number at nth position");
        int n=sc.nextInt();
        int number=fibonacci(n);
        System.out.println("Nth number is: "+ number );

        // Sum of individual digits

        System.out.println("Sum of individual digits of a number");
        int num=sc.nextInt();
        System.out.println("Sum is: "+digitSum(num));

        // palindrome

        System.out.println("Enter a number to find palindrome or not");
        num=sc.nextInt();
        palindrome(num);

        // perfect number

        System.out.println("Enter a number to know whether it is perfect number (6,28) or not :");
        num=sc.nextInt();
        isPerfect(num);

        // Armstrong number

        System.out.println("Enter a number to check ArmStrong (153) or not : ");
        num=sc.nextInt();
        isArmstrong(num);

        // prime number

        System.out.println("Enter a number to find prime or not");
        num=sc.nextInt();
        isPrime(num);


    }


    private static int NCR(int pens, int desired) {

        int ways= fact(pens)/ (fact(pens-desired) * fact(desired) );
        return ways;
    }

    private static int fact(int x) {
        int f=1;

        while (x>1){
            f=f*x;
            x=x-1;
        }
        return f;

    }

    private static int fibonacci(int n) {


//        if(n==0){
//            return 0;
//        } else if(n==1){
//            return 1;
//        } else if(n==2){
//            return 1;
//        } else {
            int x = 0, y = 1, z = 1;

            for (int i = 0; i < n -1 ; i++) {
                x = y;
                y = z;
                z = x + y;
            }
            return x;
       // }
    }

    private static int digitSum(int num){


        if(num==0){
            return 0;
        }else {
            int sum=0,rem=0;

            while (num>0) {

                rem=num%10;
                sum=sum+rem;
                num=num/10;

            }
            return sum;
        }
    }

    private static void palindrome(int num){

        int rem,sum=0;

        int temp=num;

        while (num>0){
            rem=num%10;
            sum=sum*10+rem;
            num=num/10;
        }

        if(temp==sum){
            System.out.println("Entered number is palindrome");
        }else {
            System.out.println("Entered number is not palindrome");
        }

    }

    private static void isPerfect(int num){
        int sum=0;

        for(int i=1; i<num/2; i++){
            if(num%i==0)
                sum=sum+i;
        }

        if(sum==num){
            System.out.println("Entered number is perfect number");
        }else {
            System.out.println("Entered number is not perfect number");
        }
    }

    private static void isArmstrong(int num) {

        int temp=num;
        int sum=0,rem=0;

        while(num>0){
            rem=num%10;
            sum=sum+rem*rem*rem;
            num=num/10;
        }

        if(temp==sum)
            System.out.println(sum+" is Armstrong number");
        else
            System.out.println(sum+ " Isn't an Armstrong number");
    }

    public static void isPrime(int num) {
        boolean isPrime = true;

        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }

            if (isPrime) {
                System.out.println(num + " is prime number");
            } else {
                System.out.println(num + " is not a prime number");
            }

        }

    }


}


