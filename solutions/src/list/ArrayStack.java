package list;

public class ArrayStack {

    public static void main(String[] args){

        Stack nums = new Stack();
        nums.push(10);
        nums.push(20);
        nums.push(30);
        nums.push(40);
        nums.push(50);

        nums.show();
        System.out.println("Stack size is: "+ nums.size());
        nums.pop();
        nums.peek();


    }
}


class Stack{

    int top=0;
    int capacity=2;
    int stack[] = new int[capacity];

    public int size(){
        return top;
    }

    public boolean isEmpty(){
        if(top<=0){
            return true;
        } else {
            return false;
        }
    }

    public void push(int data){
        //if(top==5){
          //  System.out.println("Stack is full");

        if(size()==capacity)
            expand();
            stack[top]=data;
            top++;


    }

    private void expand() {
        int length=size();
        int newstack[] = new int[capacity*2];
        System.arraycopy(stack,0,newstack,0,length);
        stack=newstack;
        capacity=capacity*2;
    }

    public void pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
        }else {
            int data;
            top--;
            data=stack[top];
            stack[top]=0;
            System.out.println("Element "+data+" removed from stack");
            shrink();
        }
    }

    private void shrink() {
        int length=size();
        if(length<=(capacity/2)/2){
            capacity=capacity/2;
            int newstack[] = new int[capacity];
            System.arraycopy(stack,0,newstack,0,length);
            stack=newstack;
        }
    }

    public void peek(){
        int data;
        data=stack[top -1];
        System.out.println("Top element is: "+ data);
    }


    public void show(){

        if(isEmpty()){
            System.out.println("Stack is empty");
        }else {
            for (int value : stack) {
                System.out.println(value);
            }
        }
    }


}