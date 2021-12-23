public class Unicode {
    public static void main(String[] args){
        //Korean
        System.out.print("안녕하세요!");
        char[] korean = {'\uC790', '\uBC14'};
        System.out.println(korean);

        //Japanese
        char[] japanese={'\u3051', '\u304F'};
        System.out.println(japanese);

        //Symbols
        char[] symbol={'\u2020', '\u203B'};
        System.out.println(symbol);
    }
}
