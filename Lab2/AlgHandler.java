import java.util.ArrayList;

public class AlgHandler implements Runnable{
    ArrayList<Byte> list;
    AlgHandler(ArrayList<Byte> list){
        this.list=list;
    }
    public double getAverage(){
        double average=0;
        for(int i=0;i<list.size();i++){
            average+=list.get(i)/list.size();
        }
        return average;
    }
    public byte getMin(){
        byte min=list.get(0);
        for(int i=1;i<list.size();i++)
            if(list.get(i)<min)
                min=list.get(i);
        return min;
    }
    public byte getMax(){
        byte max=list.get(0);
        for(int i=1;i<list.size();i++)
            if(list.get(i)>max)
                max=list.get(i);
        return max;
    }
    public int getSum(){
        int sum=0;
        for(int i=0; i<list.size(); i++)
            sum+=list.get(i);
        return sum;
    }
    @Override
    public void run() {
        byte min=getMin();
        byte max=getMax();
        double average=getAverage();
        int sum=getSum();
        synchronized (App.monitor) {
            App.logger.info("Sum: " + sum + " Average: " + average +" Min: " + min + " Max: " + max);
        }
        Thread.interrupted();
    }
}
