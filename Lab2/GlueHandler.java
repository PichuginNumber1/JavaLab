import java.util.ArrayList;

public class GlueHandler implements Runnable{
    ArrayList<String> list;
    GlueHandler(ArrayList<String> list){
        this.list=list;
    }
    public StringBuffer glueLines(){
        StringBuffer gluedLine=new StringBuffer();
        for(int i=0;i<list.size();i++)
            gluedLine.append(list.get(i)+" ");
        return gluedLine;
    }
    @Override
    public void run(){
        StringBuffer gluedLine=glueLines();
        synchronized (App.monitor){
            App.logger.info("glued lines: "+gluedLine);
        }
        Thread.interrupted();
    }
}