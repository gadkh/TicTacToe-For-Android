package com.example.gadkh.tictactoe.Logic;

import java.util.Random;

/**
 * Created by gadkh on 25/10/2018.
 */

public class ComputerPlayer {
    public void think()
    {
       try {
            Thread.sleep(5000);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public int playTurn(Board board)
    {
        int chosePosition;
        think();

        Random rnd =new Random();

        chosePosition=rnd.nextInt(9);

       while (!(board.getTileStatus(chosePosition).equals("")))
        {
            chosePosition=rnd.nextInt(9);
        }
        return chosePosition;
    }
}
