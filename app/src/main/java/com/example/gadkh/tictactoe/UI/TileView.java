package com.example.gadkh.tictactoe.UI;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by gadkh on 25/10/2018.
 */

public class TileView extends LinearLayout {
    private TextView textView;
    public TileView(Context context) {
        super(context);

        this.setOrientation(VERTICAL);

        this.textView=new TextView(context);

        LayoutParams layoutParams=new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);

        this.textView.setLayoutParams(layoutParams);
        this.textView.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        this.textView.setGravity(Gravity.CENTER_VERTICAL);
        this.textView.setTextSize(50);
       // this.textView.setTextColor(Color.BLACK);
        this.textView.setTextColor(Color.WHITE);

        this.setBackgroundColor(Color.LTGRAY);
        this.addView(this.textView);

    }
    public TextView getTextView() {
        return textView;
    }

}
