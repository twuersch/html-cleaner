import java.io.File;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.NodeTraversor;

public class HTMLCleanerRunner {
  public static void main (String[] args) {
    try {
      
      // Read the example HTML file into a string
      String html = U.readFile("test.html");
      
      // Parse the HTML into a Document...
      Document document = Jsoup.parse(html);
      
      // ... and clean it...
      HTMLCleaner htmlCleaner = new HTMLCleaner();
      NodeTraversor nodeTraversor = new NodeTraversor(htmlCleaner);
      nodeTraversor.traverse(document);
      
      // ...and print it out.
      PrettyPrinter prettyPrinter = new PrettyPrinter();
      nodeTraversor = new NodeTraversor(prettyPrinter);
      nodeTraversor.traverse(document);
      
    } catch (Exception exception) {
      // Catch all
      throw new RuntimeException(exception);
    }
  }
}
