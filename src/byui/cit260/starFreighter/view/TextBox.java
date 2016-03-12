package byui.cit260.starFreighter.view;

import static java.lang.System.out;
import java.util.ArrayList;

/**
 * A convenient formatter for printing text inside a box. Don't need to struggle
 * with formatting blocks of text by hand anymore.
 * @author Connor
 */
public class TextBox {

    /**
     * Class constants.
     */
    private final static int MAX_WIDTH = 60;
    private final static String BORDER_SYMBOL = "*";
    
    /**
     * Creates a string of a specified length, then fills it with a specified
     * substring.
     * @param length
     * @param fill
     * @return 
     */
    private static String fillString(int length, String fill) {
        // Create a new String object of specified length.
        String constructed = new String(new char[length]);
        // Replace null values with the fill String and return it.
        return constructed.replace("\0", fill);
    }
    
    /**
     * Utility function. Displays a horizontal separator.
     */
    private static void displaySeparator() {
        out.println(fillString(MAX_WIDTH + 3, BORDER_SYMBOL));
    }
    
    /**
     * Utility function. Displays horizontal separator spacing.
     */
    private static void displaySeparatorSpacing() {
        String repeated = fillString(MAX_WIDTH + 1, " ");
        out.println(BORDER_SYMBOL + repeated + BORDER_SYMBOL);
    }
    
    /**
     * Utility function. Formats and displays a single line of text.
     * @param line 
     */
    private static void displayLine(String line) {
        // Add a left border before the contents.
        String finalLine = BORDER_SYMBOL + " " + line;
        // Calculate how much empty space there is to fill.
        int lengthDifference = MAX_WIDTH - line.length();
        // Fill the empty space to preserve the box.
        String emptySpace = fillString(lengthDifference, " ");
        // Add the empty space and a right border after the contents.
        finalLine += emptySpace + BORDER_SYMBOL;
        // Print the line.
        out.println(finalLine);
    }
    
    /**
     * Displays a specific string or strings in a box. 
     * @param multiple
     */
    public static void displayText(String... multiple) {
        // Display the top separator and spacing.
        displaySeparator();
        displaySeparatorSpacing();
        
        // Iterate over each String supplied as an argument.
        for (String text : multiple) {
            if (text.length() < MAX_WIDTH) {
                // If it's a short string, just display it as a line.
                displayLine(text);
            }
            else {
                // If it's a long string, break it apart into words.
                String[] words = text.split(" ");
                
                // Prepare a temporary holder for preformatted lines.
                String tempLine = "";

                // Set up an ArrayList to hold our formatted lines.
                ArrayList<String> lines = new ArrayList<>();

                /* Iterate over each word and add it to the temporary line
                   until we hit the maximum width. */
                for (String word : words) {
                    if (tempLine.length() + word.length() < (MAX_WIDTH - 1)) {
                        tempLine += word + ' ';
                    }
                    else {
                        // Add the line to our ArrayList.
                        lines.add(tempLine);
                        // Do NOT forget to add the final word to the next line.
                        tempLine = word + ' ';
                    }
                }
                // Do NOT forget to add the final line to our ArrayList.
                lines.add(tempLine);
                
                // Display each line in the block of text.
                for (String line : lines) {
                    displayLine(line);
                }
            }
            // Display spacing after each block of text.
            displaySeparatorSpacing();
        }
        // Display the bottom separator.
        displaySeparator();
    }
}