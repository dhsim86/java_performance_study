package lecture;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Predicate;

/**
 * Created by Dongho on 2017. 3. 6..
 */
public class LambdaExample {

    public static void main(String[] args) {

        Operator addOperator = (x, y) -> x + y;
        Operator subOperator = (x, y) -> x - y;

        System.out.println(addOperator.operation(1, 2));
        System.out.println(subOperator.operation(10, 5));

        Predicate<Integer> predicateInt = i -> i > 30;
        System.out.println(predicateInt.test(10));
        System.out.println(predicateInt.test(31));
    }

    public ActionListener getListener() {

        ActionListener ActionListener = e -> System.out.println(e.getSource());
        ActionListener ActionListener2 = e -> {
            System.out.println(e.getSource());
            System.out.println(e.getActionCommand());
        };

        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("click detected.");
            }
        };
    }

}

@FunctionalInterface
interface Operator {

    public int operation(int x, int y);
}