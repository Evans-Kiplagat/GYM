package com.example.gym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public Button all,about,added;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        utils.initTrainings();
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this,allgyms.class);
                    startActivity(intent);
            }
        });
    }

    private void initView() {
        all = findViewById(R.id.btnallgym);
        about = findViewById(R.id.btnabout);
        added = findViewById(R.id.btnadd);
    }
}
