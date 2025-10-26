package org.example.util;

/**
 * Simple utility to count algorithmic operations (like comparisons, unions, etc.)
 */
public class OperationCounter {
    private long count = 0;

    /** Increments the counter by 1 */
    public void inc() {
        count++;
    }

    /** Adds a custom number of operations */
    public void add(long x) {
        count += x;
    }

    /** Returns the total number of operations */
    public long get() {
        return count;
    }

    /** Resets the counter */
    public void reset() {
        count = 0;
    }
}
