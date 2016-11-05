package circularQueue;

public class CircularQueue {
    Data queueArray[];
    int currentCount;
    int front;
    int rear;

    CircularQueue(int queueSize) {
        queueArray = new Data[queueSize];
        front = -1;
        rear = -1;
        currentCount = 0;
    }

    public void enQueue(Data data) {
        if (isFull()) {
            return;
        }
        rear = (rear + 1) % queueArray.length;
        queueArray[rear] = data;
        currentCount++;
    }

    public Data deQueue() {
        if (isEmpty()) {
            return null;
        }
        front = (front + 1) % queueArray.length;
        Data tmpData = queueArray[front];
        queueArray[front] = null;
        currentCount--;
        return tmpData;
    }

    public Data peek() {
        if(isEmpty()){
            return null;
        }
        return queueArray[front + 1];
    }

    public void printQueue() {
        int tmpFront = front;
        System.out.println("------------------------------ Queue ------------------------------");
        while (tmpFront != rear) {
            tmpFront = (tmpFront + 1) % queueArray.length;
            System.out.print(queueArray[tmpFront] + " ");
        }
        System.out.println();
        System.out.println("--------------------------------------------------------------------");
    }

    public boolean isFull() {
        if (currentCount == queueArray.length) {
            System.out.println("Queue is full");
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (currentCount == 0) {
            System.out.println("Queue is empty");
            return true;
        }
        return false;
    }
}
