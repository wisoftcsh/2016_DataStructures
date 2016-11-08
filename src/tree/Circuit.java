package tree;

public class Circuit {
    Tree tree;
    CircularQueue circularQueue;

    public Circuit(Tree tree) {
        this.tree = tree;
        circularQueue = new CircularQueue(10);
    }

    //전위
    public void preorderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.getData().toString() + " ");
            preorderTraversal(node.getLeftNode());
            preorderTraversal(node.getRightNode());
        }
    }

    //중위
    public void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.getLeftNode());
            System.out.print(node.getData().toString() + " ");
            inorderTraversal(node.getRightNode());
        }
    }

    //후위
    public void postorderTraversal(Node node) {
        if (node != null) {
            postorderTraversal(node.getLeftNode());
            postorderTraversal(node.getRightNode());
            System.out.print(node.getData().toString() + " ");
        }
    }

    //레벨
    public void levelTraversal(Node node) {
        circularQueue.enQueue(node);
        while (circularQueue.currentCount != 0) {
            Node tmpNode = circularQueue.deQueue();
            System.out.print(tmpNode.getData().toString() + " ");
            if (tmpNode.getLeftNode() == null && tmpNode.getRightNode() == null) {
                while (circularQueue.currentCount != 0) {
                    System.out.print(circularQueue.deQueue().getData().toString() + " ");
                }
                return;
            }
            if (tmpNode.getLeftNode() != null) {
                circularQueue.enQueue(tmpNode.getLeftNode());
            }
            if (tmpNode.getRightNode() != null) {
                circularQueue.enQueue(tmpNode.getRightNode());
            }
        }
    }
}
