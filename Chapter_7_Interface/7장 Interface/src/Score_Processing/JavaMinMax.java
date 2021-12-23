package Score_Processing;

import java.util.Arrays;

public class JavaMinMax implements MinMaxStrategy{
    @Override
    public int getMin(int[] data){
        int[] copy= Arrays.copyOf(data,data.length);
        Arrays.sort(copy);
        return copy[0];
    }
    @Override
    public int getMax(int[] data){
        int[] copy= Arrays.copyOf(data,data.length);
        Arrays.sort(copy);
        return copy[copy.length-1];
    }

}
