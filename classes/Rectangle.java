package classes;

public class Rectangle extends Shape {
    private int height, length;

    /**
     * @return
     */
    public int getLength() {
        return length;
    }

    /**
     * @param length
     */
    public void setLength(final int length) {
        this.length = length;
    }

    /**
     * @return
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height
     */
    public void setHeight(final int height) {
        this.height = height;
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
