package tree;

/**
 * Created by csh9196 on 2016-11-08.
 */
public class TreeEx {
    public static void main(String[] args){
        Tree tree = new Tree();

        tree.makeRootNode(new Node(new Data(1)));

        tree.addLeftNode(tree.getRootNode(), new Node(new Data(2)));
        tree.addRightNode(tree.getRootNode(), new Node(new Data(3)));

        tree.addLeftNode(tree.getRootNode().getLeftNode(), new Node(new Data(4)));
        tree.addRightNode(tree.getRootNode().getLeftNode(), new Node(new Data(5)));

        tree.addLeftNode(tree.getRootNode().getRightNode(), new Node(new Data(6)));
        tree.addRightNode(tree.getRootNode().getRightNode(), new Node(new Data(7)));

        tree.printTree();
        System.out.println();
        Circuit circuit = new Circuit(tree);
        circuit.preorderTraversal(tree.getRootNode());
        System.out.println();
        circuit.inorderTraversal(tree.getRootNode());
        System.out.println();
        circuit.postorderTraversal(tree.getRootNode());
        System.out.println();
        circuit.levelTraversal(tree.getRootNode());
    }
}
