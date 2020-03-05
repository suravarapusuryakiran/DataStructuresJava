package list;

// enqueue - insertion
// dequeue - deletion

public class ArrayQueue {

    public static void main(String[] args){
        Queue obj = new Queue();
        obj.enQueue(5);
        obj.enQueue(10);
        obj.deQueue();
        obj.deQueue();
        obj.deQueue();
        obj.show();

    }

}


class Queue{
    int capacity=5;
    int[] queue = new int[capacity];
    int size=0,front=0,rear=0;

    public int getSize()
    {
        return size;
    }

    public boolean isEmpty() {
        return getSize()==0;
    }

    public boolean isFull(){
        return getSize()==capacity;
    }

    public void enQueue(int data){

        if(!isFull()) {
            queue[rear] = data;
            rear = (rear + 1) % capacity;
            size = size + 1;
        }else {
            System.out.println("Queue is full");
        }
    }

    public int deQueue(){
        int data=queue[front];

        if(!isEmpty()) {
            front = (front + 1) % 5;
            size = size - 1;

        }else {
            System.out.println("Queue is Empty");
        }
        return data;
    }


    public void show(){
        if(isEmpty()){
            System.out.println("Queue is empty no elements to show");
        }else {

            System.out.println("Queue Elements are: ");
            for (int i = 0; i < size; i++) {
                System.out.println(queue[(front + i) % capacity] + "");
            }
        }
    }

}
