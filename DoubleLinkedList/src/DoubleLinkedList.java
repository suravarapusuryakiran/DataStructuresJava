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

    public void insertAtIndex(int index,int data){
        if(front==null){
            insertFirst(data);

        } else if(index> this.length()){
            System.out.println("There is no such index, linked list length is of : "+length());

        } else if(index==this.length()){
            insertLast(data);

        } else if(index==0) {
            Node newNode = new Node(data);
            front.previous=newNode;
            newNode.next=front;
            front=newNode;
            length++;

        } else {
            Node current = new Node(data);

            Node previous=front;
            for (int i=1; i<index; i++){
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

    public boolean remove(int data){

        Node current= front;
        boolean found = false;

        if(!isEmpty()){
            do{
                if(current.data== data){   // if they match
                    found=true;
                    break;
                } else {
                    current=current.next;
                }
            } while (current!=rear.next);
        }

        if(found){
            if(current==front && length()==1){   //removes the only existing element
                front=null;
                rear=null;
            }else if(current==front){   // removes node at first
                    deleteFirst();

            } else if(current == rear){   // removes node at last
                deleteLast();
            } else {

                current.previous.next=current.next;
                current.next.previous=current.previous;
            }

            length --;
        }

        return found;

    }








    // -----------------------------------

    public Node deleteFirst() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node temp = front;
        if (front == rear) {
            rear = null;
        } else {
            front.next.previous = null;
        }

        front=front.next;
        temp.next=null;
        length--;
        return temp;
    }

    public Node deleteLast() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node temp = rear;
        if (front == rear) {
            front = null;
        } else {
            rear.previous.next = null;
        }

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

        Node temp=front;
        while(temp!=null){
            System.out.print("-->"+temp.data);
            temp=temp.next;
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
        System.out.println("List length is : "+ obj.length());
        //obj.displayBackward();
        obj.insertAtIndex(2,5);
        obj.displayForward();

        obj.displayForward();


        obj.displayForward();



    }

}
