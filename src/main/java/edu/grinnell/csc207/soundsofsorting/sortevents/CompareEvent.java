package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.Arrays;
import java.util.List;

/**
 * A <code>CompareEvent</code> logs a comparison a sort makes between two
 * indices in the array.
 * @param <T>
 */
public class CompareEvent<T> implements SortEvent<T> {
    private final int index1;
    private final int index2;

    public CompareEvent(int index1, int index2) {
        this.index1 = index1;
        this.index2 = index2;
    }

    @Override
    public void apply(T[] arr) {
    }

    @Override
    public List<Integer> getAffectedIndices() {
        return List.of(index1, index2);
    }

    @Override
    public boolean isEmphasized() {
        return false;
    }
}
