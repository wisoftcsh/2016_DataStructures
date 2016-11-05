package stack;

public class Stack {
    int currentCount;
    int maxStack;
    Node top; // currentCount-1 and tail 과 같은 의미
    Node delStack;
    Node stack;


    public Stack() {
    }

    public void createStack(){
        stack = new Node(); //더미노드가 만들어짐
        currentCount = 0;
        top = stack;
    }
    public void createStack(int stackMax) { // 맥스 스택의 의미는 메모리가 정말 부족한 경우,
        //스택의 장점은 max가 없다는 것
        stack = new Node(); //더미노드가 만들어짐
        currentCount = 0;
        this.maxStack = stackMax;
        top = stack;
    }

    public void push(Node newStack) {
        if (!isFull()) {
            top.setNextPointer(newStack);
            newStack.setPrePointer(top);
            newStack.setNextPointer(stack);
            stack.setPrePointer(newStack);
            top = newStack;
            currentCount++;
            System.out.println(newStack.getData().toString() + " ---> push 성공");
        }
    }

    public Node pop() {
        if (!isEmpty()) {
            delStack = top;
            top = top.getPrePointer();
            top.setNextPointer(null); // 메모리 반환
            currentCount--;
            System.out.println(delStack.getData().toString() + " ---> pop 성공");
            return delStack;
        }
        return null;
    }

    public Node peek() {
        if (!isEmpty()) {
            return top;
        }
        return null;
    }

    public void deleteStack() {
        top = null;
        stack = null;
    }

    public void printStack() {
        Node tmpTop = top;
        if (!isEmpty()) {
            System.out.println("==================");
            for(int i = currentCount -1 ; i >=0 ; i--){
                System.out.println(tmpTop.getData().toString());
                tmpTop = tmpTop.getPrePointer();
            }
            System.out.println("==================");
        }
    }

    public boolean isFull() {
        if (currentCount == maxStack) {
            System.out.println("stack is full");
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (top == stack) {
            System.out.println("stack is empty");
            return true;
        }
        return false;
    }

    public int getCurrentCount() {
        return this.currentCount;
    }
}
