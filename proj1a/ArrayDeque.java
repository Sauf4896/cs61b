public class ArrayDeque<T> {
    private  T[] array;
    private int size;
    private int capacity = 8;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        array = (T[]) new Object[capacity];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

    private boolean isFull() {
        return size == capacity - 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void resize(double factor) {
        int first = (nextFirst + 1) % capacity;
        int last = nextLast-1 < 0 ? capacity-1 : nextLast-1;
        int capacity_old = capacity;
        capacity = (int) (capacity * factor);
        T[] newArray = (T[]) new Object[capacity];

        int pos = 0;
        while (first != last) {
            newArray[pos] = array[first];
            pos++;
            first = (first + 1) % capacity_old;
        }
        newArray[pos] = array[first];
        array = newArray;
        nextFirst = capacity - 1;
        nextLast = size;
    }

    public void addFirst(T item) {
        if (size == capacity) resize(2);
        array[nextFirst] = item;
        nextFirst = nextFirst-1 < 0 ? capacity-1 : nextFirst-1;
//        System.out.println(nextFirst);
        size++;
    }

    public void addLast(T item) {
        if (size == capacity) resize(2);
        array[nextLast] = item;
        nextLast = (nextLast + 1) % capacity;
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) return null;
        int first = (nextFirst + 1) % capacity;
        T temp = array[first];
        array[first] = null;
        nextFirst = first;
//        System.out.println(nextFirst);
        size--;
        if (capacity >= 16 && size / (double) capacity < 0.25) {
            resize(0.5);
        }
        return temp;
    }

    public T removeLast() {
        if (isEmpty()) return null;
        int last = nextLast-1 < 0 ? capacity-1 : nextLast-1;
        T temp = array[last];
        array[last] = null;
        nextLast = last;
        size--;
        if (capacity >= 16 && size / (double) capacity < 0.25) {
            resize(0.5);
        }
        return temp;
    }

    public T get(int index) {
        if (size <= index) return null;
        int first = (nextFirst + 1) % capacity;
        int i = (first + index) % capacity;
        return array[i];
    }

    public void printDeque() {
        int first;
        int last = nextLast-1 < 0 ? capacity-1 : nextLast-1;
        for (first=(nextFirst+1)%capacity; first!=last; first=(first+1)%capacity) {
            System.out.print(array[first] + " ");
        }
        System.out.println(array[first]);
    }
}
