package edu.grinnell.csc207.soundsofsorting;
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
        int panelWidth = this.width;
        int panelHeight = this.height;
        
        if (indices.length == 0){
            return;
        }
        
        
        int barWidth = panelWidth / indices.length;
        
        char indicies = (char) indices.length;
        char[] indiciesArr = {indicies};
        g.drawChars(indiciesArr, 50, 50, 50, 50);
        
        /*

        for (int i = 0; i < indices.length; i++) {
            int barHeight = (indices[i] / indices.length * panelHeight);
            int x = i * barWidth;
            int y = panelHeight - barHeight;

            g.fillRect(x, y, barWidth, barHeight);
        }
*/
        
        
        
    }
}