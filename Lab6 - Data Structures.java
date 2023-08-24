import java.util.Arrays;

public class MyQueue<E> {

    private E[] data;
    private int first;
    public int size;

    public MyQueue(int capacity) {
        this.first = -1;
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return data[first];
    }

    public boolean enqueue(E e) {
        if (size >= data.length) {
            return false;
        }
        if (isEmpty()) {
            first = 0;
        }
        int index = (first + size) % data.length;
        data[index] = e;
        size++;
        return true;
    }

    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E result = data[first];
        data[first] = null;
        first = (first + 1) % data.length;
        size--;
        return result;
    }

    @Override
    public String toString() {
        E[] temp = (E[]) new Object[size];
        for (int i = 0; i < size; i++) {
            temp[i] = data[(first + i) % data.length];
        }
        return Arrays.toString(temp) + " and Inner Array: " + Arrays.toString(data);
    }
}