package com.example.gadkh.tictactoe.Logic;

/**
 * Created by gadkh on 25/10/2018.
 */

public class Game {
    final static int[][]winMatrix=new int[][]{
            {0,1,2},
            {3,4,5},
            {6,7,8},
            {0,3,6},
            {1,4,7},
            {2,5,8},
            {0,4,8},
            {2,4,6}
    };
    private int turn;
    private Board boardGame;
    private ComputerPlayer computerPlayer;

    public  Game()
    {
        this.boardGame=new Board();
        this.turn=0; // 0 meaning to my turn, 1 meaning to computer turn
        this.computerPlayer=new ComputerPlayer();
    }

    public Board getBoardGame()
    {
        return this.boardGame;
    }

    public void changeTurn()
    {
        if (this.turn==0)
            this.turn=1;
        else
            this.turn=0;
    }

    public void playTile(int position)
    {
        boolean playerPlayed=false;
        if(turn==0)
        {
             playerPlayed=this.boardGame.setPositionTileToX(position);
             this.computerPlayer.setPlayerBoard(position);
        }
        else
        {
             playerPlayed=this.boardGame.setPositionTileToO(position);
             this.computerPlayer.setComputerBoard(position);
        }
        if(playerPlayed)
        {
            int hasWinner=0; //checking if we has a winner, 0 meaning that we have not winner yet
            hasWinner=checkWinner();
            if(hasWinner==0)
            {
                changeTurn();
            }
        }
    }
    public int checkWinner()
    {
        for(int i=0;i<winMatrix.length;i++)
        {
            if(this.boardGame.getTileStatus(winMatrix[i][0]).equals(this.boardGame.getTileStatus(winMatrix[i][1]))&&
                    this.boardGame.getTileStatus(winMatrix[i][1]).equals(this.boardGame.getTileStatus(winMatrix[i][2]))&&
                    !this.boardGame.getTileStatus(winMatrix[i][0]).equals("")&& !this.boardGame.getTileStatus(winMatrix[i][1]).equals("")&&
                    !this.boardGame.getTileStatus(winMatrix[i][2]).equals(""))
            {
                return 1;
            }
        }
        return 0;
    }
    public void playComputer()
    {
        int computerPosition=this.computerPlayer.playTurn(this.boardGame);
        playTile(computerPosition);
    }
}
