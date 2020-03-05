// Java program to illustrate
// for-each loop

class ForEach
{
    final int minPassed = 48;

    public static void main(String[] arg)
    {
        {
            int[] marks = { 60, 16, 85, 42, 66, 55, 50, 10, 25, 88 };

            int highest_marks = maximum(marks);
            int losest_marks  = minimum(marks);
            int [] passed_Scores =  passedStudents(marks);
            System.out.println("The highest score is " + highest_marks);
            System.out.println("The losest score is " + losest_marks);
            printarr (passed_Scores);

        }
    }

    public static int maximum(int[] numbers) {
        int maxSoFar = numbers[0];

        // for each loop
        for (int num : numbers)
        {
            if (num > maxSoFar)
            {
                maxSoFar = num;
            }
        }
        return maxSoFar;
    }

    public static int minimum (int[] numbers) {
        int minSoFar = numbers[0];

        // for each loop
        for (int num : numbers)
        {
            if (num < minSoFar)
            {
                minSoFar = num;
            }
        }
        return minSoFar;
    }

    public static int[] passedStudents (int[] numbers) {
        final int minSoFar = 48;
        int[] passed = new int[numbers.length];
        int idx = 0 ;
        for (int num : numbers) {
            if (num > minSoFar) {
                passed[idx] = num;
                idx +=1;
            }
        }
        return passed;
    }

    public static void printarr (int[] numbers) {
        System.out.print( "[ ");
        for (int num : numbers){
            if (num != 0)
                System.out.print( num +" ");
        }
        System.out.println( "] ");

    }

}
