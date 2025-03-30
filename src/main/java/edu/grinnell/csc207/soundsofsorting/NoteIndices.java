package edu.grinnell.csc207.soundsofsorting;

import java.util.Random;

/**
 * A collection of indices into a Scale object. These indices are the subject of
 * the various sorting algorithms in the program.
 */
public class NoteIndices {

    Integer[] noteIndicies;
    boolean[] highlighted;

    /**
     * @param n the size of the scale object that these indices map into
     */
    public NoteIndices(Integer n) {
        initializeAndShuffle(n);
    }

    /**
     * Reinitializes this collection of indices to map into a new scale object
     * of the given size. The collection is also shuffled to provide an initial
     * starting point for the sorting process.
     *
     * @param n the size of the scale object that these indices map into
     */
    public void initializeAndShuffle(Integer n) {
        this.highlighted = new boolean[n];
        this.noteIndicies = new Integer[n];
        for (int i = 0; i < this.noteIndicies.length; i++) {
            this.noteIndicies[i] = i;
        }

        shuffle(this.noteIndicies);
    }

    /**
     * fisher yates shuffle method
     *
     * @param array
     */
    public static void shuffle(Integer[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    /**
     * @return the indices of this NoteIndices object
     */
    public Integer[] getNotes() {
        return noteIndicies;
    }

    /**
     * Highlights the given index of the note array
     *
     * @param index the index to highlight
     */
    public void highlightNote(Integer index) {
        if (index >= 0 && index < highlighted.length) {
            this.highlighted[index] = true;
        }
    }

    /**
     * @param index the index to check
     * @return true if the given index is highlighted
     */
    public boolean isHighlighted(Integer index) {
        return index >= 0 && index < highlighted.length && highlighted[index];
    }

    /**
     * Clears all highlighted indices from this collection
     */
    public void clearAllHighlighted() {
        for (int i = 0; i < this.highlighted.length; i++) {
            this.highlighted[i] = false;
        }
    }
}
