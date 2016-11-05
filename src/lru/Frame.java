package lru;

public class Frame {
    private int maxFrame;
    private Data[] frameArray;

    Frame(){}
    Frame(int maxFrame){
        this.maxFrame = maxFrame;
        frameArray = new Data[maxFrame];
    }

    public boolean isFull() {
        int count=0;
        for(int i = 0 ; i < maxFrame ; i++){
            if(frameArray[i] != null){
                count++;
            }
        }
        if (count == maxFrame) {
            System.out.println("frame is full");
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (frameArray.length == 0) {
            System.out.println("frame is empty");
            return true;
        }
        return false;
    }

    public int findNullIndex(){
        for(int i = 0; i < frameArray.length ; i++){
            if(frameArray[i]==null){
                return i;
            }
        }
        System.out.println("인덱스 정보 오류");
        return -1;
    }

    public void addFrame(Data data, int index){
        frameArray[index] = data;
    }

    public int getMaxFrame(){
        return maxFrame;
    }

    public Data getFrameData(int index){
        return frameArray[index];
    }

    public Data[] getFrameArray(){
        return frameArray;
    }

    public void printFrame(){
        System.out.println("------ Frame -------");
        for(int i=0 ; i < maxFrame ; i++){
            if(frameArray[i] != null){
                System.out.print(frameArray[i].toString()+ "  ");
            }
        }
        System.out.println();
        System.out.println("--------------------");
    }
}
