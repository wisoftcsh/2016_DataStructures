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

    public void insertHeap(Data data) {
        if (isFull()) {
            System.out.println("Heap is full !");
            return;
        }
        currentCount++;
        heapArray[currentCount] = data;
        int tmp;
        tmp = currentCount;
        while (tmp != 1 && compare(tmp, tmp / 2) > 0) {
            heapArray[tmp] = heapArray[tmp / 2];
            heapArray[tmp / 2] = data;
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
        currentCount--;

        while (child <= currentCount) {
            if (child < currentCount && // 오른쪽 노드의 존재 여부
                    compare(child, child + 1) < 0) {
                child++;
            }
            if (compare(currentCount + 1, child) >= 0) {
                break;
            }
            heapArray[parent] = heapArray[child];
            parent = child;
            child *= 2;
        }
        heapArray[parent] = tmpData;
        return rootData;
    }

    public void heapSort() {
        while (!isEmpty()) {
            heapArray[currentCount] = removeHeap();
        }
    }

    public int compare(int first, int second) {
        if (isNumber(heapArray[first].getData().toString()) && isNumber(heapArray[second].getData().toString())) {
            if (Integer.parseInt(heapArray[first].getData().toString()) >
                    Integer.parseInt(heapArray[second].getData().toString())) {
                return 1;
            } else if (Integer.parseInt(heapArray[first].getData().toString()) ==
                    Integer.parseInt(heapArray[second].getData().toString())) {
                return 0;
            } else {
                return -1;
            }
        }
        return heapArray[first].getData().toString().compareTo(heapArray[second].getData().toString());
    }

    public boolean isNumber(String string) {
        try {
            Double.parseDouble(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isFull() {
        return maxCount == currentCount;
    }

    public boolean isEmpty() {
        return currentCount == 0;
    }

    public void printAll() {
        for (int i = 1; i < currentCount + 1; i++) {
            System.out.print(heapArray[i] + " ");
        }
        System.out.println();
    }
}
