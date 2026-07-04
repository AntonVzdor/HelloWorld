package myExperiments;

import java.util.Iterator;

public class LibraryLinkedList implements LibraryList {

    private Node first;
    private Node last;
    private int size;

    @Override
    public Library get(int index) {
        return getNode(index).value;
    }

    @Override
    public boolean add(Library library) {
        if(size == 0){
            first = new Node(null, library, null);
            last = first;
        } else {
            Node secondLast = last;
            last = new Node(secondLast, library, null);
            secondLast.next = last;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(int index, Library library) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        if(index == size){
            return add(library);
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
        return true;
    }

    @Override
    public boolean remove(Library library) {
        int index = findIndex(library);
        if(index != -1){
            return removeAt(index);
        }
        return false;
    }

    @Override
    public boolean contains(Library library) {
        return findIndex(library) != -1;
    }

    private int findIndex(Library library){
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(library)) {
                return i;
            }
            node =node.next;
        }
        return -1;
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

    @Override
    public Iterator<Library> iterator() {
        return new Iterator<Library>() {

           private Node node = first;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public Library next() {
                Library library = node.value;
                node = node.next;
                return library;
            }
        };
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
