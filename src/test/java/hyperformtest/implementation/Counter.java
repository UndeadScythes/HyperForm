package hyperformtest.implementation;

import com.undeadscythes.hyperform.*;

/**
 * @author UndeadScythes
 */
public class Counter implements HyperScript {
    public int count = 0;

    public String insert(final String key) {
        count++;
        return "scripttest";
    }
}
