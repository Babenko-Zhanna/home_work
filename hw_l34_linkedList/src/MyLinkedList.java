public class MyLinkedList<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    public void add(T obj) {
        if (head == null) {
            head = new Node<>(obj, null, null);
            tail = head;
        } else {
            Node<T> newNode = new Node<>(obj, tail, null);
            newNode.getPrev().setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public void add (int index, T element) {
        if (index < 0 || index >= size) {
            System.out.println("Некорректный индекс: " + index);
            return;
        }

        Node<T> next = getNodeByIndex(index);

        if (index == 0) {
            head = new Node<>(element, null, next);
            head.getNext().setPrev(head);
        } else if (index == size - 1) {
            add(element);
        } else {
            Node<T> newNode = new Node<>(element,next.getPrev(), next);
            newNode.getPrev().setNext(newNode);
            newNode.getNext().setPrev(newNode);
        }
        size++;
    }

    public void print() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.getObj());
            currentNode = currentNode.getNext();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> currentNode = head;
        while (currentNode != null) {
            sb.append(currentNode.getObj()).append(System.lineSeparator());
            currentNode = currentNode.getNext();
        }
        return sb.toString();
    }

    private Node<T> getNodeByIndex(int index) {
        Node<T> currentNode = head; // index = 0
        int currentIndex = 0;
        if (index < 0 || index >= size) {
            return null;
        }

        while (currentNode != null && currentIndex != index) {
            currentNode = currentNode.getNext();
            currentIndex++;
        }

        return currentNode;
    }

    public T get(int index) {
        Node<T> nodeByIndex = getNodeByIndex(index);
        if (nodeByIndex != null) {
            return nodeByIndex.getObj();
        }
        return null;
    }

    public int size() {
        return size;
    }

    public static <E> MyLinkedList<E> of(E... elements) {
        MyLinkedList<E> result = new MyLinkedList<>();
        for (E element : elements) {
            result.add(element);
        }
        return result;
    }
}
