package com.example.gym;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class Training extends AppCompatActivity implements planDetails.PassplanInterface {

    @Override
    public void Getplan(plan plan) {
        if (utils.Addplan(plan)){
            Toast.makeText(this, "added succuessful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,AddedActicty.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }

    }
    private TextView descri, txtName;
    private Button btnAdded;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        initView();
         Intent intent =getIntent();
        if (null !=intent ){
        final Model incomingGym = intent.getParcelableExtra("key");
         if (null != incomingGym){
             txtName.setText(incomingGym.getTitle());
             descri.setText(incomingGym.getLondescr());

             Glide.with(this)
                     .asBitmap()
                     .load(incomingGym.getImageUrl())
                     .into(imageView);

             btnAdded.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     planDetails planDetails = new planDetails();
                     Bundle bundle = new Bundle();
                     bundle.putParcelable("key",incomingGym);
                     planDetails.setArguments(bundle);
                     planDetails.show(getSupportFragmentManager(),"hello world");
                 }
             });

         }
        }



    }

    private void initView() {
        descri = findViewById(R.id.des);
        txtName = findViewById(R.id.txtNameActy);
        btnAdded = findViewById(R.id.btnAddGym);
        imageView = findViewById(R.id.imageView);
    }


}
