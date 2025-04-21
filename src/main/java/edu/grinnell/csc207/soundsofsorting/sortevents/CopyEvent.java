package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.Arrays;
import java.util.List;

/**
 * A <code>CopyEvent</code> logs a copy of a value into an index of the array.
 *
 * @param <T>
 */
public class CopyEvent<T> implements SortEvent<T> {

    private final T value;
    private final int destination;
    
    /**
     * Initializes a copy event
     * @param value
     * @param destination 
     */
    public CopyEvent(T value, int destination) {
        this.value = value;
        this.destination = destination;
    }

    @Override
    public void apply(T[] arr) {
        arr[destination] = value;
    }

    @Override
    public List<Integer> getAffectedIndices() {
        return Arrays.asList(destination);
    }

    @Override
    public boolean isEmphasized() {
        return true;
    }
}
