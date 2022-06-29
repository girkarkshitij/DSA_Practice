class HelloWorld {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);  // Stack is full
        stack.peek();   // 4
        stack.pop();    // 4
        stack.pop();    // 3  
        stack.pop();    // 2   
        stack.pop();    // 1
    }
}

class Stack{
    int[] stack;
    int top;
    int size;

    public Stack(int size){
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    public void push(int x){
        if (isFull())
            System.out.println("Stack is full\n");
        else
            stack[++top] = x;
    }

    public void pop(){
        if (isEmpty())
            System.out.println("Stack is empty\n");
        else
            System.out.println(stack[top--]);
    }

    public void peek(){
        if (isEmpty())
            System.out.println("Stack is empty");
        else
            System.out.println(stack[top]);
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == size-1;
    }
}
