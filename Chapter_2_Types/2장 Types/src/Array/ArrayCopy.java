package Array;

public class ArrayCopy {
    public static void main(String[] args){
        //Shallow copy ==> 같은 메모리를 잠조하여 원형도 변경
        int [] smallPrimes={2,3,5,7,11,13};
        int [] luckyNumbers=smallPrimes;
        luckyNumbers[5]=12;
        System.out.println(luckyNumbers[5]);
        System.out.println(smallPrimes[5]);


        //Deep Copy : System.arraycopy(from,fromIndex,to,toIndex,count);
        int[] smallPrimes2={2,3,5,7,11,13};
        int[] luckyNumbers2={1001,1002,1003,1004,1005,1006,1007};
        System.arraycopy(smallPrimes2,2,luckyNumbers2,3,4);
        for(int v:luckyNumbers2){
            System.out.print(v+" ");
        }
    }
}
