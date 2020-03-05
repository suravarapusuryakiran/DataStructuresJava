import java.util.*;
public class Tutorial5Sorting {



    Scanner sc= new Scanner(System.in);

    public int[] insert(){
        System.out.println("Enter the size of the array you want to create");
        int row=sc.nextInt();
        int array[] = new int[row];
        System.out.println("Array of length is: "+ array.length);
        System.out.println("Enter integer values in an array");

        for(int i=0;i < array.length;i++){
            System.out.println("Enter value in column :  "+i);
            array[i]= sc.nextInt();
        }

        return array;
    }

    public int[] bubbleSort(int[] array){

        int i,j,temp;
        for(i=0;i<array.length -1;i++){
            for(j=0;j< array.length -1 -i;j++){
                if(array[j]>array[j+1]){            // After one iteration you get highest number in the array at the end, hence you need to iterate till (array.length -1) -i
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        return array;
    }


    public int[] insertionSort(int[] array){  // used very less as not quick
        int i,j,key,temp;
        for(i=1;i<array.length; i++){
            key=array[i];
            j=i-1;

            while (j>=0 && key< array[j]){
                temp=array[j];
                array[j]=array[j+1];
                array[j+1]=temp;
                j--;
            }
        }
        return array;
    }

    public int[] selectionSort(int[] array){

        int i, j,minValue,minIndex,temp=0;
        for(i=0;i<array.length;i++){
            minValue=array[i];
            minIndex=i;

            for (j=i;j<array.length;j++){
                if(array[j]<minValue){
                    minValue=array[j];
                    minIndex=j;
                }
            }

            if(minValue <array[i]){
                temp=array[i];
                array[i]=array[minIndex];
                array[minIndex]=temp;
            }

        }

        return array;
    }



    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);

        Tutorial5Sorting obj = new Tutorial5Sorting();
        int array[]=obj.insert();
        System.out.println("Elements in an array are: ");
        for(int i=0;i <array.length;i++){
            System.out.println("-->"+array[i]);
        }

        System.out.println("Sorted array is : ");

        //int sortedArray[]=obj.insertionSort(array);
        //int sortedArray[]=obj.selectionSort(array);
        int sortedArray[]= obj.bubbleSort(array);

        for(int i=0;i <array.length;i++){
            System.out.println("-->"+array[i]);
        }



    }
}
