package br.com.claudiobs07.newfeatures.files;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDemo {

    private Path path = Paths.get("src/main/resources/files/filesDemoInput.txt"); // from sources

    private Path path1 = Paths.get(getClass().getClassLoader().getResource("files/fileDemo_match1.txt").getFile()); // from binaries

    private Path path2 = Paths.get(getClass().getClassLoader().getResource("files/fileDemo_match2.txt").getFile());

    private Path path3 = Paths.get(getClass().getClassLoader().getResource("files/fileDemo_match3.txt").getFile());

    public static void main(String[] args) throws IOException, URISyntaxException {
        var app = new FileDemo();
        app.demoReadWriteFileAsString();
//        app.demoCompareFile();
    }

    public void demoReadWriteFileAsString() throws IOException, URISyntaxException {
        // Old way: Java 8
        Files.lines(path).forEach(line -> System.out.println(line));

//        Files.writeString(readWritePath, "Three\nTwo\nOne");

//        System.out.println(Files.readString(readWritePath));
    }

    public void demoCompareFile() throws IOException {
        System.out.println("Same file, same path:");
        System.out.println(Files.isSameFile(path, path));
        System.out.println(Files.mismatch(path, path));
        System.out.println();

        System.out.println("Identical file content, but different paths:");
        System.out.println(Files.isSameFile(path1, path2));
        System.out.println(Files.mismatch(path1, path2));
        System.out.println();

        System.out.println("Different text in files:");
        System.out.println(Files.isSameFile(path, path3));
        System.out.println(Files.mismatch(path, path3));
        System.out.println();
    }
}
