package InputAndOutput;

public class FormatTest {
    public static void main(String[] args){

        long n=123465;
        System.out.printf("%d%n",n);
        System.out.printf("%10d%n",n);
        System.out.printf("%-10d%n",n);
        System.out.printf("%010d%n",n);
        System.out.printf("%+10d%n",n);
        System.out.printf("%,10d%n",n);
        System.out.format("%d\t%1$#x%n%n",n);


        double pi=Math.PI;
        System.out.printf("%n%f%n",pi);
        System.out.printf("%e%n",pi);
        System.out.printf("%10.3f%n",pi);
        System.out.printf("%10.3e%n",pi);
        System.out.printf("%+-10.3f%n",pi);

    }
}
