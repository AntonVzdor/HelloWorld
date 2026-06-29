package myExperiments;

public class LibraryLinkedList implements LibraryList {

    private Node first;
    private Node last;
    private int size;

    @Override
    public Library get(int index) {
        return getNode(index).value;
    }

    @Override
    public void add(Library library) {
        if(size == 0){
            first = new Node(null, library, null);
            last = first;
        } else {
            Node secondLast = last;
            last = new Node(secondLast, library, null);
            secondLast.next = last;
        }
        size++;
    }

    @Override
    public void add(int index, Library library) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        if(index == size){
            add(library);
            return;
        }
        Node nodeNext = getNode(index);
        Node nodePrev = nodeNext.previous;
        Node newNode = new Node(nodePrev, library, nodeNext);
        nodeNext.previous = newNode;
        if(nodePrev != null){
            nodePrev.next = newNode;
        } else {
            first = newNode;
        }
        size++;
    }

    @Override
    public boolean remove(Library library) {
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(library)) {
                return removeAt(i);
            }
            node =node.next;
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        Node node = getNode(index);
        Node nodeNext = node.next;
        Node nodePrev = node.previous;
        if(nodeNext != null){
            nodeNext.previous = nodePrev;
        } else {
            last = nodePrev;
        }
        if (nodePrev != null){
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

    private Node getNode(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private static class Node{
        private Node previous;
        private final Library value;
        private Node next;

        public Node(Node previous, Library value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }
}
