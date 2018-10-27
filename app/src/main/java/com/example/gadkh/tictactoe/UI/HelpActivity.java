package com.example.gadkh.tictactoe.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gadkh.tictactoe.R;

public class HelpActivity extends AppCompatActivity {

    private Button returnToMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        this.returnToMenu=(Button)findViewById(R.id.returnMenuButton);

        this.returnToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToMenu();
            }
        });
    }

    public void returnToMenu()
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
