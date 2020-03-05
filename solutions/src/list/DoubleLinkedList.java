package list;

import java.util.NoSuchElementException;

public class DoubleLinkedList {

    private Node front;
    private Node rear;
    private int length;


    private class Node {
        private int data;
        private Node next;
        private Node previous;

        public Node(int data) {
            this.data = data;
        }

    }


    public DoubleLinkedList() {
        this.front = null;
        this.rear = null;
        this.length = 0;

    }

    public boolean isEmpty() {
        return length == 0;  // return true if length is ==0
    }

    public int length() {
        return length;
    }

    // -------------------------------

    public void insertFirst(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            rear = newNode;
        } else {
            front.previous = newNode;
        }
        newNode.next = front;
        front = newNode;
        length++;
    }


    public void insertLast(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        newNode.previous = rear;
        rear = newNode;
        length++;
    }



    // -----------------------------------

    public Node deleteFirst() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        if (front == rear) {
            rear = null;
        } else {
            front.next.previous = null;
        }

        Node current = front;
        front=front.next;
        current.next=null;
        length--;
        return current;
    }

    public Node deleteLast() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        if (front == rear) {
            front = null;
        } else {
            rear.previous.next = null;
        }

        Node temp = rear;
        rear=rear.previous;
        temp.previous=null;
        length--;
        return temp;
    }



    // -----------------------------------
    public void displayForward(){
        if(front==null){
            return;
        }

        Node current=front;
        while(current!=null){
            System.out.print("-->"+current.data);
            current=current.next;
        }

        System.out.println("-->null");
    }

    public void displayBackward(){
        if(rear==null){
            return;
        }

        Node temp=rear;
        while(temp!=null){
            System.out.print("-->"+temp.data);
            temp=temp.previous;
        }

        System.out.println("-->null");
    }

    public void insertAtIndex(int index,int data){
        if(front==null){
            insertFirst(data);

        } else if(index> this.length()){
            System.out.println("There is no such index, linked list length is of : "+length());

        } else if(index==this.length()){
            insertLast(data);

        } else if(index==0) {
         insertFirst(data);

        } else {
            Node current = new Node(data);

            Node previous=front;
            for (int i=0; i<index -1; i++){
                previous=previous.next;
            }
            Node nextnode= previous.next;

            previous.next=current;
            current.previous=previous;

            nextnode.previous=current;
            current.next=nextnode;
            length++;

        }
    }

    //----------------------------------------------



    public static void main(String[] args){
        DoubleLinkedList obj= new DoubleLinkedList();
        obj.insertLast(1);
        obj.insertLast(10);
        obj.insertLast(15);
        obj.insertLast(25);
        obj.insertFirst(0);
        obj.deleteFirst();
        obj.deleteLast();
        obj.displayForward();
        obj.displayBackward();


    }

}
