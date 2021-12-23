package String;

import java.util.Arrays;

public class StringExample {
    public static void main(String[] args){
        String greeting="Hello";

        //length, charAt-index
        for(int i = 0; i < greeting.length(); i++){
                System.out.println(greeting.charAt(i));
        }


        //Substring(int beginIndex, int endIndex) [begin, end)
        String hel=greeting.substring(0,3);
        System.out.println(hel); //Hel

        //concatenation - 접합 , 연산자 오버로딩(str1+str2) 지원 x
        String language="Java !";
        String msg=greeting+" "+language;
        System.out.println("Welcome to "+msg);

        //equality, use equals!!! DO NOT USE ==
        //equals
        if(greeting.equals("hello"))  //"hello".equals(~~~)이 안전하다
            System.out.println("Exactly same!");
        //equalsIgnoreCase - 대소문자 구분없이 비교
        if(greeting.equalsIgnoreCase("hello"))
            System.out.println("Same when case ignored");

        //comparison
        if(greeting.compareTo(language)<0)
            System.out.println(greeting+" comes before "+language);
        else if(greeting.compareTo(language)>0)
            System.out.println(greeting+" comes after "+language);
        else
            System.out.println(greeting+" equals "+language);

        //replacement
        String greeting2=greeting.replace('l','L');
        System.out.println("The original string :  "+greeting+" After : replacement : "+greeting2);


        //indexOf - 처음 나온 index, lastIndexOf - 마지막으로 나온 index
        //if문에서 조건과 자주 쓰인다
        System.out.println(greeting.indexOf('l'));
        System.out.println(greeting.lastIndexOf('l'));
        System.out.println(greeting.indexOf('L')); // -1
        System.out.println(greeting.indexOf("lo")); // 3


        //startsWith, endsWith - boolean 반환
        System.out.println(greeting.startsWith("He"));
        System.out.println(greeting.startsWith("he"));
        System.out.println(greeting.endsWith("lo"));
        System.out.println(greeting.startsWith("hlo"));



        //***********************************
        //split(String regex)
        String line= "first : second : third";
        String[] items1 = line.split(":");
        System.out.println(Arrays.asList(items1));

        String[] items2=line.split("\\s*:\\s*");
        System.out.println(Arrays.asList(items2));


        //toLowerCase, toUpperCase, trim-문자열 앞뒤 공백 제거
        String str="   Hello Java  !  ";
        System.out.println(str.trim());

        //join since Java 8
        System.out.println(String.join("-","I","Love","Java"));


    }
}
