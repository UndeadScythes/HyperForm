package hyperformtest;

import com.undeadscythes.hyperform.*;
import hyperformtest.implementation.*;
import java.io.*;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * @author UndeadScythes
 */
public class HyperFormTest {
    private final static HyperForm PARSER = new HyperForm();
    private final static Counter COUNTER = new Counter();

    static {
        PARSER.load("replaceme1", "replacetest");
        PARSER.load("replaceme2", new HyperText("hypertest"));
        PARSER.load("replaceme3", new HyperOp(COUNTER));
    }

    @Test
    public void testPublish() {
        final File file = new File("test");
        PARSER.publish(new HyperText("test"), file);
        assertTrue(file.exists());
        assertTrue(file.delete());
    }

    @Test
    public void testConcat() {
        assertEquals("test1-test2", PARSER.concat(new HyperText[]{new HyperText("test1"), new HyperText("-"), new HyperText("test2")}).getMarkup());
    }

    @Test
    public void testParse() {
        assertEquals("replacetest\n", PARSER.parse(new HyperText("<?ged replaceme1?>")).getMarkup());
        assertEquals("replacetest\n", PARSER.parse(new HyperText("<?ged replaceme1 ?>")).getMarkup());
        assertEquals("hypertest\n", PARSER.parse(new HyperText("<?ged replaceme2?>")).getMarkup());
        assertEquals("scripttest\n", PARSER.parse(new HyperText("<?ged replaceme3?>")).getMarkup());
        assertEquals(1, COUNTER.count);
    }
}
