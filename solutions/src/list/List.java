package list;
import list.Node;

public class List {

    Node front;
    static int length=0;

    public List(){
        front=null;
    }

    public boolean isEmpty(){
        return front==null;  // returns true if list is empty else false in case of existing Nodes
    }

    public void display() {
        for (Node it = front; it != null; it = it.next) {
            System.out.println(it.toString());
        }
    }

    public static int length() {
        return length;
    }



    public void add(int data){
        Node node= new Node(data);
        if(front==null){
            front=node;
        }
        else {
            Node current= front;
            while (current.next!=null){
                current=current.next;
            }
            current.next=node;
        }
        length++;
    }

    public void addAtStart(int data){
        Node node= new Node(data);
        node.next=front;
        front=node;
        length++;
    }

    public void addAtIndex(int index,int data){
        Node node= new Node(data);
        if(index==0){
            addAtStart(data);
        }
        else
        {
            Node current= front;
            for(int i=0;i<index-1;i++){
                current=current.next;
            }

            node.next=current.next;
            current.next=node;
        }
    }

    public void deleteNode(int key){
        Node current = front;
        Node previous= null;

        if(current==null)
        {
            return;
        }

        if(current!=null && current.data==key){
            front=current.next;
            return;
        }

        while (current!=null && current.data!=key){  // Here we are going till current hence we need previous
            previous=current;
            current=current.next;
        }

        previous.next=current.next;
    }

    public void deleteAt(int index){
        if(index==0){
            front=front.next;
        }
        else{
            Node current=front;
            Node next=null;

            for(int i=0;i<index -1;i ++){   // Here we are going till previous index only in current. when we are playing with index use for loop
                current=current.next;
            }

            //next=current.next;
            System.out.println(" node is deleted : " + current.next.data);
            current.next=current.next.next;
            next=null;
        }
    }

    public void removeDuplicate(){
        if(front==null){
            return;
        }
        Node current = front;
        while (current!=null && current.next!=null){
            if(current.data==current.next.data){
                current.next=current.next.next;
            }
            else {
                current=current.next;
            }
        }

    }

    public void reverse(){
        if(front==null){
            return ;
        }

        Node current=front;
        Node previous=null;
        Node nextOne = null;
        while (current!=null){
            nextOne=current.next;  //1

            current.next=previous;  //2

            previous=current;
            current=nextOne;
        }

        front=current;
    }

    public void createALoopInLinkedList(){
        Node first = new Node(1);
        Node second= new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth= new Node(6);

        front = first;
        first.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;
        fifth.next=sixth;
        sixth.next=third;
    }

    public boolean containsLoop(){
        Node fastPtr = front;
        Node slowPtr = front;

        while(fastPtr != null && fastPtr.next!= null){
            fastPtr= fastPtr.next.next;
            slowPtr=slowPtr.next;

            if(slowPtr==fastPtr)
                return true;
        }

        return false;
    }


    public static void main(String[] args){
        List obj= new List();
        obj.add(5);
        obj.add(4);
        obj.add(3);
        obj.add(2);
        obj.add(1);

        obj.display();

        System.out.println("Length of linked list is : "+ List.length() ) ;
        obj.addAtStart(99);
        obj.addAtIndex(1,22);
        obj.deleteAt(1);
        obj.deleteNode(2);
        obj.removeDuplicate();

        obj.display();

        obj.reverse();    //This didn't work
        obj.display();
        System.out.println("------------------> Now we are creating new linked list with loop and head changes <-------------------");
        obj.createALoopInLinkedList();
        System.out.println("Contains a loop: "+obj.containsLoop());

    }



}
