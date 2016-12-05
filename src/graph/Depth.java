package graph;

/**
 * Created by csh9196 on 2016-11-27.
 */

public class Depth {
    private LinkedList[] linkedList;

    Depth(Graph graph) {
        this.linkedList = graph.getLinkedList();
    }

    public void search(int index){
        depthFirstSearch(index);
        for(int i = 0 ; i < linkedList.length ; i++){ //혹시 정보가 없는 노드가 있다면
            if(!linkedList[i].getHeaderNode().getSearchFlag()){ // == false
                depthFirstSearch(i);
            }
        }
    }

    public void depthFirstSearch(int index) {
        if (index == -1) {
            System.out.println("인덱스 오류");
            return;
        }
        Node tmpNode;
        tmpNode = linkedList[index].getHeaderNode();
        if (tmpNode.getNextNode() == null) { // 간선이 없는 노드 처리
            System.out.println(linkedList[index].getHeaderNode().getData() + " 를 방문");
            linkedList[index].getHeaderNode().setSearchFlag(true);
            index++;
            depthFirstSearch(index % linkedList.length);
            return;
        }
        while (tmpNode.getNextNode() != null) {
            tmpNode = tmpNode.getNextNode();
            if(tmpNode.getSearchFlag() || tmpNode == null){
                return;
            }
            tmpNode.setSearchFlag(true);
            if (!linkedList[index].getHeaderNode().getSearchFlag()) { // == false
                System.out.println(linkedList[index].getHeaderNode().getData() + " 를 방문");
                linkedList[index].getHeaderNode().setSearchFlag(true);
                String tmpString = tmpNode.getData().toString();
                index = searchIndex(tmpString);
                depthFirstSearch(index % linkedList.length);
            }else {
                String tmpString = tmpNode.getData().toString();
                index = searchIndex(tmpString);
                depthFirstSearch(index % linkedList.length);
            }
        }
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
