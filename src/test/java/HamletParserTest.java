import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
    }

    @Test
    public void testChangeHoratioToTariq() {
    }

    @Test
    public void testFindHoratio() {
        Matcher match = hamletParser.findHoratio();

        Assert.assertTrue(match.find());
        Assert.assertEquals("Horatio", match.group());
    }

    @Test
    public void testFindHamlet() {
        Matcher match = hamletParser.findHamlet();

        Assert.assertTrue(match.find());
        Assert.assertEquals("Hamlet", match.group());
    }
}