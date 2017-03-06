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
public class ListAdd {

    int LOOP_COUNT = 1000;

    List<Integer> arrayList;
    List<Integer> vector;
    List<Integer> linkedList;

    @Benchmark
    public void addArrayList() {
        arrayList = new ArrayList<Integer>();

        for (int i = 0; i < LOOP_COUNT; i++) {
            arrayList.add(i);
        }
    }

    @Benchmark
    public void addVector() {
        vector = new Vector<Integer>();

        for (int i = 0; i < LOOP_COUNT; i++) {
            vector.add(i);
        }
    }

    @Benchmark
    public void addLinkedList() {
        linkedList = new LinkedList<Integer>();

        for (int i = 0; i < LOOP_COUNT; i++) {
            linkedList.add(i);
        }
    }
}
