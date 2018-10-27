package com.example.gadkh.tictactoe.UI;

import android.content.Context;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.gadkh.tictactoe.Logic.Board;

/**
 * Created by gadkh on 25/10/2018.
 */

public class TileAdapter extends BaseAdapter {
    private Context myContext;
    private Board myBoard;

    public TileAdapter(Context context,Board board)
    {
        this.myContext=context;
        this.myBoard=board;
    }
    @Override
    public int getCount() {
        return this.myBoard.getBoardSize();
    }

    @Override
    public Object getItem(int position) {
        return this.myBoard.getTileStatus(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TileView tileView;
        if(convertView==null)
        {
            tileView=new TileView(myContext);
            tileView.setLayoutParams(new ViewGroup.LayoutParams(300,300));
            tileView.setPadding(8,8,8,8);
        }
        else
        {
            tileView=(TileView)convertView;
        }
        tileView.getTextView().setText(this.myBoard.getTileStatus(position).toString());
        if(this.myBoard.getTileStatus(position).equals(""))
        {
            tileView.setBackgroundColor(0x96353535);
        }
        else
        {
            tileView.setBackgroundColor(0x000000);
        }
        return tileView;
    }
}
