import java.util.ArrayList;

public class Box<E> {
    private ArrayList<E> contents;
    public Box() {
        contents = new ArrayList<>();
    }
    public void add(E item) {
        contents.add(item);
    }
    public E remove() {
        E item = contents.remove(contents.size() - 1);
        return item;
    }
    @Override
    public String toString() {
        String list = "";
        for (E e : contents) {
            list += e.toString() + "\n";
        }
        return list;
    }
}