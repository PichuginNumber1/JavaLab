import java.util.ArrayList;

public class DelHandler implements Runnable{
    ArrayList<Byte> list;
    int param;
    DelHandler(ArrayList<Byte> list, int param){
        this.list=list;
        this.param=param;
    }
    @Override
    public void run(){
        if(param==1){
            for(int i=list.size()-1; i>-1;i--){
                if(i%2!=0)
                    list.remove(i);
            }
        } else{
            for(int i=list.size()-1; i>-1;i--){
                if(i%2==0)
                    list.remove(i);
            }
        }
        synchronized (App.monitor){
            App.logger.info("list after removing:"+list.toString());
        }
        Thread.interrupted();
    }
}