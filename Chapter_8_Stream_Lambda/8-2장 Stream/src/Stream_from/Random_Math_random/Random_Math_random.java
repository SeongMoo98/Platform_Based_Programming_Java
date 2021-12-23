package Stream_from.Random_Math_random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Random_Math_random {
    public static void main(String[] args){
        //단순 Random 사용
        Random random=new Random();
        int rn1=random.nextInt();
        int rn2=random.nextInt(100-1)+1;

        List<Integer> rns=new ArrayList<>();
        for(int i=0; i < 10; i++){
            rns.add(random.nextInt(100-1)+1);
        }
        System.out.println(rns);

        IntStream intStream=random.ints(10,1,100);
        intStream.forEach(System.out::println);
    }
}
