package CollectionsFramework;

public class CarLinkedList implements CarList {
    private Node first;
    private Node last;
    int size = 0;

    @Override
    public CarArray get(int index) {
        return getNode(index).value;
    }

    @Override
    public void add(CarArray car) {
        if (size == 0) {
            first = new Node(null, car, null);
            last = first;
        } else {
            Node secondLast = last;
            last = new Node(secondLast, car, null);
            secondLast.next = last;
        }
        size++;
    }

    @Override
    public void add(CarArray car, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(car);
            return;
        }
        Node nodeNext = getNode(index);
        Node nodePrev = nodeNext.prev;
        Node newNode = new Node(nodePrev, car, nodeNext);
        nodeNext.prev = newNode;
        if(nodePrev != null) {
            nodePrev.next = newNode;
        } else {
            first = newNode;
        }
        size++;
    }

    @Override
    public boolean remove(CarArray car) {
        Node node = first;
        for (int i = 0; i < size; i++) {
            if(node.value.equals(car)){
                return removeAt(i);
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        Node node = getNode(index);
        Node nodeNext = node.next;
        Node nodePrev = node.prev;
        if (nodeNext != null) {
            nodeNext.prev = nodePrev;
        } else{
            last = node.prev;
        }
        if (nodePrev != null) {
            nodePrev.next = nodeNext;
        } else {
            first = nodeNext;
        }
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = first;
        for(int i = 0; i< index; i++){
            node = node.next;
        }
        return node;
    }

    private static class Node{
        private Node prev;
        private Node next;
        private CarArray value;

        public Node(Node prev, CarArray value, Node next) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }
    }
}
