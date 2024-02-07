package CarRentalSimulation;

import java.util.NoSuchElementException;

public class ArrayDeque<T> implements DequeInterface<T> {
	private T[] data;
    private int frontIndex;
    private int backIndex;
    private int size;

    public ArrayDeque(int initialCapacity) {
        data = (T[]) new Object[initialCapacity];
        frontIndex = 0;
        backIndex = -1;
        size = 0;
    }

    public void addFirst(T item) {
        if (size == data.length) {
            throw new IllegalStateException("Deque is full");
        }
        frontIndex = (frontIndex - 1 + data.length) % data.length;
        data[frontIndex] = item;
        size++;
        if (size == 1) {
        	backIndex = frontIndex;
        }
    }

    public void addLast(T item) {
        if (size == data.length) {
            throw new IllegalStateException("Deque is full");
        }
        backIndex = (backIndex + 1) % data.length;
        data[backIndex] = item;
        size++;
        if (size == 1) {
        	frontIndex = backIndex;
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        T item = data[frontIndex];
        frontIndex = (frontIndex + 1) % data.length;
        size--;
        if (size == 0) {
        	frontIndex = 0;
            backIndex = -1;
        }
        return item;
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        T item = data[backIndex];
        backIndex = (backIndex - 1 + data.length) % data.length;
        size--;
        if (size == 0) {
        	frontIndex = 0;backIndex = -1;
        }
        return item;
    }

    public T peekFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return data[frontIndex];
    }

    public T peekLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return data[backIndex];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
