package story04;

import org.openjdk.jmh.annotations.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dongho on 2017. 3. 1..
 */
@State(Scope.Thread)
@BenchmarkMode({Mode.AverageTime})
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Fork(1)
public class SetIterate {

    int LOOP_COUNT = 1000;

    Set<String> hashSet;
    Set<String> treeSet;
    Set<String> linkedHashSet;

    String data = "abcdefghijklmnopqrstuvwxyz";
    String[] keys;

    String result = null;

    @Setup(Level.Trial)
    public void setUp() {

        hashSet = new HashSet<String>();
        treeSet = new TreeSet<String>();
        linkedHashSet = new LinkedHashSet<String>();

        for (int i = 0; i < LOOP_COUNT; i++) {
            String tempData = data + i;

            hashSet.add(tempData);
            treeSet.add(tempData);
            linkedHashSet.add(tempData);
        }
    }

    @Benchmark
    public void iterateHashSet() {

        Iterator<String> iter = hashSet.iterator();

        while(iter.hasNext()) {
            result = iter.next();
        }
    }

    @Benchmark
    public void iterateTreeSet() {

        Iterator<String> iter = treeSet.iterator();

        while(iter.hasNext()) {
            result = iter.next();
        }
    }

    @Benchmark
    public void iterateLinkedHashSet() {

        Iterator<String> iter = linkedHashSet.iterator();

        while(iter.hasNext()) {
            result = iter.next();
        }
    }
}
