import java.util.ArrayList;
import java.util.Random;

public class Generator{
    public static ArrayList<Byte> getNum(int amount) {
        ArrayList<Byte> list=new ArrayList<>();
        Random random=new Random();
        for (int i = 0; i < amount; i++) {
            list.add((byte) (random.nextInt(255)-128));
        }
        App.logger.info("list:"+list.toString());
        return list;
    }

    public static ArrayList<String> getString(int amount, int param){
        ArrayList<String> list=new ArrayList<>();
        Random random = new Random();
        int lineSize;
        StringBuffer line=new StringBuffer();
        int charCode;
        for(int i=0; i<amount; i++) {
            lineSize = random.nextInt(param - 1) + 1;
            for (int j = 0; j < lineSize; j++) {
                charCode = random.nextInt(26) + 96;
                if (charCode == 96) {
                    if((j>0)&&(j<amount-1))
                        if(line.charAt(j-1)!=' ')
                            line.append(" ");
                        else
                            line.append((char)(random.nextInt(25)+97));
                }
                else
                    line.append((char)charCode);
            }
            list.add(line.toString());
            line.delete(0, lineSize-1);
        }
        App.logger.info("list:"+list.toString());
        return list;
    }

    public static void generate(boolean isNum, int amount, int param) {
        Random random = new Random();
        if (isNum == true) {
            ArrayList<Byte> list;
            do {
                list = getNum(amount);
                AlgHandler.getAlgInfo(list);
                DelHandler.DelElements(list, param);
                try {
                    Thread.sleep((random.nextInt(7)+3)*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }while(true);
        }else{
            ArrayList<String> list;
            do{
                list = getString(amount, param);
                GlueHandler.glueLines(list);
                CountHandler.getAmount(list);
                try {
                    Thread.sleep((random.nextInt(7)+3)*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }while(true);
        }
    }
}