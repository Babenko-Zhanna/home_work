public class Main {
    public static void main(String[] args) {

        MyLinkedList<Person> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(new Person("Jack", 15));
        myLinkedList.add(new Person("Nick", 16));
        myLinkedList.add(new Person("John", 17));
        myLinkedList.add(0, new Person("Sara", 20));
        myLinkedList.add(6, new Person("Micky", 25));
        myLinkedList.add(2, new Person("Lena", 13));

        myLinkedList.print();


    }
}