package edu.grinnell.csc207.soundsofsorting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * A drawing panel for visualizing the contents of a @NoteIndices object.
 */
public class ArrayPanel extends JPanel {

    @SuppressWarnings("unused")
    private NoteIndices notes;
    private int width;
    private int height;

    /**
     * Create a new <code>ArrayPanel</code> with the given notes and dimensions.
     *
     * @param notes the note indices
     * @param width the width of the panel
     * @param height the height of the panel
     */
    public ArrayPanel(NoteIndices notes, int width, int height) {
        this.notes = notes;
        this.setPreferredSize(new Dimension(width, height));
        this.width = width;
        this.height = height;
    }

    @Override
    public void paintComponent(Graphics g) {

        g.clearRect(0, 0, this.width, this.height);

        Integer[] indices = this.notes.getNotes();
        int panelWidth = getWidth();
        int panelHeight = getHeight();

        if (indices.length == 0) {
            return;
        }

        int barWidth = panelWidth / indices.length;

        for (int i = 0; i < indices.length; i++) {
            int barHeight = (int) (((double) (indices[i] + 1) / indices.length) * panelHeight);
            int x = i * barWidth;
            int y = panelHeight - barHeight;

            g.setColor(new Color(0, 255 - ((int) ((double) indices[i] / indices.length * 255)), 
                    (int) ((double) indices[i] / indices.length * 255)));
            g.fillRect(x, y, barWidth, barHeight);

        }

    }
}
