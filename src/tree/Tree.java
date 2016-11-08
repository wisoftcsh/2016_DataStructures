package tree;

/**
 * Created by csh9196 on 2016-11-08.
 */
public class Tree {
    private RootNode rootNode;

    public Tree(){
        rootNode = new RootNode();
    }

    public void makeRootNode(Node newNode){
        rootNode.setRootNode(newNode);
    }

    public void addLeftNode(Node preNode, Node newNode){
        preNode.setLeftNode(newNode);
    }

    public void addRightNode(Node preNode, Node newNode){
        preNode.setRightNode(newNode);
    }

    public Node getRootNode(){
        return rootNode.getRootNode();
    }

    public void printTree(){
        System.out.println("     "  + getRootNode().getData().toString());
        System.out.print("  " + getRootNode().getLeftNode().getData().toString());
        System.out.println("   " + getRootNode().getRightNode().getData().toString());
        System.out.print(getRootNode().getLeftNode().getLeftNode().getData().toString());
        System.out.print(" " + getRootNode().getLeftNode().getRightNode().getData().toString());
        System.out.print(" " + getRootNode().getRightNode().getLeftNode().getData().toString());
        System.out.println(" " + getRootNode().getRightNode().getRightNode().getData().toString());
    }

}
