class Main {
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(10);
        heap.insert(50);
        heap.insert(10);
        heap.insert(20);
        heap.insert(30);
        heap.insert(35);
        heap.insert(45);
        heap.insert(13);
        
        heap.printHeap();
        /**
         * 50 35 45 10 30 20 13
         *          50
         *       /    \
         *     35      45
         *   /   \    /  \
         * 10    30  20   13
         */

        heap.remove();
        
        heap.printHeap();
        /**
         * 45 35 20 10 30 13
         *          45
         *      /     \
         *     35     20
         *   /   \   /  
         *  10   30 13
         */
    }
}

class MaxHeap {
    private int[] heap;
    private int currSize;
    private int maxSize;

    public MaxHeap(int maxSize){
        this.maxSize = maxSize;
        this.currSize = 0;
        heap = new int[maxSize+1];
    }

    public void insert(int value){
        heap[++currSize] = value;

        int curr = currSize;

        while(curr > 1){
            int tempParent = parent(curr);

            if(heap[tempParent] < heap[curr]){
                swap(tempParent, curr);
                curr = tempParent;
            }else{
                return;
            }
        }
    }

    public void remove(){
        heap[1] = heap[currSize--];

        int curr = 1;

        while(curr <= currSize/2){
            int left = leftChild(curr);
            int right = rightChild(curr);
            int larger = 0;
            if(left == -1 && right == -1){
                return;
            }else if (left == -1){
                larger = right;
            }else if (right == -1){
                larger = left;
            }else{
                larger = heap[left] > heap[right] ? left : right;
            }

            if(heap[curr] < heap[larger]){
                swap(curr,larger);
                curr = larger;
            }else{
                return;
            }
        }
    }

    public void printHeap(){
        for (int i = 1; i <= currSize; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    private int parent(int node){
        return node/2;
    }

    private int leftChild(int node){
        int left = 2*node;
        if(left > currSize)
            return -1;
        return left;
    }

    private int rightChild(int node){
        int right =  2*node+1;
        if (right > currSize)
            return -1;
        return right;
    }

    private void swap(int source, int target){
        int temp = heap[source];
        heap[source] = heap[target];
        heap[target] = temp;
    }
}
