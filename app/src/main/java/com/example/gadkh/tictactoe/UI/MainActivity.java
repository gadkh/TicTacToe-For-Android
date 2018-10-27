package com.example.gadkh.tictactoe.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gadkh.tictactoe.R;

public class MainActivity extends AppCompatActivity {

    private Button startButton;
    private Button helpButton;
    private Button winnigButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.startButton=(Button)findViewById(R.id.startButton);
        this.helpButton=(Button)findViewById(R.id.helpButton);
        this.winnigButton=(Button)findViewById(R.id.recordButton);

        this.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStartGameActivity();
            }
        });

        this.helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHelperActivity();
            }
        });
    }

    public void openStartGameActivity()
    {
        Intent intent=new Intent(this,TheGame.class);
        startActivity(intent);
    }

    public void openHelperActivity()
    {
        Intent intent=new Intent(this,HelpActivity.class);
        startActivity(intent);
    }
}
