import java.io.File;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.NodeTraversor;

public class HTMLCleanerRunner {
  public static void main (String[] args) {
    try {
      
      // Read the example HTML file into a string
      String html = U.readFile("simple.html");
      
      // Parse the HTML into a Document...
      Document document = Jsoup.parse(html);
      
      // ...and print it out.
      PrettyPrinter prettyPrinter = new PrettyPrinter();
      NodeTraversor nodeTraversor = new NodeTraversor(prettyPrinter);
      nodeTraversor.traverse(document);
      
    } catch (Exception exception) {
      // Catch all
      throw new RuntimeException(exception);
    }
  }
}
