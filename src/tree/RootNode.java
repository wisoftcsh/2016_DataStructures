package tree;

/**
 * Created by csh9196 on 2016-11-08.
 */
public class RootNode {
    private Node rootNode;

    public RootNode() { // 더미노드
        this.rootNode = null;
    }

    public void setRootNode(Node rootNode) {
        this.rootNode = rootNode;
    }

    public Node getRootNode() {
        return rootNode;
    }
}
