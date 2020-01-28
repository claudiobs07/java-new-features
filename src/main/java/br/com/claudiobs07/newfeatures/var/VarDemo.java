package br.com.claudiobs07.newfeatures.var;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class VarDemo {

    public static void main(String[] args) {
//        simpleWithVar();
//        coolThingsWithVar();
        varInLambadaParameters();
    }

    public static void simpleWithVar() {
        var cat = "Jack";

        var catNames = List.of("Ella", "Jelly", "Eclair", "Jack");

        var catsWithDescription = Map.of(//
                "Jack", List.of("Super-fluffy.", "Sleeps all day long."), //
                "Ella", List.of("Black Bombay cat.", "Playful, fast, and agile.")//
        );

        // In a FOR loop
        for (var i = 0; i < 10; i++) {
            System.out.println(i);
        }

        // in a try-with-resources
        try (Stream<String> lines = Files.lines(Paths.get("src/main/java/br/com/claudiobs07/newfeatures/var/VarDemo.java"))) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void coolThingsWithVar() {
        // With anonymous classes
        Object ella = new Object() {
            String name = "Ella";
            String description = "Fluffy";
        };
        // System.out.println(ella.name); // doesn't compile with Object, compiles with a var

        Map<String, List<String>> catsWithDescription = Map.of(//
                "Jack", List.of("Super-fluffy.", "Sleeps all day long."), //
                "Ella", List.of("Black Bombay cat.", "Playful, fast, and agile.")//
        );

        List<Object> catObjects = catsWithDescription.entrySet().stream()
                .map(cat -> new Object() {
                    String name = cat.getKey();
                    List<String> description = cat.getValue();
                }).collect(Collectors.toList());

//         catObjects.forEach(cat -> System.out.println(cat.name + ": " + cat.description)); // doesn't compile with Object, compiles with var
    }

    public static void varInLambadaParameters() {
        AddressOperation toSingleLine =
                (String line1, Integer aptNumber, Integer zip) -> line1 + ", apt. " + aptNumber + "  " + zip;

//        AddressOperation toSingleLine =
//                (var line1, @NotNull var aptNumber, @Nullable var zip) -> line1 + ", apt. " + aptNumber + "  " + zip;

        IntStream.of(1, 2, 3).mapToObj(x -> toSingleLine.build(null, null, null)).collect(Collectors.toList());
    }

    @FunctionalInterface
    interface AddressOperation {
        String build(String line1, Integer aptNumber, Integer zip);
    }

}
