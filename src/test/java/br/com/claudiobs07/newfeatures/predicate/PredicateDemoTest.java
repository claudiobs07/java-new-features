package br.com.claudiobs07.newfeatures.predicate;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateDemoTest {

    // 11

    @Test
    public void testPredicateNot() {
        Predicate<Integer> lessThanThree = x -> x < 3;
        List<Integer> input = List.of(1, 2, 3, 4);
        List<Integer> result = input.stream().filter(Predicate.not(lessThanThree)).collect(Collectors.toList());
        Assert.assertEquals("[3, 4]", result.toString());
    }

}