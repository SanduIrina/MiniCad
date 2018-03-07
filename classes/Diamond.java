package classes;
public class Diamond extends Shape {
    private int hDiag, vDiag;

    /**
     * @return
     */
    public int gethDiag() {
        return hDiag;
    }

    /**
     * @param hDiag
     */
    public void sethDiag(final int hDiag) {
        this.hDiag = hDiag;
    }

    /**
     * @return
     */
    public int getvDiag() {
        return vDiag;
    }

    /**
     * @param vDiag
     */
    public void setvDiag(final int vDiag) {
        this.vDiag = vDiag;
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
