package theme7;

public class GamePlayer {
    private final char playerSign;

    public GamePlayer(boolean isRealPlayer, char playerSign){
        this.playerSign = playerSign;
    }

    public char getPlayerSign(){
        return playerSign;
    }
}
