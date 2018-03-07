package classes;
public class Line extends Shape {
    private Point stop;

    /**
     * @return
     */
    public Point getStop() {
        return stop;
    }

    /**
     * @param x
     * @param y
     * @param rgb
     * @param a
     */
    public void setStop(final int x, final int y, final String rgb, final int a) {
        stop = new Point(x, y, rgb, a);
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
