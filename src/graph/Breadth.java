package graph;

/**
 * Created by csh9196 on 2016-11-27.
 */

public class Breadth {
    private LinkedList[] linkedList;
    private CircularQueue circularQueue;

    Breadth(Graph graph) {
        this.linkedList = graph.getLinkedList();
        circularQueue = new CircularQueue(10);
    }

    public void search(int index) {
        breadthFirstSearch(index);
        for (int i = 0; i < linkedList.length; i++) { //혹시 정보가 없는 노드가 있다면
            if (!linkedList[i].getHeaderNode().getSearchFlag()) { // == false
                breadthFirstSearch(i);
            }
        }
    }

    public void breadthFirstSearch(int index) {
        if (index > linkedList.length) {
            System.out.println("인덱스 오류");
            return;
        }
        linkedList[index].getHeaderNode().setSearchFlag(true);
        System.out.println(linkedList[index].getHeaderNode().getData() + " 를 방문");
        Node tmpNode = linkedList[index].getHeaderNode().getNextNode();
        while (tmpNode != null) {
            String tmpString = tmpNode.getData().toString();
            index = searchIndex(tmpString);
            if(!circularQueue.searchQueue(tmpNode.getData().toString()) &&
                    !linkedList[index].getHeaderNode().getSearchFlag()){
                circularQueue.enQueue(tmpNode.getData());
            }
            tmpNode = tmpNode.getNextNode();
        }
        circularQueue.printQueue();
        if(circularQueue.isEmpty()){
            return;
        }
        String tmpString = circularQueue.deQueue().toString();
        index = searchIndex(tmpString);

        breadthFirstSearch(index % linkedList.length);
    }

    public int searchIndex(String string) {
        for (int i = 0; i < linkedList.length; i++) {
            if (string.equals(linkedList[i].getHeaderNode().getData().toString())) {
                return i;
            }
        }
        return -1;
    }
}
