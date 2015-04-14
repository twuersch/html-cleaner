import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.nodes.DataNode;
import org.jsoup.select.NodeVisitor;

public class PrettyPrinter implements NodeVisitor {
  
  public void head(Node node, int depth) {
    
    System.out.print(U.repeat(" ", depth * 2));
    
    if (node instanceof Element) {
      
      Element element = (Element) node;
      System.out.print("ELEM " + element.tagName());
      
    } else if (node instanceof TextNode) {
      
      TextNode textNode = (TextNode) node;
      String text = textNode.text();
      System.out.print("TEXT: " + textNode.text().substring(0, Math.min(textNode.text().length(), 20)));
      
      if (text.matches("\\s*")) {
        System.out.print("(Whitespace)");
      }
      
    } else if (node instanceof DataNode) {
      
      DataNode dataNode = (DataNode) node;
      System.out.print("DATA");
      
    } else {
      
      System.out.print("(other)");
      
    }
    
    System.out.print("\n");
  }
  
  public void tail(Node node, int depth) {
    // Do nothing.
  }
}
