package story02;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Dongho on 2017. 3. 1..
 */
public class CompareTimer {

    private static final int capacityCount = 1000000;

    public static void main(String[] args) {
        CompareTimer timer = new CompareTimer();

        for (int i = 0; i < 10; i++) {

            timer.checkNanoTime();
            timer.checkCurrentTimeMillis();

            System.out.println("----------------");
        }
    }

    private DummyData dummyData;

    public void checkCurrentTimeMillis() {

        long startTime = System.currentTimeMillis();

        dummyData = timeMakeObject();

        long endTime = System.currentTimeMillis();

        long elapsedTime = endTime - startTime;
        System.out.println("milli=" + elapsedTime);
    }

    public void checkNanoTime() {

        long startTime = System.nanoTime();

        dummyData = timeMakeObject();

        long endTime = System.nanoTime();

        double elapsedTime = (endTime - startTime) / 1000000.0;
        System.out.println("nano=" + elapsedTime);
    }

    public DummyData timeMakeObject() {
        HashMap<String, String> map = new HashMap<String, String>(capacityCount);
        ArrayList<String> list = new ArrayList<String>(capacityCount);

        return new DummyData(map, list);
    }
}
