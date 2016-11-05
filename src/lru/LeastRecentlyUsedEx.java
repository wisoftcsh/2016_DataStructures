package lru;

/**
 * Created by csh9196 on 2016-10-04.
 */
public class LeastRecentlyUsedEx {
    public static void main(String[] args) {
        LruStack lruStack = new LruStack(new Frame(5));
        lruStack.push(new Node(0), new Data(1));
        lruStack.printStack();

        lruStack.push(new Node(1), new Data(2));
        lruStack.printStack();

        lruStack.push(new Node(2), new Data(4));
        lruStack.printStack();

        lruStack.push(new Node(3), new Data(8));
        lruStack.printStack();

        lruStack.push(new Node(4), new Data(10));
        lruStack.printStack();

        lruStack.push(new Node(1), new Data(2)); // 1번 페이지에 같은 데이터일 때
        lruStack.printStack();

        lruStack.push(new Node(5), new Data(15));
        lruStack.printStack();

        lruStack.push(new Node(3), new Data(4)); // 3번 페이지에 다른 데이터일 때
        lruStack.printStack();

        lruStack.push(new Node(0), new Data(1));
        lruStack.printStack();

        lruStack.push(new Node(0), new Data(1));
        lruStack.printStack();

        lruStack.push(new Node(9), new Data(9));
        lruStack.printStack();
    }
}
