package story02;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dongho on 2017. 3. 1..
 */
@BenchmarkMode({Mode.AverageTime})
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(3)
public class CompareTimerJMH {

    private static final int capacityCount = 1000000;

    @Benchmark
    public DummyData makeObject() {
        HashMap<String, String> map = new HashMap<String, String>(capacityCount);
        ArrayList<String> list = new ArrayList<String>(capacityCount);

        return new DummyData(map, list);
    }
}
