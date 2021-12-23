package Score_Processing;

import java.util.Arrays;
//enum Kind{General, Java};
public class ScoreProcessing {
//    private int min,max;
//    private Kind kind;
//
//    public ScoreProcessing(Kind kind) { setKind(kind); }
//    private void setKind(Kind kind) { this.kind = kind; }
//
//    //일반 Method로하면 유지 보수가 어렵다
//    public void analyze(int[] data){
//        switch (kind){
//            case General:
//                min=getGeneralMin(data);
//                max=getGeneralMax(data);
//                break;
//            case Java:
//                min=getJavaMin(data);
//                max=getJavaMax(data);
//                break;
//            default:
//                break;
//        }
//    }
//    private int getGeneralMax(int[] data) {
//        int max = data[0] ;
//        for ( int i = 1 ; i < data.length ; i ++ )
//            if ( max < data[i] ) max = data[i] ;
//        return max ;
//    }
//    private int getGeneralMin(int[] data) {
//        int min = data[0] ;
//        for ( int i = 1 ; i < data.length ; i ++ )
//            if ( min > data[i] ) min = data[i] ;
//        return min ;
//    }
//    private int getJavaMax(int[] data) {
//        int[] copied = Arrays.copyOf(data, data.length) ;
//        Arrays.sort(copied) ;
//        int max = copied[copied.length -1] ;
//        return max ;
//    }
//    private int getJavaMin(int[] data) {
//        int[] copied = Arrays.copyOf(data, data.length) ;
//        Arrays.sort(copied) ;
//        int min = copied[0] ;
//        return min ;
//    }
    private int min,max;
    private MinMaxStrategy strategy;

    public ScoreProcessing(MinMaxStrategy strategy) { setStrategy(strategy); }
    private void setStrategy(MinMaxStrategy strategy) { this.strategy = strategy; }

    public void analyze(int[] data){
        min=strategy.getMin(data);
        max=strategy.getMax(data);
    }
    @Override
    public String toString(){
        return String.format("min : %d, max = %d",min,max);
    }
    public static void main(String[] args) {
        int[] data = {0, 50, 10, 30, 70} ;
        ScoreProcessing proc = new ScoreProcessing(new GeneralMinMax()) ;
        proc.analyze(data) ;
        proc.setStrategy(new JavaMinMax()) ;
        proc.analyze(data) ;
        System.out.println(proc);
    }


}
