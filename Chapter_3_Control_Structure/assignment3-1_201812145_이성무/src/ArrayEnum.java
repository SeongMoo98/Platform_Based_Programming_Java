//assignment3-1_201812145_이성무

import java.util.Scanner;

enum Command{
    ADD,LIST,AVG,SUM,STD,QUIT,INVALID;
}

public class ArrayEnum {
    public static void main(String[] args){
       int[] values=new int[100];
       int index=0;

       final Scanner scanner=new Scanner(System.in);

       while(true){
           final Command command=getCommand(scanner);

           if(command == Command.QUIT){
               System.out.println("Bye!");
               break;
           }
           switch (command){
               case ADD:
                   final int newValue=getValue(scanner);
                   values[index]=newValue;
                   index++;
                   break;
               case LIST:
                   printList(values,index);
                   break;
               case AVG:
                   System.out.printf("%.2f%n",getAvg(values,index));
                   break;
               case SUM:
                   System.out.printf("%d%n",getSum(values,index));
                   break;
               case STD:
                   System.out.printf("%.2f%n",getStd(values,index));
                   break;
               case INVALID:
                   System.out.println("Invalid Command");
                   break;
           }
       }
       scanner.close();

    }
    private static Command getCommand(Scanner scanner) {
        final String commandName = scanner.next();
        Command command;
        try {
            command=Command.valueOf(commandName.toUpperCase());
        }
        catch(IllegalArgumentException e){
            command=Command.INVALID;
        }
        return command;
    }


    private static int getValue(Scanner scanner){
        int value= scanner.nextInt();
        return value;
    }

    private static float getAvg(int[] arr,int index){

        float avg=0;
        int sum=0;
        for(int i=0; i<index; i++){
            sum+=arr[i];
        }
        avg=(float)sum/index;
        return avg;
    }

    private static int getSum(int[] arr,int index){
        int sum=0;
        for(int i=0; i<index; i++){
            sum+=arr[i];
        }
        return sum;
    }

    private static double getStd(int[] arr,int index){
        double std=0,avg=0;
        int sum=0;
        for(int i=0; i<index; i++){
            sum+=arr[i];
        }
        avg=(double)sum/index;
        for(int i=0;i<index;i++){
            std=std+Math.pow(arr[i]-avg,2);
        }

        std=std/index;
        std=Math.sqrt(std);
        return std;

    }

    private static void printList(int[]arr,int index){
        for(int i=0; i<index; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
