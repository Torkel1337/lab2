import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Consumer;

public class FixedDeque<T> {
    private final Deque<T> deque;

    private final int maxSize;

    public FixedDeque(int size) {
        this.deque = new ArrayDeque<>(size);

        this.maxSize = size;
    }


    public void addFirst(T item) {
        if (deque.size() < maxSize) {
            deque.addFirst(item);
        }
    }

    public T removeFirst() {
        return deque.removeFirst();
    }

    public void addLast(T item) {
        if (deque.size() < maxSize) {
            deque.addLast(item);
        }
    }

    public boolean contains(T item) {
        return deque.contains(item);
    }

    public void forEach(Consumer<? super T> forAction) {
        deque.forEach(forAction);
    }
}
