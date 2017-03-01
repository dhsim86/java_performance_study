package Story04;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * Created by Dongho on 2017. 3. 1..
 */
public class RandomKeyUtil {

    public static String[] generateRandomSetKeysSwap(Set<String> set) {

        int size = set.size();
        String[] result = new String[size];
        Random random = new Random();
        int maxNumber = size;

        Iterator<String> iterator = set.iterator();
        int resultPos = 0;
        while(iterator.hasNext()) {
            result[resultPos++] = iterator.next();
        }

        for (int i = 0; i < size; i++) {
            int randomNumber1 = random.nextInt(maxNumber);
            int randomNumber2 = random.nextInt(maxNumber);

            String temp = result[randomNumber2];

            result[randomNumber2] = result[randomNumber1];
            result[randomNumber1] = temp;
        }

        return result;
    }
}
