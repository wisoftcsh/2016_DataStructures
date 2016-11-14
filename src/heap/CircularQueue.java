package heap;

public class CircularQueue {
    Data queueArray[];
    int currentCount;
    int front;
    int rear;

    public CircularQueue(int queueSize) {
        queueArray = new Data[queueSize];
        front = 0;
        rear = -1;
        currentCount = 0;
    }

    private void assignmentQueue() {
        Data tmpQueue[] = new Data[queueArray.length * 2];
        for (int i = front, j = 0; i < front + currentCount; i++) {
            tmpQueue[j++] = queueArray[i % queueArray.length];
        }
        front = 0;
        rear = queueArray.length - 1;
        queueArray = tmpQueue;
    }

    public void enQueue(Data data) {
        if (isFull()) {
            assignmentQueue();
        }
        rear = (rear + 1) % queueArray.length;
        queueArray[rear] = data;
        currentCount++;
    }

    public Data deQueue() {
        if (isEmpty()) {
            return null;
        }
        Data tmpData = queueArray[front];
        queueArray[front] = null;
        front = (front + 1) % queueArray.length;
        currentCount--;
        return tmpData;
    }

    public Data peek() {
        if (isEmpty()) {
            return null;
        }
        return queueArray[front];
    }

    public void printQueue() {
        System.out.println("------------------------------ Queue ------------------------------");
        for (int i = front; i < front + currentCount; i++) {
            System.out.print(queueArray[i % queueArray.length] + " ");
        }
        System.out.println();
        System.out.println("r = " + rear);
        System.out.println("f = " + front);
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
