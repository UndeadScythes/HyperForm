package com.undeadscythes.hyperform;

/**
 * A {@link HyperText} contains data pertaining to a section of HTML for
 * manipulation within {@link HyperForm}.
 *
 * @author UndeadScythes
 */
public class HyperText {
    private final String parsedMarkup;

    /**
     * Load a given piece of markup.
     */
    public HyperText(final String markup) {
        parsedMarkup = markup;
    }

    /**
     * Copy the contents of another {@link HyperText}.
     */
    public HyperText(final HyperText text) {
        parsedMarkup = text.getMarkup();
    }

    /**
     * Concatenate the contents of two other {@link HyperText}s.
     */
    public HyperText(final HyperText text1, final HyperText text2) {
        parsedMarkup = text1.getMarkup().concat(text2.getMarkup());
    }

    /**
     * Get the markup stored in this {@link HyperText}.
     */
    public String getMarkup() {
        return parsedMarkup;
    }
}
