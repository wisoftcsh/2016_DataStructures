package heap;

/**
 * Created by csh9196 on 2016-11-14.
 */
public class Heap {
    private int maxCount;
    private int currentCount;
    private Data[] heapArray;

    Heap(int maxCount) {
        heapArray = new Data[maxCount + 1]; // 1 ~ 10 개의 노드 index 0은 더미
        this.maxCount = maxCount;
        currentCount = 0;
    }

    public void insetHeap(Data data) {
        if (isFull()) {
            System.out.println("Heap is full !");
            return;
        }
        int tmp;
        currentCount++;
        tmp = currentCount;
        while (tmp != 1 && Integer.parseInt(data.getData().toString()) >
                Integer.parseInt(heapArray[tmp / 2].getData().toString())) {
            heapArray[tmp] = heapArray[tmp / 2];
            tmp /= 2;
        }
        heapArray[tmp] = data;
    }

    public Data removeHeap() {
        int parent = 1, child = 2;
        if (isEmpty()) {
            return null;
        }
        Data rootData = heapArray[1];
        Data tmpData = heapArray[currentCount];
        heapArray[currentCount] = null;
        currentCount--;

        while (child <= currentCount) {
            if (child < currentCount && // 오른쪽 노드의 존재 여부
                    Integer.parseInt(heapArray[child].getData().toString()) <
                            Integer.parseInt(heapArray[child + 1].getData().toString())) { // 자식 노드끼리 비교
                child++;
            }
            if(Integer.parseInt(tmpData.getData().toString()) >=
                    Integer.parseInt(heapArray[child].getData().toString())) { // 탈출 조건
                break;
            }
            heapArray[parent] = heapArray[child];
            parent = child;
            child *= 2;
        }
        heapArray[parent] = tmpData;
        return rootData;
    }

    public void heapSort(){
        CircularQueue circularQueue = new CircularQueue(10);
        while(currentCount != 0){
            circularQueue.enQueue(removeHeap());
        }
        while(!circularQueue.isEmpty()){
            insetHeap(circularQueue.deQueue());
        }
    }

    public boolean isFull() {
        return maxCount == currentCount;
    }

    public boolean isEmpty() {
        return currentCount == 0;
    }

    public void printAll() {
        System.out.println("                    " + heapArray[1]);
        System.out.println("           " + heapArray[2] + "                " + heapArray[3]);
        System.out.println("      " + heapArray[4] + "       " + heapArray[5] + "        " + heapArray[6] + "        " + heapArray[7]);
        System.out.println("   " + heapArray[8] + "    " + heapArray[9] + "   " + heapArray[10] + "   " + heapArray[11] + "   " + heapArray[12] + "   " + heapArray[13] + "   " + heapArray[14] + "   " + heapArray[15]);
    }
}
