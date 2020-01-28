package br.com.claudiobs07.newfeatures.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionDemoTest {

    //9

    @Test
    public void testTakeWhile() {
        List<Integer> result = Stream.of(2, 4, 6, 8, 9, 10, 12).takeWhile(n -> n % 2 == 0).collect(Collectors.toList());
        Assert.assertEquals("[2, 4, 6, 8]", result.toString());
    }

    @Test
    public void testDropWhile() {
        List<Integer> result = Stream.of(2, 4, 6, 8, 9, 10, 12).dropWhile(n -> n % 2 == 0).collect(Collectors.toList());
        Assert.assertEquals("[9, 10, 12]", result.toString());
    }

    //10

    /** java.util.List, java.util.Map and java.util.Set  */
    @Test(expected = UnsupportedOperationException.class)
    public void testOf() {
        List<Integer> input = List.of(1, 2, 3, 4);
        input.add(4);
    }

    /** java.util.List, java.util.Map and java.util.Set  */
    @Test(expected = UnsupportedOperationException.class)
    public void testCopyOf() {
        List<Integer> input = List.of(1, 2, 3, 4);
        List<Integer> copyList = List.copyOf(input);
        copyList.add(4);
    }

    /** java.util.List, java.util.Map and java.util.Set  */
    @Test(expected = UnsupportedOperationException.class)
    public void testUnmodifiable() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4).stream().collect(Collectors.toUnmodifiableList());
        input.add(5);
    }



}