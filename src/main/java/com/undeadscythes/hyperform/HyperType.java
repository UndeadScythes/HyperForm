package com.undeadscythes.hyperform;

/**
 * The type of action defined by an {@link HyperOp}.
 *
 * @author UndeadScythes
 */
public enum HyperType {
    /**
     * Replace an escape sequence with a string.
     */
    REPLACE,
    /**
     * Run some code on occurrence of escape string.
     */
    SCRIPT,
    /**
     * Place a {@link HyperText} at this point.
     */
    INSERT,
    /**
     * Parse an external {@link HyperText} and insert the output.
     */
    PARSE;
}
