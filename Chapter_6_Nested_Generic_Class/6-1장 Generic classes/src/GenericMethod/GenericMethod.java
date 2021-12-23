package GenericMethod;

//Generic Class가 아닌 class안에 Generic Method정의가 가능하다
class ArrayAlg{
    public static <T> T getMiddle(T[] a){
        return a[a.length/2];
    }
}
public class GenericMethod {
    public static void main(String[] args){
        String[] names={"John", "Q", "Public"};
        String middle1 =ArrayAlg.<String>getMiddle(names);
        String middle2=ArrayAlg.getMiddle(names);

        System.out.println(middle1);
        System.out.println(middle2);
    }

}
