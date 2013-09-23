package com.undeadscythes.hyperform;

import java.util.logging.*;

/**
 * The {@link HyperOp} structure describes an action that must be taken when
 * parsing an HTML document.
 *
 * @author UndeadScythes
 */
public class HyperOp {
    private static final Logger LOGGER = Logger.getLogger(HyperOp.class.getName());

    private final HyperType type;
    private final Object action;

    /**
     * Provide a {@link HyperType} and some {@link Object} action associated
     * with the given type.
     */
    public HyperOp(final HyperType type, final Object action) {
        this.type = type;
        this.action = action;
    }

    /**
     * Default the type to {@link HyperType#REPLACE REPLACE} and provide the
     * {@link String} to replace with.
     */
    public HyperOp(final String sequence) {
        this(HyperType.REPLACE, sequence);
    }

    /**
     * Default the type to {@link HyperType#INSERT INSERT} and provide the
     * {@link HyperText} that should be inserted.
     */
    public HyperOp(final HyperText text) {
        this(HyperType.INSERT, text);
    }

    /**
     * Default the type to {@link HyperType#SCRIPT SCRIPT} and provide the
     * {@link HyperScript} that should run.
     */
    public HyperOp(final HyperScript script) {
        this(HyperType.SCRIPT, script);

    }

    /**
     * Get the {@link HyperType} of this {@link HyperOp}.
     */
    public HyperType getType() {
        return type;
    }

    /**
     * Get the {@link Object} to be used in conjuction with this operation.
     */
    public Object getAction() {
        return action;
    }
}
