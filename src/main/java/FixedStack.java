import java.util.Stack;

public class FixedStack<T> extends Stack<T> {

    private final int maxSize;

    public FixedStack(int size) {
        super();
        this.maxSize = size;
    }

    @Override
    public T push(T item) {
        if (this.size() < maxSize) {
            return super.push(item);
        }
        return item;
    }
}
