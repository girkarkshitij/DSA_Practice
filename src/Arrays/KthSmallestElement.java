import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 20, 15};
        System.out.println(kthSmallest(arr, 0, arr.length-1, 4));
    }

    public static int kthSmallest(int[] arr, int l, int r, int k) {
        // PriorityQueue is min-heap, to change it into max-heap, use Collections.reverseOrder()
        
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(20, Collections.reverseOrder());
        for (int i = 0; i < r; i++) {
            priorityQueue.add(arr[i]);
            if (priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }
        return priorityQueue.poll();
    }
}
