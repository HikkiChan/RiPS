package arr;

import java.util.Arrays;

/**
 * The class is used to store objects of one-dimensional arrays with properties
 * <b>dimension</b>, <b>length</b> и  <b>elements</b>.
 *
 * @author Dzmitry Sokolenko
 * @version 1.1
 * @see Array
 * @since 1.0
 */

public class SDArray extends Array {

    /**
     * Property - length of one-dimensional array.
     */
    private int length;
    /**
     * Property - elements of a one-dimensional array.
     */
    private double[] elements;

    /**
     * <p>Constructor-create a new object without values.</p>
     * <p>Before creating a one-dimensional array, starts {@link Array#Array(int)}
     * and inherits the {@link Array#dimension} property</p>
     *
     * @see SDArray#SDArray(int)
     * @see SDArray#SDArray(double[])
     */
    public SDArray() {
        super(1);
        length = 0;
    }

    /**
     * <p>Constructor-create a new object without values.</p>
     * <p>Before creating a one-dimensional array, starts {@link Array#Array(int)}
     * and inherits the {@link Array#dimension} property</p>
     *
     * @param length - length of one-dimensional array
     * @see SDArray#SDArray()
     * @see SDArray#SDArray(double[])
     */
    public SDArray(int length) {
        super(1);
        this.length = length;
        elements = new double[length];
    }

    /**
     * <p>Constructor-create a new object without values.</p>
     * <p>Before creating a one-dimensional array, starts {@link Array#Array(int)}
     * and inherits the {@link Array#dimension} property</p>
     *
     * @param array - one-dimensional array to be stored in the {@link SDArray}
     * @see SDArray#SDArray()
     * @see SDArray#SDArray(int)
     */
    public SDArray(double[] array) {
        super(1);
        this.length = array.length;
        this.elements = new double[length];
        this.elements = array;
    }

    /**
     * A function to sort the field values @link SDArray#elements}.
     */
    public void sort() {
        Arrays.sort(elements);
    }

    /**
     * A function to sum an array and a variable.
     *
     * @param num - the variable with which the array will be summed
     */
    public void sumArrayAndConst(double num) {
        for (int i = 0; i < this.length; i++) {
            this.elements[i] += num;
        }
    }

    /**
     * Function for summing two one-dimensional arrays.
     *
     * @param arrayA - an object of class {@link SDArray} will be added to the stack array
     */
    public void sumArrays(SDArray arrayA) {
        if (this.length == arrayA.length) {
            for (int i = 0; i < this.length; i++) {
                this.elements[i] += arrayA.elements[i];
            }
        } else {
            System.out.println("Error: different length of arrays");
        }
    }

    /**
     * A function for the difference between two one-dimensional arrays.
     *
     * @param arrayA - оan object of class {@link SDArray} will be added to the stack array
     */
    public void difArrays(SDArray arrayA) {
        if (this.length == arrayA.length) {
            for (int i = 0; i < this.length; i++) {
                this.elements[i] -= arrayA.elements[i];
            }
        } else {
            System.out.println("Error: different length of arrays");
        }
    }

    /**
     * A function of the product of an array and a variable.
     *
     * @param num - variable by which to multiply the array
     */
    public void multiplyArray(double num) {
        for (int i = 0; i < this.length; i++) {
            this.elements[i] *= num;
        }
    }

    /**
     * Function to change the {@link SDArray#elements} property.
     *
     * @param array - one-dimensional array to be stored in the {@link SDArray#elements} property
     * @see SDArray#setElements(SDArray)
     * @see SDArray#setElements(int, double)
     * @see SDArray#setElements(double)
     */
    public void setElements(double[] array) {
        this.length = array.length;
        this.elements = array;
    }

    /**
     * A function to change the properties of {@link SDArray#length} and {@link SDArray#elements}.
     *
     * @param array - an object of class {@link SDArray}, whose properties will be copied
     * @see SDArray#setElements(double[])
     * @see SDArray#setElements(int, double)
     * @see SDArray#setElements(double)
     */
    public void setElements(SDArray array) {
        this.length = array.length;
        this.elements = array.elements;
    }

    /**
     * Function to change the properties of the {@link SDArray#elements}.
     *
     * @param l   - the item number of the {@link SDArray#elements} property to be replaced
     * @param num - the number that will be assigned to the property cell {@link SDArray#elements}
     * @see SDArray#setElements(double[])
     * @see SDArray#setElements(SDArray)
     * @see SDArray#setElements(double)
     */
    public void setElements(int l, double num) {
        if (l < length) {
            elements[l] = num;
        } else {
            System.out.println("Error: l > length");
        }
    }

    /**
     * Function to change the {@link SDArray#elements} property.
     *
     * @param num - the number that will be assigned to all cells of the {@link SDArray#elements}
     * @see SDArray#setElements(double[])
     * @see SDArray#setElements(SDArray)
     * @see SDArray#setElements(int, double)
     */
    public void setElements(double num) {
        for (int i = 0; i < length; i++) {
            elements[i] = num;
        }
    }

    /**
     * <p>A function display information about class-based
     * {@link Array#dimension}, {@link SDArray#length}, and {@link SDArray#elements} properties</p>
     * <p>When creating a string of information, calls {@link Array#toString()}</p>
     *
     * @return Returns information about an {@link SDArray} object in String format.
     */
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
