package heap;

/**
 * Created by csh9196 on 2016-11-14.
 */
public class HeapEx {
    public static void main(String[] args) {
        Heap heap = new Heap(15);

        heap.insetHeap(new Data(10));
        heap.insetHeap(new Data(20));
        heap.insetHeap(new Data(30));
        heap.insetHeap(new Data(40));
        heap.insetHeap(new Data(50));
        heap.insetHeap(new Data(25));
        heap.insetHeap(new Data(15));
        heap.insetHeap(new Data(35));
        heap.insetHeap(new Data(5));
        heap.insetHeap(new Data(45));
        heap.insetHeap(new Data(60));
        heap.insetHeap(new Data(70));
        heap.insetHeap(new Data(65));
        heap.insetHeap(new Data(70));
        heap.insetHeap(new Data(100));
        heap.printAll();

        heap.insetHeap(new Data(111));

        System.out.println(heap.removeHeap());
        heap.printAll();

        heap.heapSort();
        heap.printAll();
    }
}
