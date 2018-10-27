package com.example.gadkh.tictactoe.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.gadkh.tictactoe.Logic.Game;
import com.example.gadkh.tictactoe.R;

public class TheGame extends AppCompatActivity {
    private Game game;
    private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_game);

        this.game=new Game();
        this.gridView=(GridView)findViewById(R.id.gridview);

        ((ProgressBar)findViewById(R.id.progressBar)).setVisibility(View.INVISIBLE);

        gridView.setAdapter(new TileAdapter(getApplicationContext(),this.game.getBoardGame()));

        this.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                game.playTile(position);
                ((TileAdapter)gridView.getAdapter()).notifyDataSetChanged();
                ((ProgressBar)findViewById(R.id.progressBar)).setVisibility(View.VISIBLE);

                Thread t=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        game.playComputer();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                Toast.makeText(getApplicationContext(),"Your Turn",Toast.LENGTH_LONG).show();
                                ((TileAdapter)gridView.getAdapter()).notifyDataSetChanged();
                                ((ProgressBar)findViewById(R.id.progressBar)).setVisibility(View.INVISIBLE);
                            }
                        });
                    }
                });
                t.start();
            }
        });
    }
}
