package classes;
public interface Visitor {
    //such visit, much wow
    void visit(Line line);
    void visit(Circle circle);
    void visit(Triangle triangle);
    void visit(Square square);
    void visit(Polygon polygon);
    void visit(Rectangle rectangle);
    void visit(Diamond diamond);
    void visit(Shape shape);

    void visit(Line line, Canvas map);
    void visit(Circle circle, Canvas map);
    void visit(Triangle triangle, Canvas map);
    void visit(Square square, Canvas map);
    void visit(Polygon polygon, Canvas map);
    void visit(Rectangle rectangle, Canvas map);
    void visit(Diamond diamond, Canvas map);
    void visit(Shape shape, Canvas map);
}
