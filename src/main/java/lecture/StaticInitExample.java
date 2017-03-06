package lecture;

/**
 * Created by Dongho on 2017. 3. 6..
 */
public class StaticInitExample {

    static String rookie;

    static {
        rookie = "Rookie";
    }

    public StaticInitExample() {
    }

    public StaticInitExample(int dummy) {
        this();
    }

    public static void main(String[] args) {

        System.out.println(rookie);
    }

    static {
        rookie = "Rookie 4th";
    }
}
