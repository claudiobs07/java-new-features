package br.com.claudiobs07.newfeatures.var;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class SimpleVarDemo {

    public static void main(String[] args) {

        // In a string
	var cat = "Jack";

	// In a list
	var catNames = List.of("Ella", "Jelly", "Eclair", cat);

	// In a map
	var catsWithDescription = Map.of(
                     catNames.get(0), List.of("Super-fluffy.", "Sleeps all day long."),
                     catNames.get(1), List.of("Black Bombay cat.", "Playful, fast, and agile.")
	);

	// In a FOR loop
	for (var i = 0; i < catsWithDescription.size(); i++) {
	    System.out.println(catsWithDescription.get(catNames.get(i)));
	}

	// In a try-with-resources
        var filepath = "src/main/java/br/com/claudiobs07/newfeatures/var/VarDemo.java";
	try (var lines = Files.lines(Paths.get(filepath))) {
	    lines.forEach(System.out::println);
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

}
