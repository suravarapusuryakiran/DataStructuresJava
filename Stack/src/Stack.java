import java.util.EmptyStackException;

public class Stack {

    private Node top;
    private int length;

    private class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public Stack(){
        top=null;
        length=0;
    }

    public  int length(){
        return  length;
    }

    public boolean isEmpty(){
        return length==0;
    }


    public void push(int data){
        Node temp= new Node(data);
        temp.next=top;
        top=temp;
        length++;
    }

    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }

        int result=top.data;
        top=top.next;
        length--;
        return result;
    }

    public int peek(){    // returns top data
        if(isEmpty()){
            throw new EmptyStackException();
        }

        return top.data;
    }

    public void display() {

        if (top == null) {
            System.out.printf("\nStack Underflow");
            System.exit(1);
        } else {
            Node current = top;
            while (current != null) {

                // print node data
                System.out.printf("%d->", current.data);

                // assign temp link to temp
                current = current.next;

            }
        }
        System.out.println();
    }


    public static void main(String args[]){

        Stack stack = new Stack();
        stack.push(10);
        stack.push(15);
        stack.push(20);

        stack.display();


        System.out.println("Top element is : "+stack.peek());
        int x=stack.pop(); System.out.println("Removing the top element : "+ x);
        System.out.println("Top element is : "+stack.peek());
        stack.display();
        System.out.println("Stack length is : "+ stack.length() );




    }
}
