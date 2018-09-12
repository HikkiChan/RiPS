package arr;

/**  The class is used to store objects of n-dimensional arrays with the <b>dimension</b> property.
 * @author Dzmitry Sokolenko
 * @version 1.0
 * @since 1.0
 * @see SDArray
 */

class Array {
    /** The property is the dimension of the array */
    private int dimension;

    /** Constructor - creates a new object with the specified value.
     * @param dimension - the dimension of the array
     */
    Array(int dimension) {
        this.dimension = dimension;
    }

    /** Function to get the value of the {@link Array#dimension} field.
     * @return Returns the dimension of the array
     */
    private double getDimension() {
        return dimension;
    }

    /**
     * Function to display class information based on the dimension property.
     * @return Returns information about an {@link Array} object in String format.
     */
    public String toString() {
        return "A " + getDimension() + "-dimensional array.";
    }
}
