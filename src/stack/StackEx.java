package stack;

public class StackEx {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.createStack(10);

        stack.push(new Node(new Data(3)));
        stack.push(new Node(new Data(4)));
        stack.push(new Node(new Data(5)));

        stack.printStack();

        stack.push(new Node(new Data(1)));

        stack.printStack();

        stack.pop();

        stack.printStack();

        stack.push(new Node(new Data(6)));

        stack.peek();

        stack.printStack();

        stack.deleteStack();

        stack.printStack();
    }
}
