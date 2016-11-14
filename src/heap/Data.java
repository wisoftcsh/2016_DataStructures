package heap;

/**
 * Created by csh9196 on 2016-11-14.
 */
public class Data {
    private Object data;

    Data(){}
    Data(Object data){
        this.data = data;
    }

    public void setData(Object data){
        this.data = data;
    }

    public Object getData(){
        return data;
    }

    @Override
    public String toString(){
        return data+"";
    }
}
