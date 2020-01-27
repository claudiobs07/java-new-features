package br.com.claudiobs07.newfeatures.string;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TextBlockDemoTest {

    private String stringTextBlock;

    @Before
    public void before() {
        stringTextBlock = """
                    Larguei a
                    bebida...
                    só não lembro
                    aonde.
                """;
    }

    // 13 preview

    /** translates escape sequences in the string except for unicode ones. */
    @Test
    public void testStripIndent() {
        assertEquals("", stringTextBlock.stripIndent());
    }

    /** strips away common whitespace from the beginning of each line. */
    @Test
    public void testTranslateEscapes() {
        assertEquals("", stringTextBlock.translateEscapes());
    }

    /** Convenience method, equivalent of String.format(string, args) */
    @Test
    public void testFormatted() {
        assertEquals("", stringTextBlock.formatted());
    }

}