package circularQueue;

public class CircularQueueEx {
    public static void main(String []args){
        CircularQueue circularQueue = new CircularQueue(2);

        circularQueue.enQueue(new Data("최선호"));
        circularQueue.printQueue();

        circularQueue.enQueue(new Data("김남준"));
        circularQueue.printQueue();

        circularQueue.enQueue(new Data("이수빈"));
        circularQueue.printQueue();

        circularQueue.enQueue(new Data("서보민"));
        circularQueue.printQueue();

        circularQueue.enQueue(new Data("한상혁"));
        circularQueue.printQueue();

        circularQueue.enQueue(new Data("이근혁"));
        circularQueue.printQueue();


        System.out.println(circularQueue.peek());

        circularQueue.deQueue();
        circularQueue.printQueue();

        System.out.println(circularQueue.peek());

        circularQueue.enQueue(new Data("이성원"));
        circularQueue.printQueue();

        circularQueue.enQueue(new Data("안덕기"));
        circularQueue.printQueue();

        circularQueue.enQueue(new Data("최선호"));
        circularQueue.printQueue();

        circularQueue.enQueue(new Data("김남준"));
        circularQueue.printQueue();

        circularQueue.enQueue(new Data("이수빈"));
        circularQueue.printQueue();

        circularQueue.enQueue(new Data("서보민"));
        circularQueue.printQueue();

        circularQueue.enQueue(new Data("한상혁"));
        circularQueue.printQueue();

        circularQueue.enQueue(new Data("이근혁"));
        circularQueue.printQueue();


        circularQueue.deQueue();
        circularQueue.printQueue();
        circularQueue.deQueue();
        circularQueue.printQueue();
        circularQueue.deQueue();
        circularQueue.printQueue();
        circularQueue.deQueue();
        circularQueue.printQueue();
        circularQueue.deQueue();
        circularQueue.printQueue();
        circularQueue.deQueue();
        circularQueue.printQueue();
        circularQueue.deQueue();
        circularQueue.printQueue();
        circularQueue.deQueue();
        circularQueue.printQueue();
        circularQueue.deQueue();
        circularQueue.printQueue();
        circularQueue.deQueue();
        circularQueue.printQueue();
        circularQueue.deQueue();
        circularQueue.printQueue();
        circularQueue.deQueue();
        circularQueue.printQueue();
        circularQueue.deQueue();
        circularQueue.printQueue();

        circularQueue.deQueue();

    }
}
