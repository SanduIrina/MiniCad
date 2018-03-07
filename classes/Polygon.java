package classes;

public class Polygon extends Shape {
    private int n;
    private Point[] points;

    /**
     * @return
     */
    public int getN() {
        return n;
    }

    /**
     * @param n
     */
    public void setN(final int n) {
        this.n = n;
        points = new Point[n];
    }


    /**
     Polygon is consisted of an array of points.
     */
    public void setIpoints(final int i, final int x, final int y) {
        points[i] = new Point(x, y, this.rgbExt, this.getExtA());
    }

    /**
     * @param i
     * @return
     */
    public Point getIpoints(final int i) {
        return points[i];
    }

    /**
     * @param rgbExt
     * @param aExt
     */
    public void setColor(final String rgbExt, final int aExt) {
        int i;
        for (i = 0; i < n; i++) {
            points[i].setA(aExt);
        }
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
