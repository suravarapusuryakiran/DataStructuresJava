public class SingluarLinkedList {

    private static Node head;  // Head node to hold the list
    private static int length;

    public SingluarLinkedList() {
        this.head = null;
        this.length = 0;

    }

    public boolean isEmpty() {
        return length == 0;  // return true if length is ==0
    }

    public int length() {
        return length;
    }

    public int getLength(){
        if(head==null){
            return 0;
        }

        int count=1;
        Node current=head;

        while (current.next!=null){
            count++;
            current=current.next;
        }

        return count;
    }

    public void display(){

        if(head==null){
            return ;
        }
        Node current=head;
        // loop each element till end of the list
        // last node points to null

        while(current != null){
            System.out.println(current.data + "--> "); // print current element data
            // move to next element
            current= current.next;
        }

        System.out.println(current); // here current will be null

    }

    private static class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }

    }

    public void insert(int data){
        Node node= new Node(data);   // Remember this point
        if(head==null){
            head=node;
        }
        else {
            Node current= head;
            while (current.next!=null){
                current=current.next;
            }
            current.next=node;
        }
        length++;
    }

    public void insertAtStart(int data){
        Node node= new Node(data);
        node.next=head;
        head=node;
        length++;
    }

    public void insertAtIndex(int index,int data){
        Node node= new Node(data);
        if(index==0){
            insertAtStart(data);
        }
        else
        {
            Node current= head;
            for(int i=0;i<index-1;i++){
                current=current.next;
            }

            node.next=current.next;   //     or  temp=current.next; current.next=node and node.next=temp;
            current.next=node;
        }
    }

    public void deleteAt(int index){
        if(index==0){
            head=head.next;
        }
        else{
            Node current=head;
            Node next=null;

            for(int i=0;i<index -1;i ++){
                current=current.next;
            }

            //next=current.next;
            System.out.println(" node is deleted : " + current.next.data);
            current.next=current.next.next;
            //next=null;
            length --;
        }
    }

    public void deleteNode(int key){
        Node current = head;
        Node previous= null;

        if(current==null)
        {
            return;
        }

        if(current!=null && current.data==key){
            head=current.next;
            return;
        }

        while (current!=null && current.data!=key){
            previous=current;
            current=current.next;
        }


        previous.next=current.next;
        length --;
    }

    public void removeDuplicate(){
        if(head==null){
            return;
        }
        Node current = head;
         while (current!=null && current.next!=null){
             if(current.data==current.next.data){
                 current.next=current.next.next;
                 length --;
             }
             else {
                 current=current.next;
             }
         }
    }

    public void reverse(){
        if(head==null){
            return ;
        }

        Node current=head;
        Node previous=null;
        Node nextOne = null;
        while (current!=null){
            nextOne=current.next;
            current.next=previous;
            previous=current;
            current=nextOne;
        }

        head=previous;
    }


    public void createALoopInLinkedList(){
        Node first = new Node(1);
        Node second= new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth= new Node(6);

        head = first;
        first.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;
        fifth.next=sixth;
        sixth.next=third;
    }

    public boolean containsLoop(){
        Node fastPtr = head;
        Node slowPtr = head;

        while(fastPtr != null && fastPtr.next!= null){
            fastPtr= fastPtr.next.next;
            slowPtr=slowPtr.next;

            if(slowPtr==fastPtr)
                return true;
        }

        return false;
    }



    public static void main(String[] args){
        // Lets create linked list demonstrated in slide
        // 10 -> 8 -> 1 --> 11 --> null
        // 10 as head node of linked list

        //Node first = new Node(10);
        //head=first;
        //Node second= new Node(8);
        //Node third = new Node(1);
        //Node fourth = new Node(11);

        // Attach them together to form a list

        //first.next= second;
        //second.next= third;
        //third.next=fourth;
        //fourth.next= null;

        SingluarLinkedList  obj = new SingluarLinkedList();
        obj.insert(1);
        obj.insert(2);
        obj.insert(3);
        obj.insert(3);
        //obj.length();
        System.out.println("Length of linked list is : "+ obj.getLength() ) ;
        System.out.println("Length of linked list is : "+ SingluarLinkedList.length ) ;
        obj.insertAtStart(99);
        obj.insertAtIndex(1,22);
        obj.deleteAt(1);
        obj.deleteNode(2);
        obj.removeDuplicate();
        obj.display();
        obj.reverse();   // Worked heeay!
        obj.display();
        System.out.println("------------------> Now we are creating new linked list with loop and head changes <-------------------");
        obj.createALoopInLinkedList();
        System.out.println("Contains a loop: "+obj.containsLoop());


    }

}
