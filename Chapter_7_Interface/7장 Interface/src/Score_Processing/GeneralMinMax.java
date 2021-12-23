package Score_Processing;

public class GeneralMinMax implements MinMaxStrategy{
    @Override
    public int getMin(int[] data){
        int min=data[0];
        for(int i=0; i<data.length;i++){
            if(min>data[i]){
                min=data[i];
            }
        }
        return min;
    }
    @Override
    public int getMax(int[] data){
        int max=data[0];
        for(int i=0; i<data.length;i++){
            if(max<data[i]){
                max=data[i];
            }
        }
        return max;
    }

}

