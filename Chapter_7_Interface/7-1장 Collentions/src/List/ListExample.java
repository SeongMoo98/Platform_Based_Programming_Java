package List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListExample {
    public static void main(String[] args){
        List<String> names=new ArrayList<String>();
        //add, addAll
        names.add("Park");
        names.add("Kim");

        //toString
        System.out.println(names.toString()); //[Park, Kim]
        System.out.println(Arrays.toString(names.toArray())); //[Park, Kim]

        //add(index, value)-index위치에 추가
        names.add(1,"Lee");

        //size,get
        for(int i=0; i<names.size(); i++){
            System.out.println(names.get(i));
        }


        //remove(Object o), remove(int index), removeAll(Collection<T> c)
        names.remove("Kim");

        //indexOf(Object o) , lastIndexOf(Object o)
        int foundIndex=names.indexOf("Kim");
        if(foundIndex==-1){//!names.contains("Kim") , containsAll()
            System.out.println("Kim not found");
        }


        //subList(index1, index2) - [index1, index2)까지 sublist
        names.subList(0,1).clear();

        //Iterator class
        //hasNext-boolean 반환
        // it.next() - Iterator을 Next로 옮기고 Object반환
        Iterator<String> it=names.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        //clear(), isEmpty()
        names.clear();
        assert (names.isEmpty()==true);



        //List -> Array = List.toArray();
        //Array를 List로  Arrays.asList()
        String[] monthArr={"January", "February", "March" };
        final List<String> monthList=Arrays.asList(monthArr);
        System.out.println(monthArr.toString());

        Collections.
    }
}
