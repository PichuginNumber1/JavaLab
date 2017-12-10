import java.util.ArrayList;
import java.util.Random;

public class Generator implements Runnable {
    boolean isNum;
    int amount;
    int param;
    Generator(boolean isNum,int amount, int param) {
        this.isNum = isNum;
        this.amount = amount;
        this.param=param;
    }

    Random random = new Random();

    public ArrayList<Byte> getNum() {
        ArrayList<Byte> list=new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            list.add((byte) (random.nextInt(255)-128));
        }
        App.logger.info("list:"+list.toString());
        return list;
    }

    public ArrayList<String> getString(){
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

    @Override
    public void run() {
        if (isNum == true) {
            ArrayList<Byte> list;
            do {
                synchronized (App.monitor) {
                    list = getNum();
                }
                new Thread(new AlgHandler(list)).start();
                new Thread(new DelHandler(list, param)).start();
                try {
                    Thread.sleep((random.nextInt(7)+3)*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }while(true);
        }else{
            ArrayList<String> list;
            do{
                synchronized (App.monitor) {
                    list = getString();
                }
                new Thread(new GlueHandler(list)).start();
                new Thread(new CountHandler(list)).start();
                try {
                    Thread.sleep((random.nextInt(7)+3)*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }while(true);
        }
    }
}