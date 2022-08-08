import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public void constructorTest() {
        HamletParser hamletParser1 = new HamletParser();
    }

    @Test
    public void testChangeHamletToLeon() {
        hamletParser.changeHamletToLeon(hamletParser.findHamlet());

        Pattern p = Pattern.compile("Hamlet", Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(hamletParser.getHamletData());

        int counter = 0;
        while(matcher.find()) {
            counter++;
        }

        Assert.assertEquals(0, counter);
    }

    @Test
    public void testChangeHoratioToTariq() {
        hamletParser.changeHoratioToTariq(hamletParser.findHoratio());

        Pattern p = Pattern.compile("Horatio", Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(hamletParser.getHamletData());

        int counter = 0;
        while(matcher.find()) {
            counter++;
        }

        Assert.assertEquals(0, counter);
    }

    @Test
    public void testFindHoratio() {
        Matcher match = hamletParser.findHoratio();

        int counter = 0;
        while (match.find()) {
            counter++;
            Assert.assertTrue("Horatio".equals(match.group()) || "HORATIO".equals(match.group()));
        }
        System.out.println(counter);
    }

    @Test
    public void testFindHamlet() {
        Matcher match = hamletParser.findHamlet();

        int counter = 0;
        while (match.find()) {
            counter++;
            Assert.assertTrue("Hamlet".equals(match.group()) || "HAMLET".equals(match.group()));
        }
        System.out.println(counter);
    }

    @Test
    public void writeFileTest() throws FileNotFoundException, UnsupportedEncodingException {
        hamletParser.parseHamlet();
    }
}