package BasicMethods.hashCode;

public class StringHashCode {
    public static void main(String[] args){
        var string1="Hello";
        var string2="hello";

        System.out.println(getHash(string1)+ " : "+getHash(string2));
        System.out.println(string1.hashCode()+" : "+string2.hashCode());

    }

    //String class에 있는 hashCode와 유사한 함수
    private static int getHash(String string){
        var hash =0;
        for(int i=0; i<string.length(); i++){
            hash=31*hash+string.charAt(i);
        }
        return hash;
    }
}
