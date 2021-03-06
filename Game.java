import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.awt.Color.*;

public class Game {
    static GameBoardDrawer gameBoardDrawer;
    Player Red_Player = new Player("Red", RED);
    Player Blue_Player = new Player("Blue",BLUE);
    Player currentPlayer = Red_Player;
    Player enemyPlayer = Blue_Player;
    int radian = 20;
    public static final Game INSTANCE = new Game();
    Stage stage = Stage.PLACE_PIECE;
    private List<GamePiece> boardMarkerList;
    private List<GamePiece> initialGamePiecesList;
    int turnsGoneBy = 0;
    GamePiece selected;
    static Frame myFrame;
    final static Color BACKGROUND_COLOR = LIGHT_GRAY;
    final static Color LINE_COLOR = BLACK;

    private Game() {

    }

    enum Stage {
        SELECT_OWN_PIECE, PLACE_PIECE, REMOVE_ENEMY_PIECE, GAME_OVER
    }

    List<GamePiece> listRemovablePieces() {
        int j = 9;
        List<GamePiece> safeList = new ArrayList<>();
        List<GamePiece> takeList = new ArrayList<>();

        for (int i = 0; i < 24; i++) {
            if (boardMarkerList.get(i).player == enemyPlayer) {

                if (checkForThree(boardMarkerList.get(i), enemyPlayer)) {
                    safeList.add(boardMarkerList.get(i));
                } else {
                    takeList.add(boardMarkerList.get(i));
                }


                j--;

                if (j == enemyPlayer.score) {
                    i = 24;
                }
            }
        }
        if (takeList.isEmpty()) {
            takeList = safeList;
        }
        return takeList;
    }

    boolean checkForThree(GamePiece activeGamePiece, Player player)
    {
        List<GamePiece> xList = new ArrayList<>();
        List<GamePiece> yList = new ArrayList<>();
        boolean xMatch;
        boolean yMatch;

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
        if(xList.size() == 6)
        {
            xList.sort(Comparator.comparingInt(g -> g.y));
            if(xList.subList(0,3).contains(activeGamePiece))
            {
                xMatch = xList.subList(0,3).stream().allMatch(gamePiece -> gamePiece.player == player);
            }
            else
            {
                xMatch = xList.subList(3,6).stream().allMatch(gamePiece -> gamePiece.player == player);
            }
        }
        else
        {
            xMatch = xList.stream().allMatch(gamePiece -> gamePiece.player == player);
        }

        if(yList.size() == 6)
        {
            yList.sort(Comparator.comparingInt(g -> g.x));
            if(yList.subList(0,3).contains(activeGamePiece))
            {
                yMatch = yList.subList(0,3).stream().allMatch(gamePiece -> gamePiece.player == player);
            }
            else
            {
                yMatch = yList.subList(3,6).stream().allMatch(gamePiece -> gamePiece.player == player);
            }
        }
        else
        {
            yMatch = yList.stream().allMatch(gamePiece -> gamePiece.player == player);
        }
        return xMatch || yMatch;
    }

    void endTurn(GamePiece activeGamePiece)
    {
        if(checkForThree(activeGamePiece, currentPlayer) && stage == Stage.PLACE_PIECE)
        {
            Game.INSTANCE.listRemovablePieces();
            stage = Stage.REMOVE_ENEMY_PIECE;
        }

        else if(stage == Stage.SELECT_OWN_PIECE)
        {
            selected = activeGamePiece;
            stage = Stage.PLACE_PIECE;
        }

        else
        {
            if(stage == Stage.REMOVE_ENEMY_PIECE)
            {
                initialGamePiecesList.get(turnsGoneBy%2 * 9 + currentPlayer.score).changeColor(enemyPlayer.color);
                initialGamePiecesList.get(turnsGoneBy%2 * 9 + currentPlayer.score).draw();
                currentPlayer.score++;
                if(currentPlayer.score > 6)
                {
                    stage = Stage.GAME_OVER;
                    gameBoardDrawer.announceWinner(Game.INSTANCE.currentPlayer.name);
                    return;
                }
            }
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
                initialGamePiecesList.get(turnsGoneBy % 2 * 9 + turnsGoneBy / 2).erase();
                stage = Stage.PLACE_PIECE;
                if(turnsGoneBy == 17)
                {
                    stage = Stage.SELECT_OWN_PIECE;
                }
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
                boardMarkerList.addAll(createGridOfGamePieces(GameBoardDrawer.x + GameBoardDrawer.s*(20-i), GameBoardDrawer.y + GameBoardDrawer.s*(20-i), GameBoardDrawer.s*(i-17)));
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

    private static void prettifying(int i, int j) {
        Game.INSTANCE.boardMarkerList.get(1 + i*8).addNeighbours(Game.INSTANCE.boardMarkerList.get(9 + j*8));
        Game.INSTANCE.boardMarkerList.get(3 + i*8).addNeighbours(Game.INSTANCE.boardMarkerList.get(11 + j*8));
        Game.INSTANCE.boardMarkerList.get(4 + i*8).addNeighbours(Game.INSTANCE.boardMarkerList.get(12 + j*8));
        Game.INSTANCE.boardMarkerList.get(6 + i*8).addNeighbours(Game.INSTANCE.boardMarkerList.get(14 + j*8));
    }

    public static void main(String[] args)
    {
        myFrame = new Frame("A simple Frame");
        myFrame.setBounds(100, 10, 1000, 1000);
        myFrame.setLayout(null);
        gameBoardDrawer = new GameBoardDrawer();
        myFrame.add(gameBoardDrawer);
        List<GamePiece> gamePieceList = Game.INSTANCE.createGamePieces();
        for (GamePiece gamePiece : gamePieceList) {
            myFrame.add(gamePiece);
        }
        myFrame.setBackground(BACKGROUND_COLOR);
        myFrame.setVisible(true);
        //ugly, but this should work
        for(int i = 0; i < 3; i++)
        {
            if(i == 1)
            {
                prettifying(i,-1);
            }

            Game.INSTANCE.boardMarkerList.get(i*8).addNeighbours(Game.INSTANCE.boardMarkerList.get(1 + i*8), Game.INSTANCE.boardMarkerList.get(3 + i*8));
            Game.INSTANCE.boardMarkerList.get(1 + i*8).addNeighbours(Game.INSTANCE.boardMarkerList.get(i*8), Game.INSTANCE.boardMarkerList.get(2 + i*8));
            Game.INSTANCE.boardMarkerList.get(2 + i*8).addNeighbours(Game.INSTANCE.boardMarkerList.get(1 + i*8), Game.INSTANCE.boardMarkerList.get(4 + i*8));
            Game.INSTANCE.boardMarkerList.get(3 + i*8).addNeighbours(Game.INSTANCE.boardMarkerList.get(i*8), Game.INSTANCE.boardMarkerList.get(5 + i*8));
            Game.INSTANCE.boardMarkerList.get(4 + i*8).addNeighbours(Game.INSTANCE.boardMarkerList.get(2+ i*8), Game.INSTANCE.boardMarkerList.get(7 + i*8));
            Game.INSTANCE.boardMarkerList.get(5 + i*8).addNeighbours(Game.INSTANCE.boardMarkerList.get(3 + i*8), Game.INSTANCE.boardMarkerList.get(6 + i*8));
            Game.INSTANCE.boardMarkerList.get(6 + i*8).addNeighbours(Game.INSTANCE.boardMarkerList.get(5 + i*8), Game.INSTANCE.boardMarkerList.get(7 + i*8));
            Game.INSTANCE.boardMarkerList.get(7 + i*8).addNeighbours(Game.INSTANCE.boardMarkerList.get(4 + i*8), Game.INSTANCE.boardMarkerList.get(6 + i*8));

            if(i != 2)
            {
                prettifying(i, i);
            }
            else
            {
                prettifying(i,0);
            }
        }
    }
}
