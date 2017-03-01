package Story04;

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
public class ListRemove {

    int LOOP_COUNT = 1000;

    List<Integer> arrayList;
    List<Integer> vector;
    LinkedList<Integer> linkedList;

    @Setup(Level.Trial)
    public void setUp() {

        arrayList = new ArrayList<Integer>();
        vector = new Vector<Integer>();
        linkedList = new LinkedList<Integer>();

        for (int i = 0; i < LOOP_COUNT; i++) {
            arrayList.add(LOOP_COUNT);
            vector.add(LOOP_COUNT);
            linkedList.add(LOOP_COUNT);
        }
    }

    @Benchmark
    public void removeArrayListFromFirst() {

        ArrayList<Integer> tempList = new ArrayList<Integer>(arrayList);

        for (int i = 0; i < LOOP_COUNT; i++) {
            tempList.remove(0);
        }
    }

    @Benchmark
    public void removeVectorFromFirst() {

        List<Integer> tempList = new Vector<Integer>(vector);

        for (int i = 0; i < LOOP_COUNT; i++) {
            tempList.remove(0);
        }
    }

    @Benchmark
    public void removeLinkedListFromFirst() {

        LinkedList<Integer> tempList = new LinkedList<Integer>(linkedList);

        for (int i = 0; i < LOOP_COUNT; i++) {
            tempList.remove(0);
        }
    }

    @Benchmark
    public void removeArrayListFromLast() {

        ArrayList<Integer> tempList = new ArrayList<Integer>(arrayList);

        for (int i = LOOP_COUNT - 1; i >= 0; i--) {
            tempList.remove(i);
        }
    }

    @Benchmark
    public void removeVectorFromLast() {

        List<Integer> tempList = new Vector<Integer>(vector);

        for (int i = LOOP_COUNT - 1; i >= 0; i--) {
            tempList.remove(i);
        }
    }

    @Benchmark
    public void removeLinkedListFromLast() {

        LinkedList<Integer> tempList = new LinkedList<Integer>(linkedList);

        for (int i = 0; i < LOOP_COUNT; i++) {
            tempList.removeLast();
        }
    }
}
