package myExperiments;

import org.junit.platform.engine.support.hierarchical.Node;

public class LibraryLinkedList implements LibraryList {

    @Override
    public Library get(int index) {
        return null;
    }

    @Override
    public void add(Library library) {

    }

    @Override
    public void add(int index, Library library) {

    }

    @Override
    public boolean remove(Library library) {
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {

    }

    private static class Node{
        private Node previous;
        private Library value;
        private Node next;

        public Node(Node previous, Library value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }
}
