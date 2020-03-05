import java.util.NoSuchElementException;

public class Queue {

    private Node front;
    private Node rear;
    private int length;

    public Queue(){
        this.front=null;
        this.rear=null;
        this.length=0;
    }

    private class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length==0;
    }


    public void enqueue(int data){
        Node temp = new Node(data);
        if(isEmpty()){
            front=temp;
        }
        else{
            rear.next=temp;
        }

        rear=temp;
        length++;
    }

    public int dequeue(){
        if(isEmpty()){
                throw new NoSuchElementException("Queueis already empty");
        }

        int result = front.data;
        front=front.next;

        if(front==null){
            rear=null;
        }

        length--;

        return result;
    }

    public void display(){
        if(isEmpty()){
            return;
        }

        Node current= front;

        while(current!=null){
            System.out.print(" <-- "+ current.data);
            current=current.next;
        }

        System.out.println("<-- null");
    }


    public  static  void  main(String args[]){

        Queue obj = new Queue();
        obj.enqueue(10);
        obj.enqueue(15);
        obj.enqueue(20);
        System.out.println("Length of Queue is: "+ obj.length());
        obj.display();
        obj.dequeue();
        obj.display();
        System.out.println("Length of Queue is: "+ obj.length());
        obj.dequeue();
        obj.display();
        System.out.println("Length of Queue is: "+ obj.length());
        obj.dequeue();
        obj.display();
        System.out.println("Length of Queue is: "+ obj.length());
        obj.dequeue();


    }

}
