import java.awt.*;

public class CreateFrame
{
  
  static Frame myFrame;
  
  public static void main(String args[])
  {
    myFrame = new Frame("A simple Frame");
    myFrame.setLayout(new FlowLayout());
    myFrame.pack(); // automat. resizing
    myFrame.setVisible(true);
  }
}
