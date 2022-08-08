import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
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
        hamletParser.changeHamletToLeon(hamletParser.findHamlet());
    }

    @Test
    public void testChangeHoratioToTariq() {
        hamletParser.changeHoratioToTariq(hamletParser.findHoratio());
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

    @Test
    public void writeFileTest() throws FileNotFoundException, UnsupportedEncodingException {
        hamletParser.parseHamlet();
    }
}