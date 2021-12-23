package Immutable_Synchronized_ConcurrentCollections;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadSafe_List {
    public static void main(String[] args){
        //Collections.unmodifiableList()
        //list를 받아서 생성하고 생성하면 modify불가
        List<String> list = new ArrayList<>(Arrays.asList("one","two","three"));
        List<String> unmodifiableList = Collections.unmodifiableList(list);
        //unmodifiableList.add("four"); - 에러난다
        System.out.println(unmodifiableList);

        // Java 9
        final List<String> unmodifiableList2 = List.of(list.toArray(new String[]{}));
        //unmodifiableList2.add("four"); //UnsupportedOperationException
        System.out.println(unmodifiableList2);

        //// Google Core Libraries for Java (Guava)
        //List<String> unmodifiableList3 = ImmutableList.copyOf(list);
        //ImmutableList<String> unmodifiableList3 = ImmutableList.<String>builder().addAll(list).build();
        //unmodifiableList3.add("four"); //UnsupportedOperationException


        //CopyOnWriterArrayList
        CopyOnWriteArrayList<Integer> numbers = new CopyOnWriteArrayList<>();
        Iterator<Integer> iterator = numbers.iterator();
        numbers.add(10);
        System.out.println(numbers);

        //Collections.synchronizedList() - List를 synchronized
        List<String> synList= Collections.synchronizedList(list);
        synList.add("four"); //add 할 수 있지만 add중에는 다른작업 x
        System.out.println(synList);

        //ConcurrentHashMap
        Map<String, String> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("1","one");concurrentMap.put("2","two"); concurrentMap.put("3","three");
        System.out.println(concurrentMap);





    }

}
