import java.awt.*;

public class FrameBuilder
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
