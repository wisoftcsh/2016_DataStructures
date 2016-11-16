package heap;

/**
 * Created by csh9196 on 2016-11-14.
 */
public class HeapEx {
    public static void main(String[] args) {
        Heap heap = new Heap(15);

        heap.insertHeap(new Data(10));
        heap.insertHeap(new Data(20));
        heap.insertHeap(new Data(30));
        heap.insertHeap(new Data(40));
        heap.insertHeap(new Data(50));
        heap.insertHeap(new Data(25));
        heap.insertHeap(new Data(15));
        heap.insertHeap(new Data(35));
        heap.insertHeap(new Data(5));
        heap.insertHeap(new Data(45));
        heap.insertHeap(new Data(60));
        heap.insertHeap(new Data(70));
        heap.insertHeap(new Data(65));
        heap.insertHeap(new Data(70));
        heap.insertHeap(new Data(100));
        heap.printAll();

        heap.insertHeap(new Data(111));

        System.out.println(heap.removeHeap());
        heap.printAll();
        System.out.println();
        heap.heapSort();
        heap.printAll();
    }
}
