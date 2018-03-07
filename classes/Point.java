package classes;
public class Point {
    private int x, y, a;
    private String rgb;

    public Point(final int x, final int y, final String rgb, final int a) {
        this.x = x;
        this.y = y;
        this.rgb = rgb;
        this.a = a;
    }

    /**
     * @return
     */
    public String getRgb() {
        return rgb;
    }

    /**
     * @param rgb
     */
    public void setRgb(final String rgb) {
        this.rgb = rgb;
    }

    /**
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * @param y
     */
    public void setY(final int y) {
        this.y = y;
    }

    /**
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * @param x
     */
    public void setX(final int x) {
        this.x = x;
    }

    /**
     * @return
     */
    public int getA() {
        return a;
    }

    /**
     * @param a
     */
    public void setA(final int a) {
        this.a = a;
    }
}
