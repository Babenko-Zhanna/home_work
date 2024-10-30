public class Node<T> { // в одной ноде хранится всегда 3 ссылки: текущий объект, предыдущий и следующий (всего: 4 х 3 = 12 байт)
    private T obj;
    private Node<T> prev;
    private Node<T> next;

    public Node(T obj, Node<T> prev, Node<T> next) {
        this.obj = obj;
        this.prev = prev;
        this.next = next;
    }

    // toString не нужен, этот класс не имеет бизнес смысла, только для обозначения цепочки в листе

    public T getObj() {
        return obj;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
