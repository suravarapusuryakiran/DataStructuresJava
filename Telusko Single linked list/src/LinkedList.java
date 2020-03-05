public class LinkedList {

    Node head;

    public  void insert(int data){
        Node node = new Node();
        node.data=data;    // assigning the data of user
        node.next=null;   // No address of next node

        if(head == null){   // For the first time head is null
            head=node;    // from second execution head wont be null, it points to node address
        }
        else {
            Node n=head;  // Here we are assigning address of previously node to n
            while(n.next!=null){  // if first block isn't null | if second block isn't null
                n=n.next;  // switching to next node | switch to next block
            }

            n.next=node;  // when you find null you assigning the address of new node we created to n(which is previous node)
        }
    }


    public void insertAtStart(int data){
        Node node = new Node();
        node.data=data;    // assigning the data of user
        node.next=null;   // No address of next node
        node.next=head;
        head=node;
    }

    public void  insertAt(int index,int data){

        Node node = new Node();
        node.data=data;    // assigning the data of user
        node.next=null;   // No address of next node

        if(index==0){
            insertAtStart(data);
        }

        else{
            Node n = head;
            for(int i=0;i<index-1;i++){
                n=n.next;
            }
            node.next=n.next;
            n.next=node;
        }

    }

    public void deleteAt(int index){
        if (index==0){
            head=head.next;
        }
        else {
            Node n = head;
            Node n1=null;
            for(int i=0;i<index-1;i++){
                n=n.next;
            }
            n1=n.next;
            n.next=n1.next;
            //System.out.println("n1" + n1.data);
            n1=null; // completely removing node from memory
        }
    }

    public void show()
    {

        Node node= head;
        while(node.next!=null){
            System.out.println(node.data);
            node=node.next; // shifting from one node to another node
        }
        System.out.println(node.data);
    }

    public int length(){
        if(head==null)
        {
            return 0;
        }
        Node n= head;
        int count=0;
        while(n.next!=null){
            count++;
            n=n.next;
        }
        return count+1;
    }

    //-----------------------------------

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

}
