package CarRentalSimulation;

public interface ListInterface<T> {
	public void add(T item);
	public void add(int index, T item);
	public T get(int index);
	public T remove(int index);
	public boolean remove(T item);
	public int size();
	public boolean isEmpty();
}
