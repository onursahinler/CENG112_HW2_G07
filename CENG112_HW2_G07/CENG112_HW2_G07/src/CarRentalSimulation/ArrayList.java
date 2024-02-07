package CarRentalSimulation;

public class ArrayList<T> implements ListInterface<T> {
	private static final int DEFAULT_CAPACITY = 10;
	private T[] queue;
	private int size;
	public ArrayList() {
	    this(DEFAULT_CAPACITY);
	}

	public ArrayList(int initialCapacity) {
		queue = (T[]) new Object[initialCapacity];
	    size = 0;
	}

	public void add(T item) {
	    add(size, item);
	}

	public void add(int index, T item) {
	    if (index < 0 || index > size) {
	        throw new IndexOutOfBoundsException("Invalid index: " + index);
	    }
	    if (size == queue.length) {
	        resize();
	    }
	    for (int i = size; i > index; i--) {
	    	queue[i] = queue[i - 1];
	    }
	    queue[index] = item;
	    size++;
	}

	public T get(int index) {
	    if (index < 0 || index >= size) {
	        throw new IndexOutOfBoundsException("Invalid index: " + index);
	    }
	    return queue[index];
	}

	public T remove(int index) {
	    if (index < 0 || index >= size) {
	        throw new IndexOutOfBoundsException("Invalid index: " + index);
	    }
	    T item = queue[index];
	    for (int i = index; i < size - 1; i++) {
	    	queue[i] = queue[i + 1];
	    }
	    queue[size - 1] = null;
	    size--;
	    return item;
	}

	public boolean remove(T item) {
	    for (int i = 0; i < size; i++) {
	        if (queue[i].equals(item)) {
	            remove(i);
	            return true;
	        }
	    }
	    return false;
	}

	public int size() {
	    return size;
	}

	public boolean isEmpty() {
	    return size == 0;
	}

	private void resize() {
	    T[] newData = (T[]) new Object[queue.length * 2];
	    System.arraycopy(queue, 0, newData, 0, queue.length);
	    queue = newData;
	}

}
