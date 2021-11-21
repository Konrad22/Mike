import java.util.ArrayList;
import java.util.List;

public class Game
{
    Player Red_Player = new Player(FrameBuilder.RED_PLAYER);
    Player Blue_Player = new Player(FrameBuilder.BLUE_PLAYER);
    int radian = 20;
    List<GamePiece> createGamePieces()
    {
        List<GamePiece> gamePieceList = new ArrayList<>();
        for(int i = 0; i < 21; i++)
        {
            if(i>17)
            {
                gamePieceList.addAll(createGridOfGamePieces(GameBoardDrawer.x + GameBoardDrawer.s*(20-i), GameBoardDrawer.x + GameBoardDrawer.s*(20-i), GameBoardDrawer.s*(i-17)));          //figure out the real numbers in dependency of i
            }
            else if (i > 8)
            {
                GamePiece gamePiece = new GamePiece(GameBoardDrawer.x + i*40, 20, radian, Blue_Player);               //figure out the numbers in dependency of i
                gamePieceList.add(gamePiece);
            }
            else
            {
                GamePiece gamePiece = new GamePiece(GameBoardDrawer.x + i*40, 900, radian, Red_Player);             //figure out the numbers in dependency of i
                gamePieceList.add(gamePiece);
            }

        }
        return gamePieceList;
    }

    List<BoardMarker> createBoardMarkers()
    {
        List<BoardMarker> boardMarkerList = new ArrayList<>();
        for(int i = 0; i < 3; i++)
        {
            boardMarkerList.addAll(createGridOfBoardMarkers(GameBoardDrawer.x + GameBoardDrawer.s*(2-i), GameBoardDrawer.x + GameBoardDrawer.s*(2-i), GameBoardDrawer.s*(i+1)));
        }
        return boardMarkerList;
    }

    /*List<GamePiece> createTakenGamePieceList()
    {
        List<GamePiece> takenGamePieceList = new ArrayList<>();
        for (int i = 0; i < 14; i++)
        {
                takenGamePieceList.add(i, );
                takenGamePieceList.add(i + 7, );
        }
        return takenGamePieceList;
    }*/

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

    private List<BoardMarker> createGridOfBoardMarkers(int x, int y, int gap)
    {
        List<BoardMarker> boardMarkerList = new ArrayList<>();
        for (int i = 0; i < 9; i++)
        {
            boardMarkerList.add(new BoardMarker(x + (i % 3) * gap, y + (i / 3) * gap, radian/2));
        }
        boardMarkerList.remove(4);
        return boardMarkerList;
    }
}
