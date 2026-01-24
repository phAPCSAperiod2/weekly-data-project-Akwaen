/**
 * The WeeklyData class stores and analyzes a week’s worth of numeric data.
 * This could represent steps taken, hours of sleep, money spent, screen time,
 * or any other measurable daily value.
 */
class WeeklyData {

    // -------------------------------------------------------------
    // Instance Variables
    // -------------------------------------------------------------
    // TODO: Declare a private array to store the week’s data
    //       Choose an appropriate type (double[] or int[])
    //       Create other instance variables as necessary
        private double[] data;

    // -------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------
    /**
     * Constructs a WeeklyData object by taking in an array of values
     * and making a deep copy (element-by-element) into the internal array.
     *
     * @param input an array representing 7 days of data
     */
    public WeeklyData(double[] input) {
        // Check if input is null and handle appropriately
        if (input == null) {
            this.data = new double[0];
            return;
        }
        
        // Create a new array with the same length as input
        this.data = new double[input.length];
        
        // Copy each value from input into the internal data array
        for (int i = 0; i < input.length; i++) {
            this.data[i] = input[i];
        }
    }


    // -------------------------------------------------------------
    // getTotal
    // -------------------------------------------------------------
    /**
     * Calculates and returns the total of all values in the week.
     *
     * @return the sum of all values in the data array
     */
    public double getTotal() {
        // Create a variable to store the running total
        double total = 0.0;
        
        // Use a loop to add each value in the array to the total
        for (int i = 0; i < data.length; i++) {
            total += data[i];
        }
        
        // Return the total
        return total;
    }


    // -------------------------------------------------------------
    // getAverage
    // -------------------------------------------------------------
    /**
     * Calculates and returns the average value for the week.
     *
     * @return the average of the values in the array,
     *         or 0.0 if the array is empty
     */
    public double getAverage() {
        // If the array length is 0, return 0.0
        if (data.length == 0) {
            return 0.0;
        }
        
        // Otherwise, divide the total by the number of elements
        return getTotal() / data.length;
    }


    // -------------------------------------------------------------
    // getMax
    // -------------------------------------------------------------
    /**
     * Finds and returns the highest value in the data array.
     *
     * @return the maximum value
     */
    public double getMax() {
        // Assume the first value is the current maximum
        double max = data[0];
        
        // Loop through the rest of the array and update max as needed
        for (int i = 1; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        
        // Return the maximum value found
        return max;
    }


    // -------------------------------------------------------------
    // getMin
    // -------------------------------------------------------------
    /**
     * Finds and returns the lowest value in the data array.
     *
     * @return the minimum value
     */
    public double getMin() {
        // Assume the first value is the current minimum
        double min = data[0];
        
        // Loop through the rest of the array and update min as needed
        for (int i = 1; i < data.length; i++) {
            if (data[i] < min) {
                min = data[i];
            }
        }
        
        // Return the minimum value found
        return min;
    }


    // -------------------------------------------------------------
    // toString
    // -------------------------------------------------------------
    /**
     * Returns a formatted, multi-line String showing each day’s data.
     *
     * Example:
     * Day 1: 4500
     * Day 2: 6200
     * Day 3: 5100
     *
     * @return a formatted String representing the week’s data
     */
    @Override
    public String toString() {
        // Create a StringBuilder
        StringBuilder sb = new StringBuilder();
        
        // Loop through the data array
        for (int i = 0; i < data.length; i++) {
            // Append each value with a day label (Day 1, Day 2, etc.)
            sb.append(String.format("Day %d: %.2f%n", i + 1, data[i]));
        }
        
        // Return the completed String
        return sb.toString();
    }
}
