package CarRentalSimulation;

public interface DequeInterface<T> {
    public void addFirst(T item);
    public void addLast(T item);
    public T removeFirst();
    public T removeLast();
    public T peekFirst();
    public T peekLast();
    public int size();
    public boolean isEmpty();
}
