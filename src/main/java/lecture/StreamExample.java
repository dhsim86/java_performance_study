package lecture;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Dongho on 2017. 3. 6..
 */
public class StreamExample {

    public static void main(String[] args) {

        List<Integer> intList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            intList.add(i);
        }
/*
        PrintClass printClass = i -> {

            if (i % 3 == 0) {
                System.out.println(i);
            }

        };

        for (int element : intList) {

            printClass.print(element);
        }*/

        intList.stream().filter(i -> i % 3 == 0 && i != 0).
            forEach(i -> System.out.println(i));
        intList.forEach(System.out::println);
        //i -> System.out.println(i) == System.out::println

        System.out.println("count: " + intList.stream().count());
        System.out.println("min: " + intList.stream().min(Integer::compareTo).get());
        System.out.println("max: " + intList.stream().max(Integer::compareTo).get());

        intList.parallelStream().forEach(System.out::println);

        IntStream.range(0, 9).forEach(System.out::print);
    }
}

@FunctionalInterface
interface PrintClass {

    public void print(int i);
}
