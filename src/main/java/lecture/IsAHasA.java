package lecture;

/**
 * Created by Dongho on 2017. 3. 6..
 */
public class IsAHasA {

    public static void main(String[] args) {

        Employee employee = new Employee();
        employee.id = 1;
        employee.name = "example_name";

        IsAHasA sample = new IsAHasA();
        sample.changeValue(employee);
        System.out.println(employee.name);
    }

    public void changeValue(Employee employee) {

        employee.id = 2;
        employee.name = "example_name2";
    }
}

class Employee {
    int id;
    String name;
}
