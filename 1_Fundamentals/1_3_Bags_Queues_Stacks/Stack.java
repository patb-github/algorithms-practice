import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>{
    private Node<Item> head;
    private int size;

    private static class Node<Item> {
        Item item;
        Node<Item> next;
    }

    // Initialize an empty stack
    public Stack() { size = 0; }

    // Returns true if this stack is empty.
    public boolean isEmpty() { return size == 0; }

    // Adds the item to this stack.
    public void push(Item item) {
        if (isEmpty())
        {
            head = new Node<>();
            head.item = item;
        } 
        else
        {
            Node<Item> neck = head;
            head = new Node<Item>();
            head.item = item;
            head.next = neck;
        }
        size++;
    }

    // Removes and returns the item most recently added to this stack.
    public Item pop() {
        Item x = head.item;
        head = head.next;
        size--;
        return x;
    }
    
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {
        public boolean hasNext() { return head.next != null; }
        public Item next() {
            Item x = head.item;
            head = head.next;
            return x;
        }
    }
    // Returns (but does not remove) the item most recently added to this stack.
    public Item peek() { return (head == null) ? null : head.item; }
    public static void main(String[] args) {
        
    }
}