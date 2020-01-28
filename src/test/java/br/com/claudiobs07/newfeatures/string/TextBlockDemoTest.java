package br.com.claudiobs07.newfeatures.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TextBlockDemoTest {

    // 13 preview

    /** translates escape sequences in the string except for unicode ones. */
    @Test
    public void testStripIndent() {
        String string = """
                  a
                   b
                    c
                """;
        assertEquals("  a\n   b\n    c\n", string);
        assertEquals("  a\n   b\n    c\n", string.stripIndent());
    }

    /** strips away common whitespace from the beginning of each line. */
    @Test
    public void testTranslateEscapes() {
        String string = " a\n  b\\n   c";
        assertEquals(" a\n  b\n   c", string.translateEscapes());
    }

    /** Convenience method, equivalent of String.format(string, args) */
    @Test
    public void testFormatted() {
        String string = """
                <customer>
                     <no>%s</no>
                     <name>%s</name>
                </customer>
                """;
        assertEquals("<customer>\n     <no>51</no>\n     <name>Cachaça 51</name>\n</customer>\n", string.formatted("51", "Cachaça 51"));
    }

}