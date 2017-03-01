package Story04;

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
public class MapGet {

    int LOOP_COUNT = 1000;

    Map<Integer, String> hashMap;
    Map<Integer, String> hashtable;
    Map<Integer, String> treeMap;
    Map<Integer, String> linkedHashMap;

    int keys[];

    @Setup(Level.Trial)
    public void setUp() {

        if (keys == null || keys.length != LOOP_COUNT) {

            hashMap = new HashMap<Integer, String>();
            hashtable = new Hashtable<Integer, String>();
            treeMap = new TreeMap<Integer, String>();
            linkedHashMap = new LinkedHashMap<Integer, String>();

            String data = "abcdefghijklmnopqrstuvwxyz";

            for (int i = 0; i < LOOP_COUNT; i++) {

                String tempData = data + i;

                hashMap.put(i, tempData);
                hashtable.put(i, tempData);
                treeMap.put(i, tempData);
                linkedHashMap.put(i, tempData);
            }

            keys = RandomKeyUtil.generateRandomNumberKeysSwap(LOOP_COUNT);
        }
    }

    @Benchmark
    public void getSeqHashMap() {

        for (int i = 0; i < LOOP_COUNT; i++) {
            hashMap.get(i);
        }
    }

    @Benchmark
    public void getRandomHashMap() {

        for (int i = 0; i < LOOP_COUNT; i++) {
            hashMap.get(keys[i]);
        }
    }

    @Benchmark
    public void getSeqHashtable() {

        for (int i = 0; i < LOOP_COUNT; i++) {
            hashtable.get(i);
        }
    }

    @Benchmark
    public void getRandomHashtable() {

        for (int i = 0; i < LOOP_COUNT; i++) {
            hashtable.get(keys[i]);
        }
    }

    @Benchmark
    public void getSeqTreeMap() {

        for (int i = 0; i < LOOP_COUNT; i++) {
            treeMap.get(i);
        }
    }

    @Benchmark
    public void getRandomTreeMap() {

        for (int i = 0; i < LOOP_COUNT; i++) {
            treeMap.get(keys[i]);
        }
    }

    @Benchmark
    public void getSeqLinkedHashMap() {

        for (int i = 0; i < LOOP_COUNT; i++) {
            linkedHashMap.get(i);
        }
    }

    @Benchmark
    public void getRandomLinkedHashMap() {

        for (int i = 0; i < LOOP_COUNT; i++) {
            linkedHashMap.get(keys[i]);
        }
    }
}
