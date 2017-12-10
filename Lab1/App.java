import java.util.Scanner;
import java.util.logging.Logger;

public class App {
    static Logger logger=Logger.getLogger("logger");
    public static void main(String[] args) {
        System.out.println("Create list of 1.numbers or 2.strings");
        Scanner in = new Scanner(System.in);
        int answer;
        int amount;
        do{
            answer=in.nextInt();
        }while ((answer!=1)&&(answer!=2));
        System.out.println("Enter amount of elements");
        do{
            amount=in.nextInt();
        }while(amount<=0);
        if(answer==1){
            System.out.println("Delete 1.even numbers or 2.odd numbers");
            do{
                answer=in.nextInt();
            }while((answer!=1)&&(answer!=2));
            if(answer==1)
                Generator.generate(true, amount, 1);
            else
                Generator.generate(true, amount, 2);
        }else {
            System.out.println("Enter max size of string");
            int param;
            do {
                param=in.nextInt();
            }while(param<=1);
            Generator.generate(false, amount,param);
        }
    }
}