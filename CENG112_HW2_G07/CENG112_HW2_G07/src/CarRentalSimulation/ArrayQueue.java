package CarRentalSimulation;

import java.util.NoSuchElementException;

public final class ArrayQueue<T> implements QueueInterface<T> {
	private T[] queue;
	private int frontIndex;
	private int backIndex;
	private int size;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
	
	public ArrayQueue() {
		this(DEFAULT_CAPACITY);
	}
	public ArrayQueue(int initialCapacity) {
		queue = (T[]) new Object[initialCapacity];
		frontIndex=0;
		backIndex=-1;		
		size=0;
	}
	public void enqueue(T newEntry) {
		if (size == queue.length) {
			throw new IllegalStateException("Queue if full!");
		}
		ensureCapacity();
		backIndex = (backIndex+1) % queue.length;
		queue[backIndex] = newEntry;
	}
	public T getFront() {
		if(isEmpty())
			throw new NoSuchElementException("Queue is empty!");
		else
			return queue[frontIndex];
	}
	public T dequeue() {
		if(isEmpty())
			throw new NoSuchElementException("Queue is empty!");
		else {
			T front = queue[frontIndex];
			queue[frontIndex] = null;
			frontIndex = (frontIndex+1) % queue.length;
			return front;
		}
	}
	private void ensureCapacity() {
		if(frontIndex == ((backIndex+2) % queue.length)) {
			T[] oldQueue = queue;
			int oldSize = oldQueue.length;
			int newSize = 2 * oldSize;
			@SuppressWarnings("unchecked")
			T[] tempQueue = (T[]) new Object[newSize];
			queue = tempQueue;
			for(int index = 0; index<oldSize-1;index++) {
				queue[index]=oldQueue[frontIndex];
				frontIndex=(frontIndex+1)&oldSize;
			}
			frontIndex=0;
			backIndex=oldSize-2;
		}
	}
	public boolean isEmpty() {
		return frontIndex == ((backIndex+1) % queue.length);
	}
	
	public int size(){
		return size;
	}

}
