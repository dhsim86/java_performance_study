package Story04;

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
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(1)
public class SetAdd {

    int LOOP_COUNT = 1000;

    Set<String> set;
    String data = "abcdefghijklmnopqrstuvwxyz";

    @Benchmark
    public void addHashSet() {

        set = new HashSet<String>();

        for (int i = 0; i < LOOP_COUNT; i++) {
            set.add(data + i);
        }
    }

    @Benchmark
    public void addTreeSet() {

        set = new TreeSet<String>();

        for (int i = 0; i < LOOP_COUNT; i++) {
            set.add(data + i);
        }
    }

    @Benchmark
    public void addLinkedHashSet() {

        set = new LinkedHashSet<String>();

        for (int i = 0; i < LOOP_COUNT; i++) {
            set.add(data + i);
        }
    }
}
