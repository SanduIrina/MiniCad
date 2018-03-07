package classes;

public class Circle extends Shape {
    private int radius;

    /**
     * @return
     */
    public int getRadius() {
        return radius;
    }

    /**
     * @param radius
     */
    public void setRadius(final int radius) {
        this.radius = radius;
    }

    /* (non-Javadoc)
     * @see Shape#accept(Visitor, Canvas)
     */
    @Override
    public void accept(final Visitor visitor, final Canvas canvas) {
        visitor.visit(this);
        visitor.visit(this, canvas);
    }

}
