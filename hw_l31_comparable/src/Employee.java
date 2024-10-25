public class Employee implements Comparable<Employee>{
    private int id;
    private String name;
    private int age;
    private double salary;

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%d. %s (%d) зарплата: %.2f €%n", id, name, age, salary);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Employee o) {
        // return (int ) (salary - o.getSalary()); - некорректно работает, если разница чисел слишком маленькая (десятые)
        return Double.compare(salary, o.getSalary());
    }

}
