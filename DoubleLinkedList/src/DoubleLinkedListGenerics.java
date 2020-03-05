import java.util.NoSuchElementException;

public class DoubleLinkedListGenerics<T> {

    private Node<T> head;
    private Node<T> tail;
    private int length;


    private class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> previous;

        public Node(T data) {
            this.data = data;
        }

    }


    public DoubleLinkedListGenerics() {
        this.head = null;
        this.tail = null;
        this.length = 0;

    }

    public boolean isEmpty() {
        return length == 0;  // return true if length is ==0
    }

    public int length() {
        return length;
    }

    // -------------------------------

    public void insertFirst(T data) {
        Node<T> newNode = new Node<T>(data);

        if (isEmpty()) {
            tail = newNode;
        } else {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }


    public void insertLast(T data) {
        Node<T> newNode = new Node<T>(data);

        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        newNode.previous = tail;
        tail = newNode;
        length++;
    }

    public void insertAtIndex(int index,T data){
        if(head==null){
            insertFirst(data);

        } else if(index> this.length()){
            System.out.println("There is no such index, linked list length is of : "+length());

        } else if(index==this.length()){
            insertLast(data);

        } else if(index==0) {
            Node<T> newNode = new Node<T>(data);
            head.previous=newNode;
            newNode.next=head;
            head=newNode;
            length++;

        } else {
            Node<T> current = new Node<T>(data);

            Node<T> previous=head;
            for (int i=1; i<index; i++){
                previous=previous.next;
            }
            Node<T> nextnode= previous.next;

            previous.next=current;
            current.previous=previous;

            nextnode.previous=current;
            current.next=nextnode;
            length++;

        }
    }



    // -----------------------------------

    public Node<T> deleteFirst() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node<T> temp = head;
        if (head == tail) {
            tail = null;
        } else {
            head.next.previous = null;
        }

        head=head.next;
        temp.next=null;
        length--;
        return temp;
    }

    public Node<T> deleteLast() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node<T> temp = tail;
        if (head == tail) {
            head = null;
        } else {
            tail.previous.next = null;
        }

        tail=tail.previous;
        temp.previous=null;
        length--;
        return temp;
    }



    // -----------------------------------
    public void displayForward(){
        if(head==null){
            return;
        }

        Node<T> temp=head;
        while(temp!=null){
            System.out.print("-->"+temp.data);
            temp=temp.next;
        }

        System.out.println("-->null");
    }

    public void displayBackward(){
        if(tail==null){
            return;
        }

        Node<T> temp=tail;
        while(temp!=null){
            System.out.print("-->"+temp.data);
            temp=temp.previous;
        }

        System.out.println("-->null");
    }

    //----------------------------------------------



    public static void main(String[] args){
        DoubleLinkedListGenerics<Integer> obj= new DoubleLinkedListGenerics<Integer>();
        obj.insertLast(1);
        obj.insertLast(10);
        obj.insertLast(15);
        obj.insertLast(25);
        obj.insertFirst(0);
        obj.deleteFirst();
        obj.deleteLast();
        obj.displayForward();
        obj.displayBackward();
        obj.insertAtIndex(2,5);
        obj.displayForward();

    }

}
