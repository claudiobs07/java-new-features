package br.com.claudiobs07.newfeatures.var;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnonymousClassVarDemo {

    public static void main(String[] args) {

        // Anonymous class
        var kitty = new Object() {
	    String name = "Ella";
	    String description = "Fluffy";
        };
        System.out.println("name: " + kitty.name + ", description: " + kitty.description);


        Map<String, List<String>> catsWithDescription = Map.of(
                                                               "Jack", List.of("Super-fluffy.", "Sleeps all day long."),
                                                               "Ella", List.of("Black Bombay cat.", "Playful, fast, and agile.")
        );

        // Anonymous classes inside a list
        var cats = catsWithDescription.entrySet().stream()
		        .map(cat -> new Object() {
			    String name = cat.getKey();
			    List<String> description = cat.getValue();
		        }).collect(Collectors.toList());

        cats.forEach(cat -> System.out.println("name: " + cat.name + ", description: " + cat.description));
    }

}
