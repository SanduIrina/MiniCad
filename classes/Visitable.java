package classes;
public interface Visitable {
    void accept(Visitor visitor, Canvas canvas);
}
