public class Person {
    private String fName;
    private String lName;
    private int age;
    private String city;

    public Person(String fName, String lName, int age, String city) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.city = city;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%d, %s)", fName, lName, age, city);
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }
}
