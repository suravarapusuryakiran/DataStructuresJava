package com.company;


public class Main {

    public static void main(String[] args) {
	// write your code here
        int i=-1;
        int r=1 * i++ +3;   // There is difference between i++ and ++i as you know
        System.out.println("i is "+i +" and r is "+ r);
        Student obj= new Student();
        System.out.println("student marks sum is = "+ obj.add(1,2,3,4,5));
    }
}

