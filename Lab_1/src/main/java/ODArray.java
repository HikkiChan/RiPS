import java.util.Arrays;

public class ODArray extends Array {
    private int length = 0;
    private double [] elements;

    public ODArray() {
        super(1);
        length = 0;
    }

    public ODArray(int length) {
        super(1);
        this.length = length;
        elements = new double [length];
    }

    public ODArray(double[] array) {
        super(1);
        this.length = array.length;
        this.elements = new double [length];
        this.elements = array;
    }

    public void sort() {
        Arrays.sort(elements);
    }

    public ODArray sumArrayAndConst(double num) {
        for(int i = 0; i < this.length; i++) {
            this.elements[i] += num;
        }
        return this;
    }

    public ODArray sumArrays(ODArray arrayA) {
        if(this.length == arrayA.length) {
            for(int i = 0; i < this.length; i++) {
                this.elements[i] += arrayA.elements[i];
            }
        } else {
            System.out.println("Error: different length of arrays");
        }
        return this;
    }

    public ODArray multiplyArray(double num) {
        for(int i = 0; i < this.length; i++) {
            this.elements[i] *= num;
        }
        return this;
    }

    public void setElements(double[] array) {
        this.length = array.length;
        this.elements = array;
    }

    public void setElements(ODArray array) {
        this.length = array.length;
        this.elements = array.elements;
    }

    public void setElements(int l, double num) {
        if(l < length) {
            elements[l] = num;
        } else {
            System.out.println("Error: l > length");
        }
    }

    public void setElements(double num) {
        for(int i = 0; i < length; i++) {
            elements[i] = num;
        }
    }

    public String toString() {
        StringBuilder builderStr = new StringBuilder().append(super.toString()).append("Length: ").append(length).append("\nArray:");
        for( int i = 0; i < length; i++ ) {
            builderStr.append(" [").append(elements[i]).append("]");
        }
        String str = builderStr.append("\n").toString();
        return str;
    }

}
