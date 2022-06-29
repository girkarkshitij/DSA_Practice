class HelloWorld {
    public static void main(String[] args) {
        Queue queue = new Queue(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);   //Queue is full
        queue.dequeue();   //1
        queue.dequeue();   //2
        queue.dequeue();   //3
        queue.dequeue();   //Queue is empty
    }
}

class Queue {
    int[] queue;
    int front, rear;
    int size;
    
    public Queue(int size){
        this.size = size;
        queue = new int[size];
        front = -1;
        rear = -1;
    }
    
    public void enqueue(int val){
        if(!isFull()){
            if(front == -1)
                front++;
            queue[++rear] = val;
        }else{
            System.out.println("Queue is already full");  
        }
    }
    
    public void dequeue(){
        if(!isEmpty()){
            if(front == rear){
                System.out.println(queue[front]);
                front = -1;
                rear = -1;
            }else{
                System.out.println(queue[front++]);
            }
        }else{
            System.out.println("Queue is empty");
        }
    }
    
    public boolean isFull(){
        return rear == size-1;
    }
    
    public boolean isEmpty(){
        return front == -1;
    }
}
