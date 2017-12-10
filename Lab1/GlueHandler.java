import java.util.ArrayList;

public class GlueHandler{
    public static void glueLines(ArrayList<String> list){
        StringBuffer gluedLine=new StringBuffer();
        for(int i=0;i<list.size();i++)
            gluedLine.append(list.get(i)+" ");
        App.logger.info("glued lines: "+gluedLine);
    }
}