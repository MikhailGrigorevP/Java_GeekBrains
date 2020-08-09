package theme7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard extends JFrame {
    static int dimension = 3;
    static int cellSize = 150;
    private char[][] gameField;
    private GameButton[] gameButtons;

    private final Game game;

    static char nullSymbol = '\u0000';

    public GameBoard(Game currentGame){
        this.game = currentGame;
        initField();
    }

    public void initField(){
        setBounds(cellSize * dimension, cellSize * dimension, 400, 300);
        setTitle(("TicTocToe"));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();
        JButton newGameButton = new JButton("New game");
        newGameButton.addActionListener(e -> emptyField());

        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.add(newGameButton);
        controlPanel.setSize(cellSize * dimension, 150);

        JPanel gameFieldPanel = new JPanel();
        gameFieldPanel.setLayout(new GridLayout(dimension, dimension));
        gameFieldPanel.setSize(cellSize * dimension, cellSize * dimension);

        gameField = new char[dimension][dimension];
        gameButtons = new GameButton[dimension * dimension];

        for(int i = 0; i < (dimension * dimension); i++){
            GameButton fieldButton = new GameButton(i, this);
            gameFieldPanel.add(fieldButton);
            gameButtons[i] = fieldButton;
        }

        getContentPane().add(controlPanel, BorderLayout.NORTH);
        getContentPane().add(gameFieldPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    void emptyField() {
        for(int i = 0; i < (dimension * dimension); i++){
            gameButtons[i].setText("");

            int x = i / GameBoard.dimension;
            int y = i % GameBoard.dimension;

            gameField[x][y] = nullSymbol;
        }
    }

    Game getGame(){
        return game;
    }

    char getFieldMark(int x, int y){
        return gameField[y][x];
    }

    boolean isTurnable(int x, int y){
        return gameField[y][x] == nullSymbol;
    }

    void updateGameField(int x, int y){
        gameField[y][x] = game.getCurrentPlayer().getPlayerSign();
    }

    boolean isFull(){
        boolean result = true;

        for(int i = 0; i < (dimension * dimension); i++){

            int x = i / GameBoard.dimension;
            int y = i % GameBoard.dimension;

            if (gameField[x][y] == nullSymbol) {
                result = false;
                break;
            }
        }
        return result;
    }

    boolean checkWin(){
        char playerSymbol = getGame().getCurrentPlayer().getPlayerSign();
        return checkWinDiagonals(playerSymbol) || checkWinLines(playerSymbol);
    }

    private boolean checkWinDiagonals(char playerSymbol) {
        boolean main, reverse;
        main = true;
        reverse = true;

        for (int num = 0; num < dimension; num++) {
            main &= (gameField[num][num] == playerSymbol);
            reverse &= (gameField[dimension - 1 - num][num] == playerSymbol);
        }

        return main || reverse;
    }

    private boolean checkWinLines(char playerSymbol) {
        boolean cols, rows, result;
        result = false;

        for (int col = 0; col < dimension; col++) {
            cols = true;
            rows = true;

            for (int row = 0; row < dimension; row++) {
                cols &= (gameField[col][row] == playerSymbol);
                rows &= (gameField[row][col] == playerSymbol);
            }

            if(cols || rows){
                result = true;
                break;
            }
        }

        return result;
    }

    public GameButton getButton(int buttonIndex){
        return gameButtons[buttonIndex];
    }

}
