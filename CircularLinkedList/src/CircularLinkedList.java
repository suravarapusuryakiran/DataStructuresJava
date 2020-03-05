public class CircularLinkedList {

    public int size =0;
    public Node head=null;
    public Node tail=null;

    //add a new node at the start of the linked list
    public void addNodeAtStart(int data){
        System.out.println("Adding node " + data + " at start");
        Node node = new Node(data);
        if(size==0){
            head = node;
            tail = node;
            node.next = head;
        }else{
           // Node temp = head;
            node.next = head;
            head = node;
            tail.next = head;
        }
        size++;
    }

    public void addNodeAtEnd(int data){
        if(size==0){
            addNodeAtStart(data);
        }else{
            Node node = new Node(data);
            tail.next =node;
            tail=node;
            tail.next = head;
            size++;
        }
        System.out.println("\nNode " + data + " is added at the end of the list");
    }



    public void deleteNodeFromStart(){
        if(size==0){
            System.out.println("\nList is Empty");
        }else{
            System.out.println("\ndeleting node " + head.data + " from start");
            head = head.next;
            tail.next=head;
            size--;
        }
    }

    public void deleteNodeFromLast(){
        if(size==0){
            System.out.println("\nList is Empty");
        }else{
            Node current=head;
            while(current.next!=tail){
                current=current.next;
            }
            tail =current;
            tail.next=head;
        }
    }



    public int elementAt(int index){
        if(index>size){
            return -1;
        }
        Node node = head;
       for(int i=0;i<index;i++){
           node=node.next;
       }
        return node.data;
    }



    public void insertAt(int index,int data){

        Node node = new Node(data);
        if(index>size){
            return ;
        } else if(index==0){
            addNodeAtStart(data);
        } else if(index==getSize()){
            addNodeAtEnd(data);
        } else{
            Node current = head;
            for(int i=0;i<index -1;i++){
                current=current.next;
            }
            node.next=current.next;
            current.next=node;

        }
    }

    public void deleteAt(int index){
        if(index>size){
            return ;
        } else if(index==0){
            deleteNodeFromStart();
        } else if(index==getSize()) {
            deleteNodeFromLast();
        } else {
            Node current = head;
            for(int i=0;i<index -1;i++){
                current=current.next;
            }
            System.out.println("Deleting "+current.next.data);
            current.next=current.next.next;
        }

    }

    //print the linked list
    public void print(){
        System.out.print("Circular Linked List:");
        Node temp = head;                //////////////// one of the best way to print or find data in circular linked list is do while
        if(size<=0){
            System.out.print("List is empty");
        }else{
            do {
                System.out.print(" " + temp.data);
                temp = temp.next;
            }
            while(temp!=head);
        }
        System.out.println();
    }

    //get Size
    public int getSize(){
        return size;
    }

    public static void main(String[] args) {
        CircularLinkedList c = new CircularLinkedList();
        c.addNodeAtStart(3);
        c.addNodeAtStart(2);
        c.addNodeAtStart(1);
        c.print();
        c.deleteNodeFromStart();
        c.print();
        c.addNodeAtEnd(4);
        c.print();
        c.insertAt(2,22);
        c.print();
        c.deleteAt(3);
        c.print();
        System.out.println("Size of linked list: "+ c.getSize());
        System.out.println("Element at 2nd position: "+ c.elementAt(2));
    }

}

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
    }

}
