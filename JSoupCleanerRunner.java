import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.NodeTraversor;
import org.jsoup.safety.Whitelist;

public class JSoupCleanerRunner {
  public static void main (String[] args) {
    try {
      
      // Read the example HTML file into a string
      String html = U.readFile("test.html");
      
      // Clean the HTML
      Whitelist whitelist = Whitelist
      .relaxed()
      .addTags(
        "header",
        "nav",
        "section",
        "article",
        "aside",
        "footer"
      );
      html = Jsoup.clean(html, whitelist);
      
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
