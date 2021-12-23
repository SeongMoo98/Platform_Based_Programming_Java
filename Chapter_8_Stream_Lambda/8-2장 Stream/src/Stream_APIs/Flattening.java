package Stream_APIs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Flattening {
    public static void main(String[] args){
        List<String> words = Arrays.asList("Hello","World");

        List<String[]> chs = words.stream()
                .map((word)->word.split(""))
                .distinct()
                .collect(Collectors.toList());
        //mapping한 결과 String의 배열로 String이 2개가 된다
        System.out.println(chs);


        //flattening
        List<String> uniqueCharacters = words.stream()
                .map((word)->word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        //flatMap - stream에서 배열을 mapping하는게 아니라
        //stream의 contents를 mapping한다
        System.out.print(uniqueCharacters);
    }
}
