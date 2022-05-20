import static org.junit.Assert.*; // Imports a package needed for JUnit
import org.junit.*; // Imports another package needed for JUnit
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest { // The class itself
    @Test // Tells program that this is a test
    public void addition() { // Method for the test
        assertEquals(2, 1 + 1); // Compares the expected vs output
    }
    
    @Test
    public void testGetLinks() throws IOException {
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("https://something.com", "some-thing.html"), links);
    }

    @Test
    public void testMiddleFile() throws IOException {
        Path fileName = Path.of("test-fileinmiddle.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("ucsd.edu"), links);
    }

    @Test
    public void testBackwardFile() throws IOException {
        Path fileName = Path.of("test-filebackward.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("ucsd.edu"), links);
    }

    @Test
    public void testSnippet1() throws IOException {
        Path fileName = Path.of("test-snippet1.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("url.com", "google.com", "google.com", "ucsd.edu"), links);
    }

    @Test
    public void testSnippet2() throws IOException {
        Path fileName = Path.of("test-snippet2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("a.com", "a.com", "example.com"), links);
    }

    @Test
    public void testSnippet3() throws IOException {
        Path fileName = Path.of("test-snippet3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("https://www.twitter.com", 
                    "https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule", 
                    "https://cse.ucsd.edu/"), links);
    }
}



