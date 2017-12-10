import java.util.ArrayList;

public class DelHandler{
    public static void DelElements(ArrayList<Byte> list, int param){
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
        App.logger.info("list after removing:"+list.toString());
    }
}