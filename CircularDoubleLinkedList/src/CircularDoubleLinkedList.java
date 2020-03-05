import java.util.NoSuchElementException;

public class CircularDoubleLinkedList {

    private Node front;
    private Node rear;
    int length;
    protected boolean found;         // true if element found, else false
    //protected Node location;



    CircularDoubleLinkedList(){
        length=0;
    }


    public boolean isEmpty() {
        return length == 0;  // return true if length is ==0
    }

    public int length() {
        return length;
    }

    public void insertLast(int data) {
        Node node = new Node(data);

       if(length==0){
           front=node;
           rear=node;
           front.previous=rear;
           rear.next=front;
       } else {

           rear.next=node;
           node.previous=rear;
           rear=node;
           rear.next=front;
           front.previous=rear;
       }

       length++;
    }


    public void  insertFront(int data){
        Node node= new Node(data);

        if(isEmpty()){
            front=node;
            rear=node;
            front.previous=rear;
            rear.next=front;
        } else {
            node.next=front;
            front.previous=node;
            front=node;
            front.previous=rear;
            rear.next=front;
        }
        length++;
    }

    public boolean remove(int data){

       Node current= front;
        found=false;

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
                    front=front.next;
                    front.previous=rear;
                    rear.next=front;
                } else if(current == rear){   // removes node at last
                    rear=rear.previous;
                    rear.next=front;
                    front.previous=rear;
                } else {

                    current.previous.next=current.next;
                    current.next.previous=current.previous;
                }

                length --;
        }

        return found;

    }


    public void removeFront(){

        if(!isEmpty()){
            if(front.next==front){  // if the first element is the only element in the list
                front=null;
                rear=null;
            }else{
                // removes the first element
                front=front.next;
                front.previous=rear;
                rear.next=front;
            }

            length --;
        }
    }


    public void removeBack(){

        if(!isEmpty()){
            if(front.next==front){  // if the first element is the only element in the list
                front=null;
                rear=null;
            }else{
                // removes the first element
                rear=rear.previous;
                rear.next=front;
                front.previous=rear;
            }

            length --;
        }
    }

    public void addAtPosition(int data, int index){
        // adds new element to the specified position

        Node node = new Node(data);

        if(isEmpty()){
            // add element to the list
            front=node;
            rear=node;
            front.previous=rear;
            rear.next=front;
        } else if(index==0){
            // insert at front of the list
            node.next=front;
            front.previous=node;
            front=node;
            node.previous=rear;
            rear.next=node;
        } else if(index >= length()){
            // if index is greater then we add at the end
            rear.next=node;
            node.previous=rear;
            rear=node;
            rear.next=front;
        } else{
            /* determine where to perform insert*/
            Node current=front;
            for(int i=0;i<index;i++){
                current=current.next;
            }

            node.previous=current.previous;
            node.next=current;
            current.previous.next=node;
            current.previous=node;

        }
        length ++;

    }

    public void removeAtPosition(int index){
        // remove the element in specific index

        if(index ==0){  // remove first element
            front=front.next;
            front.previous=rear;
            rear.next=front;
        } else if(index == length() -1){
            rear=rear.previous;
            rear.next=front;
            front.previous=rear;
        } else{
            Node current=front;
            for(int i=0;i<index;i++){
                current=current.next;
            }

            current.previous.next=current.next;
            current.next.previous=current.previous;

        }

        length --;
    }


    public void displayForward(){
        if(front==null){
            return;
        }
        Node temp=front;
        while(temp!=rear){
            System.out.print("-->"+temp.data);
            temp=temp.next;
        }

        System.out.print("-->"+ temp.data);

    }


    private class Node{
        Node next;
        Node previous;
        int data;

        Node(int data){
            this.data=data;
        }
    }


    public static void main(String[] args){
      CircularDoubleLinkedList obj = new CircularDoubleLinkedList();
      obj.insertLast(1);
      obj.insertLast(2);
      obj.insertLast(3);
      obj.addAtPosition(10,1);
      obj.displayForward();


    }
}
