package br.com.claudiobs07.newfeatures.string;

import org.junit.Test;

import java.lang.invoke.MethodHandles;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StringDemoTest {

    //9

    /** IntStream chars(): Returns a stream of int zero-extending the char values from this sequence. */
    /** IntStream codePoints()​: Returns a stream of code point values from this sequence. */
    @Test
    public void testChars() {
        assertEquals("-P-r-o-g-r-a-m-m-i-n-g- -W-i-t-h- -J-a-v-a", "Programming With Java".chars().mapToObj(c -> "-"+ (char) c).collect(Collectors.joining()));
        assertEquals("-P-r-o-g-r-a-m-m-i-n-g- -W-i-t-h- -J-a-v-a", "Programming With Java".codePoints().mapToObj(c -> "-"+ (char) c).collect(Collectors.joining()));
    }

    //11

    @Test
    public void testStrip() {
        String string = "     casa    ";
        assertEquals("casa", string.trim());
        assertEquals("casa", string.strip());
        assertEquals("casa    ", string.stripLeading());
        assertEquals("     casa", string.stripTrailing());
    }

    @Test
    public void testIsBlank() {
        assertTrue("     ".isBlank());
    }

    @Test
    public void testLines() {
        assertEquals(3, "casa\nparque\nchopp".lines().count());
    }

    @Test
    public void testRepeat() {
        assertEquals("XPTOXPTOXPTOXPTOXPTO", "XPTO".repeat(5));
    }

    //12

    @Test
    public void testIndent() {
        assertEquals("    This is\n    a multiline\n    string\n", "This is\na multiline\nstring".indent(4));
    }

    @Test
    public void testTransform() {
        assertEquals("Hello World", "Hello".transform(input -> input + " World"));
    }

    /** String class implements two additional interfaces java.lang.constant.Constable and java.lang.constant.ConstantDesc */
    @Test
    public void testDescribeConstable() {
        assertTrue("ABC".describeConstable().isPresent());
    }

    @Test
    public void testResolveConstableDesc() {
        assertEquals("ABC", "ABC".resolveConstantDesc(MethodHandles.lookup()));
    }

}