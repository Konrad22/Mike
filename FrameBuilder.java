import java.awt.*;

import static java.awt.Color.BLACK;
import static java.awt.Color.LIGHT_GRAY;

public class FrameBuilder
{
  
  static Frame myFrame;
  final static Color BACKGROUND_COLOR = LIGHT_GRAY;
  final static Color LINE_COLOR = BLACK;


  public static void main(String args[])
  {
    myFrame = new Frame("A simple Frame");
    //myFrame.setLayout(new FlowLayout());
    myFrame.add(new GameBoardDrawer());
    myFrame.pack(); // automat. resizing
    myFrame.setVisible(true);
  }
}
