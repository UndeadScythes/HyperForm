package hyperformtest;

import com.undeadscythes.hyperform.*;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * @author UndeadScythes
 */
public class HyperTextTest {
    @Test
    public void testConcat() {
        assertEquals("concat()", "test-test", new HyperText(new HyperText("test-"), new HyperText("test")).getMarkup());
    }
}
