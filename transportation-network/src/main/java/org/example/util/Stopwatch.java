package org.example.util;

/**
 * Utility class for measuring execution time in milliseconds.
 */
public class Stopwatch {
    private long startTime;

    /** Starts the timer */
    public void start() {
        startTime = System.nanoTime();
    }

    /** Returns elapsed time in milliseconds */
    public double elapsedMs() {
        long end = System.nanoTime();
        return (end - startTime) / 1_000_000.0;
    }
}
