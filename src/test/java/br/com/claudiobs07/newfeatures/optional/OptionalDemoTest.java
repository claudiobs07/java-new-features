package br.com.claudiobs07.newfeatures.optional;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalDemoTest {

    //9

    @Test
    public void testOptionalStream() {
        List<Integer> result1 = Optional.of(List.of(2, 4, 6, 8)).stream().flatMap(Collection::stream).filter(x -> x < 5).collect(Collectors.toList());
        Assert.assertEquals("[2, 4]", result1.toString());

        List<Integer> input = null;
        List<Integer> result2 = Optional.ofNullable(input).stream().flatMap(Collection::stream).filter(x -> x < 5).collect(Collectors.toList());
        Assert.assertEquals("[]", result2.toString());
    }

    @Test
    public void testIfPresentOrElse() {
        String input = "java";
        Optional.ofNullable(input)
                .filter(i -> i.startsWith("a"))
                .ifPresentOrElse(
                        i -> System.out.println("something to do"),
                        () -> System.out.println("do something")
                );
    }

    @Test
    public void testOr() {
        String input1 = null;
        String input2 = "groovy";
        Optional<String> inputOpt = Optional.ofNullable(input1).or(() -> Optional.of(input2));
        Assert.assertEquals("groovy", inputOpt.get());
    }

}