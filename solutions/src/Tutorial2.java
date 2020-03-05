// Write a program to test a number positive or negative
import  java.util.*;
public class Tutorial2 {

    Scanner sc = new Scanner(System.in);

    public void find()
    {

        System.out.println("Enter a number to find out whether it is positive or negative");
        int x= sc.nextInt();

        if(x>=0) {
        System.out.println("Entered number is positive");
        } else {
        System.out.println("Entered number is negative");
         }
    }

    public void grade(){
        System.out.println("Enter Quiz 1: ");
        int q1=sc.nextInt();

        System.out.println("Enter Quiz 2: ");
        int q2=sc.nextInt();

        System.out.println("Enter Quiz 3: ");
        int q3=sc.nextInt();

        int average= (q1+q2+q3)/3;

        if(average>=90){
            System.out.println("Grade=A");
        }else if(average>=80 && average<90){
            System.out.println("Grade=B");
        } else if(average>=60 && average<80){
            System.out.println("Grade=C");
        } else {
            System.out.println("Grade=F");
        }

    }

    public void leapYear(){
        System.out.println("Enter a year to know leap year or not");
        int year=sc.nextInt();

        if(year%4!=0) {
            System.out.println(year + " is not a leap year");
        }else{

            if(year%100 == 0 && year%400 !=0 )
            System.out.println(year+ " is not a leap year");
            else {
                System.out.println(year+ " is a leap year");
            }

        }

    }


    public void numberOfDaysInMonth(){
        int number_Of_DaysInMonth = 0;
        String MonthOfName = "Unknown";

        System.out.print("Input a month number: ");
        int month = sc.nextInt();

        System.out.print("Input a year: ");
        int year = sc.nextInt();

        if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
            System.out.println(year+ " is a Leap year");
        } else {
            System.out.println(year+ " is not a Leap year");
        }

        switch (month) {
            case 1:
                MonthOfName = "January";
                number_Of_DaysInMonth = 31;
                break;
            case 2:
                MonthOfName = "February";
                if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                    number_Of_DaysInMonth = 29;
                } else {
                    number_Of_DaysInMonth = 28;
                }
                break;
            case 3:
                MonthOfName = "March";
                number_Of_DaysInMonth = 31;
                break;
            case 4:
                MonthOfName = "April";
                number_Of_DaysInMonth = 30;
                break;
            case 5:
                MonthOfName = "May";
                number_Of_DaysInMonth = 31;
                break;
            case 6:
                MonthOfName = "June";
                number_Of_DaysInMonth = 30;
                break;
            case 7:
                MonthOfName = "July";
                number_Of_DaysInMonth = 31;
                break;
            case 8:
                MonthOfName = "August";
                number_Of_DaysInMonth = 31;
                break;
            case 9:
                MonthOfName = "September";
                number_Of_DaysInMonth = 30;
                break;
            case 10:
                MonthOfName = "October";
                number_Of_DaysInMonth = 31;
                break;
            case 11:
                MonthOfName = "November";
                number_Of_DaysInMonth = 30;
                break;
            case 12:
                MonthOfName = "December";
                number_Of_DaysInMonth = 31;
        }
        System.out.print(MonthOfName + " " + year + " has " + number_Of_DaysInMonth + " days\n");

    }

    public void day(){

        System.out.println("Enter the day: ");
        int d=sc.nextInt();

        System.out.println("Enter month : ");
        int m=sc.nextInt();

        System.out.println("Enter Year: ");
        int y=sc.nextInt();

        Map<Integer,String > map = new HashMap<>();

        map.put(0,"Sunday");
        map.put(1,"Monday");
        map.put(2,"Tuesday");
        map.put(3,"Wednesday");
        map.put(4,"Thursday");
        map.put(5,"friday");
        map.put(6,"saturday");

            int t[] = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };
            y = y - ((m < 3) ? 1 : 0);
            int result= ( y + y/4 - y/100 + y/400 + t[m-1] + d) % 7;

            System.out.println(" Day is: "+ map.get(result));

}


    public static void main(String args[]){
            Tutorial2 obj= new Tutorial2();
            //obj.find();
            //obj.grade();
            //obj.numberOfDaysInMonth();
            obj.day();

    }


}
