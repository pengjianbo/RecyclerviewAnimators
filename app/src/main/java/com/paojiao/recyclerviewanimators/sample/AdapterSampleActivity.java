package com.paojiao.recyclerviewanimators.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.paojiao.recyclerviewanimators.FadeInAnimator;
import com.paojiao.recyclerviewanimators.adapters.AlphaInAnimationAdapter;
import com.paojiao.recyclerviewanimators.adapters.SlideInBottomAnimationAdapter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Wasabeef on 2015/01/03.
 */
public class AdapterSampleActivity extends AppCompatActivity {

    private static String[] data = new String[]{
            "Apple", "Ball", "Camera", "Day", "Egg", "Foo", "Google", "Hello", "Iron", "Japan",
            "Coke", "Dog", "Cat", "Yahoo", "Sony", "Canon", "Fujitsu", "USA", "Nexus", "LINE",
            "Haskell", "C++", "Java", "Go", "Swift", "Objective-c", "Ruby", "PHP", "Bash", "ksh",
            "C", "Groovy", "Kotlin", "Chip", "Japan", "U.S.A", "San Francisco", "Paris", "Tokyo",
            "Silicon Valley", "London", "Spain", "China", "Taiwan", "Asia", "New York", "France",
            "Kyoto", "Android", "Google", "iPhone", "iPad", "iPod", "Wasabeef"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_sample);

        RecyclerView recyclerView = (RecyclerView) findViewById(
                R.id.list);

        if (getIntent().getBooleanExtra("GRID", true)) {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        } else {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }

        recyclerView.setItemAnimator(new FadeInAnimator());
        MainAdapter adapter = new MainAdapter(this, new ArrayList<>(Arrays.asList(data)));
        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(adapter);
        SlideInBottomAnimationAdapter scaleAdapter = new SlideInBottomAnimationAdapter(alphaAdapter);
//        scaleAdapter.setFirstOnly(false);
//        scaleAdapter.setInterpolator(new OvershootInterpolator());
        recyclerView.setAdapter(scaleAdapter);
    }
}
