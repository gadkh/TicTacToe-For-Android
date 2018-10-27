package com.example.gadkh.tictactoe.Logic;

/**
 * Created by gadkh on 25/10/2018.
 */

public class Board {
    private Tile tilesArry[]=new Tile[9];

    public Board()
    {
        for (int i=0;i<this.tilesArry.length;i++)
        {
            this.tilesArry[i]=new Tile();
        }
    }
    public boolean setPositionTileToX(int position)
    {
        if(this.tilesArry[position].getTileStatus().equals("")) {
            this.tilesArry[position].setStatusTileToX();
            return true;
        }
        else
            return false;
    }
    public boolean setPositionTileToO(int position)
    {
        if(this.tilesArry[position].getTileStatus().equals("")) {
            this.tilesArry[position].setStatusTileToO();
            return true;
        }
        else
            return false;
    }
    public int getBoardSize()
    {
        return this.tilesArry.length;
    }
    public String getTileStatus(int position)
    {
        return this.tilesArry[position].getTileStatus();
    }
}
