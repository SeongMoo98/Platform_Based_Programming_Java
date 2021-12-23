import java.util.Scanner;

public class MathMain {
    public static void main(String[] args){
        final Scanner scanner=new Scanner(System.in);

        System.out.print("Enter a begin number : ");
        final long beginNum=scanner.nextLong();
        System.out.println();


        System.out.print("Enter an end number : ");
        final long endNum=scanner.nextLong();
        System.out.println();


        long sum=getSumBetween(beginNum,endNum);
        System.out.printf("Sum between %d and %d : %,d%n",beginNum,endNum,sum);


        long product=getProductBetween(beginNum,endNum);
        System.out.printf("Product between %d and %d : %,d%n",beginNum,endNum,product);




    }

    private static long getSumBetween(long begin,long end){
        long sum=0;
        for(long i=begin; i<=end;i++)
        {
            sum+=i;
        }
        return sum;
    }

    private static long getProductBetween(long begin,long end){
        long product=1;
        for(long i=begin; i<=end;i++)
        {
            product*=i;
        }
        return product;

    }
}
