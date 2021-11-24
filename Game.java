import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.awt.Color.*;

public class Game
{
    Player Red_Player = new Player(RED);
    Player Blue_Player = new Player(BLUE);
    Player currentPlayer = Red_Player;
    Player enemyPlayer = Blue_Player;
    int radian = 20;
    public static final Game INSTANCE = new Game();
    Stage stage = Stage.PLACE_PIECE;
    private List<GamePiece> boardMarkerList;
    private List<GamePiece> initialGamePiecesList;
    int turnsGoneBy = 0;

    private Game()
    {

    }

    enum Stage
    {
        SELECT_OWN_PIECE, PLACE_PIECE, REMOVE_ENEMY_PIECE
    }

    List<GamePiece> listRemovablePieces()
    {
            int j = 0;
            List<GamePiece> xList = new ArrayList<>();
            List<GamePiece> yList = new ArrayList<>();
            List<GamePiece> safeList = new ArrayList<>();
            List<GamePiece> takeList = new ArrayList<>();

            for(int i = 0; i < 24; i++)
            {
                if (boardMarkerList.get(i).player == enemyPlayer)
                {
                    for (GamePiece gamePiece : boardMarkerList)
                    {

                        if (boardMarkerList.get(i).player == enemyPlayer)
                        {
                            if (gamePiece.x == boardMarkerList.get(i).x)
                            {
                                xList.add(gamePiece);
                            }
                            if (gamePiece.y == boardMarkerList.get(i).y)
                            {
                                yList.add(gamePiece);
                            }
                        }
                    }
                }
                if (xList.stream().allMatch(gamePiece -> gamePiece.player == currentPlayer) || yList.stream().allMatch(gamePiece -> gamePiece.player == currentPlayer))
                {
                    safeList.add(boardMarkerList.get(i));
                }
                else
                {
                    takeList.add(boardMarkerList.get(i));
                }

                j++;

                if (j == enemyPlayer.numberGamePieces)
                {
                    i = 24;
                }
            }
            if(takeList.isEmpty())
            {
                takeList = safeList;
            }
            return takeList;
    }

    void takePiece(GamePiece gamePiece)
    {
        gamePiece.erase();
        if(currentPlayer == Red_Player)
        {
            initialGamePiecesList.get(9-Game.INSTANCE.currentPlayer.numberGamePieces).draw();
        }
        else
        {
            initialGamePiecesList.get(18-Game.INSTANCE.currentPlayer.numberGamePieces).draw();
        }
        Game.INSTANCE.currentPlayer.numberGamePieces--;
    }

    void endTurn(GamePiece activeGamePiece)
    {
        List<GamePiece> xList = new ArrayList<>();
        List<GamePiece> yList = new ArrayList<>();
        for(GamePiece gamePiece: boardMarkerList)
        {
            if(gamePiece.x == activeGamePiece.x)
            {
                xList.add(gamePiece);
            }
            if(gamePiece.y == activeGamePiece.y)
            {
                yList.add(gamePiece);
            }
        }

        if(xList.stream().allMatch(gamePiece -> gamePiece.player == currentPlayer) || yList.stream().allMatch(gamePiece -> gamePiece.player == currentPlayer))
        {
            stage = Stage.REMOVE_ENEMY_PIECE;
        }

        else
        {
            if (currentPlayer == Red_Player)
            {
                currentPlayer = Blue_Player;
                enemyPlayer = Red_Player;
            }
            else
            {
                currentPlayer = Red_Player;
                enemyPlayer = Blue_Player;
            }
            if(turnsGoneBy<18)
            {
                stage = Stage.PLACE_PIECE;
            }
            else
            {
                stage = Stage.SELECT_OWN_PIECE;
            }
            turnsGoneBy++;
        }
    }

    List<GamePiece> createGamePieces()
    {
        List<GamePiece> gamePieceList = new ArrayList<>();
        List<GamePiece> initialGamePiecesList = new ArrayList<>();
        List<GamePiece> boardMarkerList = new ArrayList<>();
        for(int i = 0; i < 21; i++)
        {
            if(i>17)
            {
                boardMarkerList.addAll(createGridOfGamePieces(GameBoardDrawer.x + GameBoardDrawer.s*(20-i), GameBoardDrawer.x + GameBoardDrawer.s*(20-i), GameBoardDrawer.s*(i-17)));
            }
            else if (i > 8)
            {
                GamePiece gamePiece = new GamePiece(GameBoardDrawer.x + i*40, 80, radian, Blue_Player);               //figure out the numbers in dependency of i
                initialGamePiecesList.add(gamePiece);
            }
            else
            {
                GamePiece gamePiece = new GamePiece(GameBoardDrawer.x + i*40, 900, radian, Red_Player);             //figure out the numbers in dependency of i
                initialGamePiecesList.add(gamePiece);
            }

        }
        gamePieceList.addAll(initialGamePiecesList);
        gamePieceList.addAll(boardMarkerList);
        this.boardMarkerList = boardMarkerList;
        this.initialGamePiecesList = initialGamePiecesList;
        return gamePieceList;
    }

    List<GamePiece> createTakenGamePieceList(List<GamePiece> gamePieceList)
    {
        List<GamePiece> takenGamePieceList = new ArrayList<>();
        for (int i = 0; i < 7; i++)
        {
                takenGamePieceList.add(i, gamePieceList.get(i));
                takenGamePieceList.add(i + 7, gamePieceList.get(i + 9));
        }
        return takenGamePieceList;
    }

    private List<GamePiece> createGridOfGamePieces(int x, int y, int gap)
    {
        List<GamePiece> gamePieceList = new ArrayList<>();
        for (int i = 0; i < 9; i++)
        {
            gamePieceList.add(new GamePiece(x + (i % 3) * gap, y + (i / 3) * gap, radian));
        }
        gamePieceList.remove(4);
        return gamePieceList;
    }

    static Frame myFrame;
    final static Color BACKGROUND_COLOR = LIGHT_GRAY;
    final static Color LINE_COLOR = BLACK;


    public static void main(String args[])
    {
        myFrame = new Frame("A simple Frame");
        myFrame.setBounds(100, 10, 1000, 1000);
        myFrame.setLayout(null);
        myFrame.add(new GameBoardDrawer());
        List<GamePiece> gamePieceList = Game.INSTANCE.createGamePieces();
        for (int i = 0; i < gamePieceList.size(); i++) {
            GamePiece gamePiece = gamePieceList.get(i);
            myFrame.add(gamePiece);
        }
        myFrame.setBackground(BACKGROUND_COLOR);
        //myFrame.pack();                             // automatic resizing
        myFrame.setVisible(true);
    }

    //public static void main(String args[]) {
        //add all the lists to the Game Pieces

}
