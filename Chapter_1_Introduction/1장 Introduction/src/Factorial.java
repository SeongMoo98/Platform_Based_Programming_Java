public class Factorial {
    public static void main(String[] args){
        int values[]={5,10,15};
        //Enhanced for loop
        for(int i:values){
            System.out.println("Factorial of "+ i +":\t"+factorial(i));
        }
    }

    private static long factorial(final int n){
        long result =1;
        for(int i=1 ; i<=n; i++){
            result*=i;
        }
        return result;
    }

}

