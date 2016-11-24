package graph;

/**
 * Created by csh9196 on 2016-11-22.
 */
public class Data {
    private Object data;

    Data(Object data){
        this.data = data;
    }

    public void setData(Object data){
        this.data = data;
    }

    @Override
    public String toString(){
        return data + "";
    }
}
