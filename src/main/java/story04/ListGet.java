package story04;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dongho on 2017. 3. 1..
 */
@State(Scope.Thread)
@BenchmarkMode({Mode.AverageTime})
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Fork(1)
public class ListGet {

    int LOOP_COUNT = 1000;

    List<Integer> arrayList;
    List<Integer> vector;
    LinkedList<Integer> linkedList;

    int result = 0;

    @Setup
    public void setUp() {

        arrayList = new ArrayList<Integer>();
        vector = new Vector<Integer>();
        linkedList = new LinkedList<Integer>();

        for (int i = 0; i < LOOP_COUNT; i++) {
            arrayList.add(i);
            vector.add(i);
            linkedList.add(i);
        }
    }

    @Benchmark
    public void getArrayList() {

        for (int i = 0; i < LOOP_COUNT; i++) {
            result = arrayList.get(i);
        }
    }

    @Benchmark
    public void getVector() {

        for (int i = 0; i < LOOP_COUNT; i++) {
            result = vector.get(i);
        }
    }

    @Benchmark
    public void getLinkedList() {

        for (int i = 0; i < LOOP_COUNT; i++) {
            result = linkedList.get(i);
        }
    }

    @Benchmark
    public void peekLinkedList() {

        for (int i = 0; i < LOOP_COUNT; i++) {
            result = linkedList.peek();
        }
    }
}
