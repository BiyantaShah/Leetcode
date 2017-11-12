package fullTime;

import java.util.Arrays;

/**
 * Created by Biyanta on 16/09/17.
 */
public class BinaryHeap {

    int heapSize;
    int[] heap;

    public BinaryHeap(int capacity) {


        heapSize = 0;
        heap = new int[capacity];
        Arrays.fill(heap, -1);
    }

    public static void main (String[] args) {
        BinaryHeap bh = new BinaryHeap(10);

        bh.insert(24);
        bh.insert(6);
        bh.insert(28);
        bh.insert(5);
        bh.insert(63);
        bh.insert(19);
        bh.insert(94);


        for (int i = 0; i < bh.heapSize; i++) {
            System.out.print(bh.heap[i] + " ");
        }
        System.out.println();
        System.out.println("Min is "+ bh.extractMin() );
        System.out.println("Size of heap "+ bh.heapSize);
        for (int i = 0; i < bh.heapSize; i++) {
            System.out.print(bh.heap[i] + " ");
        }

        System.out.println();
        System.out.println("Min is "+ bh.extractMin() );
        System.out.println("Size of heap "+ bh.heapSize);
        for (int i = 0; i < bh.heapSize; i++) {
            System.out.print(bh.heap[i] + " ");
        }



    }

    private int extractMin() {

        int item = heap[0];

        heap[0] = heap[heapSize-1];
        heapSize --;

        heapifyDown(0);



        return item;
    }

    private void heapifyDown(int index) {

        int tmpIndex = 0;
        if (index > heapSize - 1 && heap[index] == -1)
            return;
        if ((2*index)+ 2 > heapSize-1)
            return;

        int left = heap[(2*index)+ 1];
        int right = heap[(2*index)+ 2];

        if (left < right && left >=0)
            tmpIndex = (2*index)+ 1;
        else if (right < left && right >= 0)
            tmpIndex = (2*index)+ 2;
        else
            return;

        while (heap[tmpIndex] < heap[index]) {
            int tmp = heap[index];
            heap[index] = heap[tmpIndex];
            heap[tmpIndex] = tmp;

            heapifyDown(tmpIndex);
        }

    }

    private void insert(int item) {

        if (heapSize == heap.length) {
            System.out.println("heap is filled beyond capacity");
            return;
        }
        heap[heapSize] = item;
        heapSize += 1;
        heapifyUp(heapSize - 1);
    }

    private void heapifyUp(int index) {

        int temp = heap[index];

        while (index > 0  && heap[parent(index)] > temp) {
            // find the parent, if parent is greater than temp then do swap
            heap[index] = heap[parent(index)];
            index = parent(index);
        }
        heap[index] = temp;
    }

    private int parent(int index) {
        return (index-1)/2;
    }
}
