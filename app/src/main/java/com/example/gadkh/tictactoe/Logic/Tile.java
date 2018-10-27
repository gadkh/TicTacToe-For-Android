package com.example.gadkh.tictactoe.Logic;

/**
 * Created by gadkh on 25/10/2018.
 */

public class Tile {
    private String statusOfTile;

    public Tile()
    {
        this.statusOfTile="";
    }
    public String getTileStatus()
    {
        return this.statusOfTile;
    }
    public void setStatusTileToEmpty()
    {
        this.statusOfTile="";
    }
    public void setStatusTileToX()
    {
        this.statusOfTile="X";
    }
    public void setStatusTileToO()
    {
        this.statusOfTile="O";
    }

    @Override
    public String toString()
    {
        return statusOfTile;
    }
}
