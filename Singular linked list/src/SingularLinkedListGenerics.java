public class SingularLinkedListGenerics<T> {


    Node<T> head;  // Head node to hold the list
    int length;

        public SingularLinkedListGenerics() {
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

            int count=0;
            Node<T> current=head;

            while (current.next!=null){
                count++;
                current=current.next;
            }

            return count;
        }

        public void display(){

            if(head==null){
                return;
            }
            Node<T> current=head;
            // loop each element till end of the list
            // last node points to null

            while(current != null){
                System.out.println(current.data + "--> "); // print current element data
                // move to next element
                current= current.next;
            }

            System.out.println(current); // here current will be null

        }

        private static class Node<T>{    // --------------------------- Node class --------------------------
            private T data;
            private Node<T> next;

            public Node(T data){
                this.data=data;
                this.next=null;
            }

        }

        public void insert(T data){
            Node<T> node= new Node<T>(data);
            if(head==null){
                head=node;
            }
            else {
                Node<T> current= head;
                while (current.next!=null){
                    current=current.next;
                }
                current.next=node;
            }
            length++;
        }

        public void insertAtStart(T data){
            Node<T> node= new Node<T>(data);
            node.next=head;
            head=node;
            length++;
        }

        public void insertAtIndex(int index,T data){
            Node<T> node= new Node<T>(data);
            if(index==0){
                insertAtStart(data);
            }
            else
            {
                Node<T> current= head;
                for(int i=0;i<index-1;i++){
                    current=current.next;
                }

                node.next=current.next;
                current.next=node;
            }
        }

        public void deleteAt(int index){
            if(index==0){
                head=head.next;
            }
            else{
                Node<T> current=head;
                Node<T> next=null;

                for(int i=0;i<index -1;i ++){
                    current=current.next;
                }

                //next=current.next;
                System.out.println(" node is deleted : " + current.next.data);
                current.next=current.next.next;
                next=null;
            }
        }

        public void deleteNode(T key){
            Node<T> current = head;
            Node<T> previous= null;

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
        }

        public void removeDuplicate(){
            if(head==null){
                return;
            }
            Node<T> current = head;
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
            if(head==null){
                return ;
            }

            Node<T> current=head;
            Node<T> previous=null;
            Node<T> nextOne = null;
            while (current!=null){
                nextOne=current.next;
                current.next=previous;
                previous=current;
                current=nextOne;
            }

            head=previous;
        }


        public void createALoopInLinkedList(){
            Node<Integer> first = new Node<Integer>(1);
            Node<Integer> second= new Node<Integer>(2);
            Node<Integer> third = new Node<Integer>(3);
            Node<Integer> fourth = new Node<Integer>(4);
            Node<Integer> fifth = new Node<Integer>(5);
            Node<Integer> sixth= new Node<Integer>(6);

            head = (Node<T>) first;
            first.next=second;
            second.next=third;
            third.next=fourth;
            fourth.next=fifth;
            fifth.next=sixth;
            sixth.next=third;
        }

        public boolean containsLoop(){
            Node<T> fastPtr = head;
            Node<T> slowPtr = head;

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

            //Node<Integer> first = new Node<Integer>(10);
            //head=first;
            //Node second= new Node(8);
            //Node third = new Node(1);
            //Node fourth = new Node(11);

            // Attach them together to form a list

            //first.next= second;
            //second.next= third;
            //third.next=fourth;
            //fourth.next= null;

            SingularLinkedListGenerics<Integer> obj = new SingularLinkedListGenerics<Integer>();
            obj.insert(1);
            obj.insert(2);
            obj.insert(3);
            obj.insert(3);
            //obj.length();
            System.out.println("Length of linked list is : "+ (obj.getLength() + 1 )) ;
            obj.insertAtStart(99);
            obj.insertAtIndex(1,22);
            obj.deleteAt(1);
            obj.deleteNode(2);
            obj.removeDuplicate();
            obj.display();
            obj.reverse();   // This didn't work
            obj.display();
            System.out.println("------------------> Now we are creating new linked list with loop and head changes <-------------------");
            //obj.createALoopInLinkedList();
            System.out.println("Contains a loop: "+obj.containsLoop());


        }


}



