public abstract class Array {
    private int dimension = 0;

    public Array() {
        dimension = 0;
    }

    public Array(int dimension) {
        this.dimension = dimension;
    }

    public double getDimension() {
        return dimension;
    }

    protected void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public String toString() {
        String str = new StringBuilder().append("A ").append(dimension).append("-dimensional array.\n").toString();
        return str;
    }

}
