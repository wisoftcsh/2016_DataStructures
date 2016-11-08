package tree;

public class CircularQueue {
    Node queueArray[];
    int currentCount;
    int front;
    int rear;

    public CircularQueue(int queueSize) {
        queueArray = new Node[queueSize];
        front = 0;
        rear = -1;
        currentCount = 0;
    }

    public void printQueue() {
        System.out.println("------------------------------ Queue ------------------------------");
        for (int i = front; i < front + currentCount; i++) {
            System.out.print(queueArray[i % queueArray.length].getData() + " ");
        }
        System.out.println();
        System.out.println("r = " + rear);
        System.out.println("f = " + front);
        System.out.println("--------------------------------------------------------------------");
    }

//    public void assignmentQueue() {
//        Data tmpQueue[] = new Data[queueArray.length * 2];
//        for (int i = front, j = 0; i < front + currentCount; i++) {
//            tmpQueue[j++] = queueArray[i % queueArray.length];
//        }
//        front = 0;
//        rear = queueArray.length - 1;
//        queueArray = tmpQueue;
//    }

    public void enQueue(Node node) {
        if (isFull()) {
//            assignmentQueue();
            return;
        }
        rear = (rear + 1) % queueArray.length;
        queueArray[rear] = node;
        currentCount++;
    }

    public Node deQueue() {
        if (isEmpty()) {
            return null;
        }
        Node tmpData = queueArray[front];
        queueArray[front] = null;
        front = (front + 1) % queueArray.length;
        currentCount--;
        return tmpData;
    }

    public Node peek() {
        if (isEmpty()) {
            return null;
        }
        return queueArray[front];
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
