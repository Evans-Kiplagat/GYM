package com.example.gym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class allgyms extends AppCompatActivity {
    public RecyclerView recyclerView;
   private Adpater mAdpater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allgyms);
        recyclerView =findViewById(R.id.Recycler);
        mAdpater =new Adpater(this);

        recyclerView.setAdapter(mAdpater);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        ArrayList<Model> alltrainings = utils.getTrainings();
        if (null != alltrainings){
            mAdpater.setStored(alltrainings);
        }


    }
}
