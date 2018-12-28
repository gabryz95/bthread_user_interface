package gui.model;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyString;

public class StringParsingTest {

    @Mock
    private Parser parser;

    String line1 = "(READY) 4";
    String line2 = "(MUTRELEASE) 2 0x55c06dcb2040";
    String line3 = "Philosopher 3 is hungry";

    @Test
    public void parsingTest01(){
        Bthread bthread1 = Parser.parsing(line1);

        assertEquals(4,bthread1.getPid());
        assertEquals("READY",bthread1.getStatus());
        assertNull(bthread1.getMemory());
    }

    @Test
    public void parsingTest02(){
        Bthread bthread2 = Parser.parsing(line2);

        assertEquals("MUTRELEASE",bthread2.getStatus());
        assertEquals("0x55c06dcb2040",bthread2.getMemory());
        assertEquals(2,bthread2.getPid());
    }

    @Test
    public void parsingTest03(){
        Bthread bthread3 = Parser.parsing(line3);

        assertEquals(0,bthread3.getPid());
        assertNull(bthread3.getMemory());
        assertNull(bthread3.getStatus());
    }

    @Test
    public void parsingTest04() {
        parser = Mockito.mock(Parser.class);
        parser.parsing2(anyString());
        Mockito.verify(parser, Mockito.times(1)).parsing2(anyString());
    }

    @Test
    public void parsingTest05() {
        parser = Mockito.mock(Parser.class);
        parser.parsing2(null);
        Mockito.verify(parser, Mockito.times(1)).parsing2(null);
    }

}