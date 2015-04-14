import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.NodeVisitor;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;

public class HTMLCleaner implements NodeVisitor {
  
  Document cleanDocument;
  Node previouslyReadNode;
  Node previouslyCreatedNode;
  static final Set<String> tagsToInclude = new HashSet<String>(Arrays.asList(new String[] {
    "p",
    "a",
    "ul",
    "ol",
    "li",
    "hr",
    "em",
    "b",
    "i",
    "h1",
    "h2",
    "h3",
    "h4",
    "h5",
    "h6",
    "q",
    "img"
  }));
    
  HTMLCleaner() {
    this.cleanDocument = new Document("");
    this.previouslyReadNode = null;
    this.previouslyCreatedNode = null;
  }
  
  public void head(Node node, int depth) {
    
    if (node instanceof Element) {
      /* What should happen here:
       * - Remove DIVs completely
       * - Extract everything from SPANs and remove them
       * - Remove all classes
       */
      
      // Intro
      Element element = (Element) node;
      
      // Remove all classes
      element.removeAttr("class");
      
      if (tagsToInclude.contains(element.tagName())) {
        
      }
      
    } else if (node instanceof TextNode) {
      /* What should happen here:
       * - Ignore whitespace-only text nodes
       */
      
      // Intro
      TextNode textNode = (TextNode) node;
      String text = textNode.text();
      
      if (text.matches("\\s*")) {
        // Whitespace
      }
    } else if (node instanceof DataNode) {
      DataNode dataNode = (DataNode) node;
      
    } else {
      // Do nothing, yet.
    }
    
    this.previouslyReadNode = node;
  }
  
  public void tail(Node node, int depth) {
    // Do nothing, at the moment.
  }
  
}
