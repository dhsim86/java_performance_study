package story04;

import org.openjdk.jmh.annotations.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dongho on 2017. 3. 1..
 */
@State(Scope.Thread)
@BenchmarkMode({Mode.AverageTime})
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Fork(1)
public class SetContains {

    int LOOP_COUNT = 1000;

    Set<String> hashSet;
    Set<String> treeSet;
    Set<String> linkedHashSet;

    String data = "abcdedfghijklmnopqrstuvwxyz";
    String[] keys;

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

        if (keys == null || keys.length != LOOP_COUNT) {
            keys = RandomKeyUtil.generateRandomSetKeysSwap(hashSet);
        }
    }

    @Benchmark
    public void containsHashSet() {

        for (String key : keys) {
            hashSet.contains(key);
        }
    }

    @Benchmark
    public void containsTreeSet() {

        for (String key : keys) {
            treeSet.contains(key);
        }
    }

    @Benchmark
    public void containsLinkedHashSet() {

        for (String key : keys) {
            linkedHashSet.contains(key);
        }
    }
}
