import java.util.ArrayList;

public class AlgHandler{
    public static double getAverage(ArrayList<Byte> list){
        double average=0;
        for(int i=0;i<list.size();i++){
            average+=list.get(i)/list.size();
        }
        return average;
    }
    public static byte getMin(ArrayList<Byte> list){
        byte min=list.get(0);
        for(int i=1;i<list.size();i++)
            if(list.get(i)<min)
                min=list.get(i);
        return min;
    }
    public static int getMax(ArrayList<Byte> list){
        int max=list.get(0);
        for(int i=1;i<list.size();i++)
            if(list.get(i)>max)
                max=list.get(i);
        return max;
    }
    public static long getSum(ArrayList<Byte> list){
        int sum=0;
        for(int i=0; i<list.size(); i++)
            sum+=list.get(i);
        return sum;
    }
    public static void getAlgInfo(ArrayList<Byte> list){
        int min=getMin(list);
        int max=getMax(list);
        double average=getAverage(list);
        long sum=getSum(list);
        App.logger.info("Sum: " + sum + " Average: " + average +" Min: " + min + " Max: " + max);
    }
}