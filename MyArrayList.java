public class MyArrayList<T> {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(T element) {
        ensureCapacity();
        elements[size++] = element;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) elements[index];
    }

    public int size() {
        return size;
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        elements[size - 1] = null;
        size--;
    }

    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    public boolean remove(T element) {
        int index = indexOf(element);
        if (index != -1) {
            delete(index);
            return true;
        }
        return false;
    }

    private int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }

    public String join(String delimiter) {
        if (size == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        result.append(elements[0]);

        for (int i = 1; i < size; i++) {
            result.append(delimiter).append(elements[i]);
        }

        return result.toString();
    }
}