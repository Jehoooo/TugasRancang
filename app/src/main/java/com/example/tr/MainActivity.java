package com.example.tr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tr.adapter.RecentsAdapter;
import com.example.tr.adapter.TopCollectionAdapter;
import com.example.tr.model.RecentsData;
import com.example.tr.model.TopCollectionData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recentRecyler, topCollectionRecyler;
    RecentsAdapter recentsAdapter;
    TopCollectionAdapter topCollectionAdapter;
    ImageView homee, profilee, historyy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Klik icon history
        historyy = findViewById(R.id.historyy);
        historyy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,History.class));
            }
        });

        //Klik icon profil
        profilee = findViewById(R.id.profilee);
        profilee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,profile.class));
            }
        });

        //Klik icon home
        homee = findViewById(R.id.homee);
        homee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });

        //Dummy data
        List<RecentsData> recentsDataList = new ArrayList<>();
        recentsDataList.add(new RecentsData("Smoke Monkey" ,R.drawable.mone));
        recentsDataList.add(new RecentsData("Basketball Monkey" ,R.drawable.mtwo));
        recentsDataList.add(new RecentsData("Glasses Goat" ,R.drawable.sone));

        setRecentRecyler(recentsDataList);

        List<TopCollectionData> topCollectionDataList = new ArrayList<>();
        topCollectionDataList.add(new TopCollectionData("Punk Goat",R.drawable.stwo));
        topCollectionDataList.add(new TopCollectionData("Cool Monkey",R.drawable.mthree));
        topCollectionDataList.add(new TopCollectionData("Smile Monkey",R.drawable.mfour));

        setTopCollectionRecyler(topCollectionDataList);
    }

    private void setRecentRecyler(List<RecentsData> recentsDataList) {

        recentRecyler = findViewById(R.id.recent_recyler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL, false);
        recentRecyler.setLayoutManager(layoutManager);
        recentsAdapter = new RecentsAdapter(this, recentsDataList);
        recentRecyler.setAdapter(recentsAdapter);

    }

    private void setTopCollectionRecyler(List<TopCollectionData> topCollectionDataList) {

        topCollectionRecyler = findViewById(R.id.top_collection_recyler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL, false);
        topCollectionRecyler.setLayoutManager(layoutManager);
        topCollectionAdapter = new TopCollectionAdapter(this, topCollectionDataList);
        topCollectionRecyler.setAdapter(topCollectionAdapter);

    }

}