package classes;
public class Shape implements Visitable {
    /*
    Visitor pattern is implemented, so every shape has to be able to "accept" the visitor,
    thus the superclass shape extends the Visitable interface.
    */
    private Point start;
    private Point gCenter;
    private int intA, extA;
    protected String rgbExt, rgbInt;
    private String type;

    public final String getRgbExt() {
        return rgbExt;
    }
    public final void setRgbExt(final String rgb) {
        this.rgbExt = rgb;
    }
    public final String getRgbInt() {
        return rgbInt;
    }
    public final void setRgbInt(final String rgb) {
        this.rgbInt = rgb;
    }
    public final int getExtA() {
        return extA;
    }
    public final void setExtA(final int extA) {
        this.extA = extA;
    }
    public final int getIntA() {
        return intA;
    }
    public final void setIntA(final int intA) {
        this.intA = intA;
    }
    public final Point getStart() {
        return start;
    }
    public final void setStart(final int x, final int y, final String rgb, final int a) {
        start = new Point(x, y, rgb, a);
    }
    public final Point getCenter() {
        return gCenter;
    }
    public final void setgCenter(final int x, final int y, final String rgb, final int a) {
        gCenter = new Point(x, y, rgb, a);
    }
    /* (non-Javadoc)
     * @see Visitable#accept(Visitor, Canvas)
     */
    @Override
    public void accept(final Visitor visitor, final Canvas canvas) {
        visitor.visit(this);
        visitor.visit(this, canvas);
    }

    /**
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(final String type) {
        this.type = type;
    }
}
