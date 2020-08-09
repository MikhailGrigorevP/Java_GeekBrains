package theme7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameActionListener implements ActionListener {
    private final int row;
    private final int cell;
    private final GameButton button;

    public GameActionListener(int row, int cell, GameButton gButton){
        this.row = row;
        this.cell = cell;
        this.button = gButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameBoard board = button.getBoard();

        if(board.isTurnable(row, cell)){
            updateByPlayersData(board);

            if(board.isFull()){
                board.getGame().showMessage("Draw");
                board.emptyField();
            }
            else{
                updateByAiData(board);
            }
        }
        else{
            board.getGame().showMessage("Incorrect turn");
        }
    }

    private void updateByAiData(GameBoard board) {


        int[] _x = new int[GameBoard.dimension * GameBoard.dimension];
        int[] _y = new int[GameBoard.dimension * GameBoard.dimension];
        int maxNear = 0;
        int num = 0;

        char AISign = board.getGame().getCurrentPlayer().getPlayerSign();

        for(int i = 0; i < GameBoard.dimension ; i++){
            for(int j = 0; j < GameBoard.dimension ; j++) {
                int near = 0;
                if(board.isTurnable(i, j)){
                    if (i > 0) {
                        if(board.getFieldMark(i-1, j) == AISign)
                            near += 1;
                        if(j > 0 && board.getFieldMark(i-1, j-1) == AISign)
                            near += 1;
                        if(j < GameBoard.dimension-1 && board.getFieldMark(i-1, j+1) == AISign)
                            near += 1;
                    }
                    if (i < GameBoard.dimension-1) {
                        if(board.getFieldMark(i+1, j) == AISign)
                            near += 1;
                        if(j > 0 && board.getFieldMark(i+1, j-1) == AISign)
                            near += 1;
                        if(j < GameBoard.dimension-1 && board.getFieldMark(i+1, j+1) == AISign)
                            near += 1;
                    }
                    if(j > 0 && board.getFieldMark(i, j-1) == AISign)
                        near += 1;
                    if(j < GameBoard.dimension-1 && board.getFieldMark(i, j+1) == AISign)
                        near += 1;
                }
                if(near > 0){
                    if (num > 0 && near > maxNear)
                        num = 0;
                    _x[num] = i;
                    _y[num] = j;
                    num += 1;
                    maxNear = num;
                }
            }
        }

        Random random = new Random();
        int x;
        int y;

        if(num != 0) {
            int pos = random.nextInt(num);
            x = _x[pos];
            y = _y[pos];
        }
        else{
            do {
                x = random.nextInt(GameBoard.dimension);
                y = random.nextInt(GameBoard.dimension);
            } while(!board.isTurnable(x, y));
        }
        board.updateGameField(x, y);

        int cellIndex = GameBoard.dimension * x + y;
        board.getButton(cellIndex).setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));
        /*
        int x, y;
        Random rnd = new Random();

        do{
            x = rnd.nextInt(GameBoard.dimension);
            y = rnd.nextInt(GameBoard.dimension);
        } while (!board.isTurnable(x, y));

        board.updateGameField(x, y);

        int cellIndex = GameBoard.dimension * x + y;
        board.getButton(cellIndex).setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));
*/
        if(board.checkWin()){
            button.getBoard().getGame().showMessage("AI win!");
            board.emptyField();
        }
        else{
            board.getGame().passTurn();
        }
    }

    private void updateByPlayersData(GameBoard board) {
        board.updateGameField(row, cell);
        button.setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));

        if(board.checkWin()){
            button.getBoard().getGame().showMessage("You win!");
            board.emptyField();
        }
        else{
            board.getGame().passTurn();
        }
    }
}
