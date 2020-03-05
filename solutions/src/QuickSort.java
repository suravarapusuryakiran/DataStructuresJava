public class QuickSort {

      static void QuickSort(int[] arr,int low, int high){   // Here low and high are first and last index values of array

        if(low>high) return;
        int mid=(low+high)/2;                               // mid index value
        int pivot=arr[mid];

        int i=low;
        int j=high;

        while(i<=j){

            while (arr[i]<pivot){
                i++;
            }

            while (arr[j]> pivot){
                j--;
            }

            if(i<=j){          // remember this
                int temp;
                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }

        }

        if(low<j)                       // the moment when i and j cross each other one array is [low to j] and another is [i to high ]
            QuickSort(arr,low,j);
        if(i<high)
            QuickSort(arr,i,high);

    }

    public static void main(String[] args){
        QuickSort obj=new QuickSort();
        int arr[]= {31,37,29,5,7,4,3,2,77,6,7,9};
        System.out.println("Before Sorting");
        for(int i=0;i<arr.length;i++){
            System.out.print(" "+arr[i]);
        }

        QuickSort(arr,0,arr.length-1);
        System.out.println("After sorting");
        for (int i=0;i<arr.length;i++){
            System.out.print(" "+arr[i]);
        }
        System.out.println();
    }

}
