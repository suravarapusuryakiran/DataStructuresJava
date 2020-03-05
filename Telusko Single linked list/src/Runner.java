
public class Runner {
         public static void main(String[] args){

              LinkedList list= new LinkedList(); // Use internal LinkedList class for linkedlist
             list.insert(18);
             list.insert(45);
             list.insert(12);
             list.insertAtStart(25);
             list.insertAt(0,55);
             list.deleteAt(2);
             list.show();
             System.out.println(list.head);
             System.out.println("Length of linked lis is : " + list.length());
             System.out.println("Contains loop"+ list.containsLoop());

         }

}
