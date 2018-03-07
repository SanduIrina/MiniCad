package classes;
public class Triangle extends Shape {
    private Point mid;
    private Point stop;

    /**
     * @return
     */
    public Point getMid() {
        return mid;
    }

    /**
     * @param x
     * @param y
     * @param rgb
     * @param a
     */
    public void setMid(final int x, final int y, final String rgb, final int a) {
        mid = new Point(x, y, rgb, a);
    }

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
