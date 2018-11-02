package com.example.gadkh.tictactoe.Logic;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by gadkh on 25/10/2018.
 */

public class ComputerPlayer {
    private boolean firstTurn;
    private int [] playerBoard;
    private int [] computerBoar;
    private final  int SIZE=8;
    private int[][]winningMatrix;
    public ComputerPlayer()
    {
        this.firstTurn=true;
        this.playerBoard=new int[this.SIZE];
        this.computerBoar=new int[this.SIZE];
        this.winningMatrix=new int[][]{
                {0,1,2},
                {3,4,5},
                {6,7,8},
                {0,3,6},
                {1,4,7},
                {2,5,8},
                {0,4,8},
                {2,4,6}
        };
        for(int i=0;i<this.SIZE;i++)
        {
            this.computerBoar[i]=0;
            this.playerBoard[i]=0;
        }
    }
    public void think()
    {
       try {
            Thread.sleep(1000);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void setPlayerBoard(int position)
    {
        boolean found=false;
        for (int i=0;i<this.winningMatrix.length;i++)
        {
            found=false;
            for (int j=0;j<this.winningMatrix[i].length&&found==false;j++)
            {
                if(this.winningMatrix[i][j]==position)
                {
                    found=true;
                }
            }
            if(found==true)
            {
                this.playerBoard[i]++;
            }
        }
    }
    public void setComputerBoard(int position)
    {
        boolean found=false;
        for (int i=0;i<this.winningMatrix.length;i++)
        {
            found=false;
            for (int j=0;j<this.winningMatrix[i].length&&found==false;j++)
            {
                if(this.winningMatrix[i][j]==position)
                {
                    found=true;
                }
            }
            if(found==true)
            {
                this.computerBoar[i]++;
            }
        }
    }
    private int checkPosition(Board board,int position)
    {
        int check;
        for(int i=0;i<3;i++)
        {
          check=winningMatrix[position][i];
          if(board.getTileStatus(check).equals(""))
              return check;
        }
        return -1;

    }
    private int findComputerNextStep(Board board)
    {
        int check;
        for (int i=0;i<this.computerBoar.length;i++)
        {
            if(this.computerBoar[i]>1)
            {
                check=checkPosition(board,i);
                if(check>=0)
                    return check;
            }
        }
        for (int i=0;i<this.playerBoard.length;i++)
        {
            if(this.playerBoard[i]>1)
            {
                check=checkPosition(board,i);
                if (check>=0)
                    return check;
            }
        }
        return -1;
    }
    public int playTurn(Board board)
    {
        int chosePosition=-1;
        think();
        if(firstTurn==false) {
        chosePosition=findComputerNextStep(board);
    }
        if(this.firstTurn==true||chosePosition<0) {
            Random rnd = new Random();
            chosePosition = rnd.nextInt(9);
            while (!(board.getTileStatus(chosePosition).equals(""))) {
                chosePosition = rnd.nextInt(9);
            }
            this.firstTurn=false;
        }

            return chosePosition;
    }
}
