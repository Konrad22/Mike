import java.awt.*;

import static java.awt.Color.*;

public class FrameBuilder
{
  
  static Frame myFrame;
  final static Color BACKGROUND_COLOR = LIGHT_GRAY;
  final static Color LINE_COLOR = BLACK;
  final static Color RED_PLAYER = RED;
  final static Color BLUE_PLAYER = BLUE;


  public static void main(String args[])
  {
    Game game = new Game();
    myFrame = new Frame("A simple Frame");
    //myFrame.setLayout(new FlowLayout());
    myFrame.add(new GameBoardDrawer(game.createGamePieces(), game.createBoardMarkers()));
    myFrame.setBackground(BACKGROUND_COLOR);
    myFrame.pack();                             // automatic resizing
    myFrame.setVisible(true);
  }
}
