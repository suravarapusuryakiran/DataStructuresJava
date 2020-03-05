package com.company;

public class Student {
    int sum=0;
   public int add(int ... n){  // Here n is an array

       for (int i: n){
           sum+=i;
       }

       return sum;
   }

}
