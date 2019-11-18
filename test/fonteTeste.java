import java.awt.Font;
import java.awt.GraphicsEnvironment;

public class fonteTeste {
 public static void main(String[] args) {
  
  GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
  Font[] fonts = e.getAllFonts();
  
  for (Font fontTmp : fonts) {
   System.out.println(fontTmp.getFontName());
  }
 }
}