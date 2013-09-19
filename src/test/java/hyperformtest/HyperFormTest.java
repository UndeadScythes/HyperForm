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
        assertTrue("publish()", file.exists());
        assertTrue("delete()", file.delete());
    }

    @Test
    public void testConcat() {
        assertEquals("concat()", "test1-test2", PARSER.concat(new HyperText[]{new HyperText("test1"), new HyperText("-"), new HyperText("test2")}).getMarkup());
    }

    @Test
    public void testParse() {
        assertEquals("REPLACE", "replacetest\n", PARSER.parse(new HyperText("<?ged replaceme1 ?>")).getMarkup());
        assertEquals("INSERT", "hypertest\n", PARSER.parse(new HyperText("<?ged replaceme2 ?>")).getMarkup());
        assertEquals("SCRIPT1", "scripttest\n", PARSER.parse(new HyperText("<?ged replaceme3 ?>")).getMarkup());
        assertEquals("SCRIPT2", 1, COUNTER.count);
    }
}
