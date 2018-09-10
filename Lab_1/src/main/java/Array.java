public abstract class Array {

    private int dimension;

    protected Array(int dimension) {
        this.dimension = dimension;
    }

    private double getDimension() {
        return dimension;
    }

    public String toString() {
        return "A " + getDimension() + "-dimensional array.";
    }

}
