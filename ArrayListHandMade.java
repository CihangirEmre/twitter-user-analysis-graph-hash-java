package prolab;

public class ArrayListHandMade<T> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] array;
    private int size;

    public ArrayListHandMade() {
        array = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public void add(T element) {
        if (size == array.length) {
            ensureCapacity();
        }
        array[size++] = element;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Eleman: " + index + ", Boyut: " + size);
        }
        return (T) array[index];
    }

    public int size() {
        return size;
    }

    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void remove(T element) {
        int foundIndex = -1;

        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex != -1) {
            removeAt(foundIndex);
        }
    }

    private void removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Eleman: " + index + ", Boyut: " + size);
        }

        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null;
    }

    private void ensureCapacity() {
        int newCapacity = array.length * 2;
        array = java.util.Arrays.copyOf(array, newCapacity);
    }
}
