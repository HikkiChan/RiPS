package arr;

import java.util.Arrays;

public class SDArray extends Array {

    private int length;
    private double[] elements;

    public SDArray() {
        super(1);
        length = 0;
    }

    public SDArray(int length) {
        super(1);
        this.length = length;
        elements = new double[length];
    }

    public SDArray(double[] array) {
        super(1);
        this.length = array.length;
        this.elements = new double[length];
        this.elements = array;
    }

    public void sort() {
        Arrays.sort(elements);
    }

    public void sumArrayAndConst(double num) {
        for (int i = 0; i < this.length; i++) {
            this.elements[i] += num;
        }
    }

    public void sumArrays(SDArray arrayA) {
        if (this.length == arrayA.length) {
            for (int i = 0; i < this.length; i++) {
                this.elements[i] += arrayA.elements[i];
            }
        } else {
            System.out.println("Error: different length of arrays");
        }
    }

    public void difArrays(SDArray arrayA) {
        if (this.length == arrayA.length) {
            for (int i = 0; i < this.length; i++) {
                this.elements[i] -= arrayA.elements[i];
            }
        } else {
            System.out.println("Error: different length of arrays");
        }
    }

    public void multiplyArray(double num) {
        for (int i = 0; i < this.length; i++) {
            this.elements[i] *= num;
        }
    }

    public void setElements(double[] array) {
        this.length = array.length;
        this.elements = array;
    }

    public void setElements(SDArray array) {
        this.length = array.length;
        this.elements = array.elements;
    }

    public void setElements(int l, double num) {
        if (l < length) {
            elements[l] = num;
        } else {
            System.out.println("Error: l > length");
        }
    }

    public void setElements(double num) {
        for (int i = 0; i < length; i++) {
            elements[i] = num;
        }
    }

    public String toString() {
        StringBuilder builderStr = new StringBuilder()
                .append(super.toString())
                .append("\nLength: ")
                .append(length)
                .append("\narr.Array:");

        for (int i = 0; i < length; i++) {
            builderStr.append(" [").append(elements[i]).append("]");
        }

        return builderStr.toString();
    }
}
