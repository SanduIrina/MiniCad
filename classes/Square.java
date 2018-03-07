package classes;
public class Square extends Shape {
    private int side;

    /**
     * @return
     */
    public int getSide() {
        return side;
    }

    /**
     * @param side
     */
    public void setSide(final int side) {
        this.side = side;
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
