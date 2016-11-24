package graph;

import java.util.HashMap;

/**
 * Created by csh9196 on 2016-11-22.
 */
public class Graph {
    private LinkedList[] linkedList;

    public Graph(int nodeCount) {
        if (nodeCount > 0) {
            linkedList = new LinkedList[nodeCount];
        } else {
            System.out.println("0보다 큰 숫자를 입력해주세요");
        }
    }

    public void createGraphNode(Data data){
        int i = 0;
        while(i < linkedList.length){
            if(linkedList[i] == null){
                linkedList[i] = new LinkedList(data);
                break;
            }
            i++;
        }
    }

    public void addEdge(Object from, Object to) {
        String tmpFrom = from+""; // format 형식 맞추기
        String tmpTo = to+"";
        for(int i = 0 ; i < linkedList.length ; i++){
            if(linkedList[i].getGraphData().toString().equals(tmpFrom)){ //toString을 안쓰면 왜 안돌아 갈까??
                linkedList[i].addData(new Node(new Data(tmpTo)));
                break;
            }
        }
    }

    public void removeEdge(Object from, Object to) {
        String tmpFrom = from+""; // format 형식 맞추기
        String tmpTo = to+"";
        for(int i = 0 ; i < linkedList.length ; i++){
            if(linkedList[i].getGraphData().toString().equals(tmpFrom)){
                linkedList[i].removeData(new Data(tmpTo));
                break;
            }
        }
    }

    public void printAll(){
        System.out.println("---------------- 그래프 정보 ----------------");
        for(int i = 0 ; i < linkedList.length ; i++){
            System.out.print(linkedList[i].getGraphData() + " : ");
            linkedList[i].printAll();
            System.out.println();
        }
    }
}
