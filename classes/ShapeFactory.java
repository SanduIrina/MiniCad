package classes;
public final class ShapeFactory {
    private static ShapeFactory instance;

    private ShapeFactory() { };
    // Singleton pattern is being used
    public static ShapeFactory getShapeFactory() {
        if (instance == null) {
            instance = new ShapeFactory();
        }
        return instance;
    }

    /*
     * Checking the type for the received shape and returning the corresponding object.
     */
    public Shape getShape(final String type) {
        if (type.equals("LINE")) {
            Line line = new Line();
            line.setType("Line");
            return line;
        }
        if (type.equals("CIRCLE")) {
            Circle circle = new Circle();
            circle.setType("Circle");
            return circle;
        }
        if (type.equals("SQUARE")) {
            Square line = new Square();
            line.setType("Square");
            return line;
        }
        if (type.equals("TRIANGLE")) {
            Triangle triangle = new Triangle();
            triangle.setType("Triangle");
            return triangle;
        }
        if (type.equals("RECTANGLE")) {
            Rectangle rectangle = new Rectangle();
            rectangle.setType("Rectangle");
            return rectangle;
        }
        if (type.equals("POLYGON")) {
            Polygon polygon = new Polygon();
            polygon.setType("Polygon");
            return polygon;
        }
        if (type.equals("DIAMOND")) {
            Diamond diamond = new Diamond();
            diamond.setType("Diamond");
            return diamond;
        }
        return null;
    }
}
