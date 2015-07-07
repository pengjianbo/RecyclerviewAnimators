package com.paojiao.recyclerviewanimators.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.paojiao.recyclerviewanimators.BaseItemAnimator;
import com.paojiao.recyclerviewanimators.FadeInAnimator;
import com.paojiao.recyclerviewanimators.FadeInDownAnimator;
import com.paojiao.recyclerviewanimators.FadeInLeftAnimator;
import com.paojiao.recyclerviewanimators.FadeInRightAnimator;
import com.paojiao.recyclerviewanimators.FadeInUpAnimator;
import com.paojiao.recyclerviewanimators.FlipInBottomXAnimator;
import com.paojiao.recyclerviewanimators.FlipInLeftYAnimator;
import com.paojiao.recyclerviewanimators.FlipInRightYAnimator;
import com.paojiao.recyclerviewanimators.FlipInTopXAnimator;
import com.paojiao.recyclerviewanimators.LandingAnimator;
import com.paojiao.recyclerviewanimators.OvershootInLeftAnimator;
import com.paojiao.recyclerviewanimators.OvershootInRightAnimator;
import com.paojiao.recyclerviewanimators.ScaleInAnimator;
import com.paojiao.recyclerviewanimators.ScaleInBottomAnimator;
import com.paojiao.recyclerviewanimators.ScaleInLeftAnimator;
import com.paojiao.recyclerviewanimators.ScaleInRightAnimator;
import com.paojiao.recyclerviewanimators.ScaleInTopAnimator;
import com.paojiao.recyclerviewanimators.SlideInDownAnimator;
import com.paojiao.recyclerviewanimators.SlideInLeftAnimator;
import com.paojiao.recyclerviewanimators.SlideInRightAnimator;
import com.paojiao.recyclerviewanimators.SlideInUpAnimator;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by Wasabeef on 2015/01/03.
 */
public class AnimatorSampleActivity extends AppCompatActivity {

    enum Type {
        FadeIn(new FadeInAnimator()),
        FadeInDown(new FadeInDownAnimator()),
        FadeInUp(new FadeInUpAnimator()),
        FadeInLeft(new FadeInLeftAnimator()),
        FadeInRight(new FadeInRightAnimator()),
        Landing(new LandingAnimator()),
        ScaleIn(new ScaleInAnimator()),
        ScaleInTop(new ScaleInTopAnimator()),
        ScaleInBottom(new ScaleInBottomAnimator()),
        ScaleInLeft(new ScaleInLeftAnimator()),
        ScaleInRight(new ScaleInRightAnimator()),
        FlipInTopX(new FlipInTopXAnimator()),
        FlipInBottomX(new FlipInBottomXAnimator()),
        FlipInLeftY(new FlipInLeftYAnimator()),
        FlipInRightY(new FlipInRightYAnimator()),
        SlideInLeft(new SlideInLeftAnimator()),
        SlideInRight(new SlideInRightAnimator()),
        SlideInDown(new SlideInDownAnimator()),
        SlideInUp(new SlideInUpAnimator()),
        OvershootInRight(new OvershootInRightAnimator()),
        OvershootInLeft(new OvershootInLeftAnimator());

        private BaseItemAnimator mAnimator;

        Type(BaseItemAnimator animator) {
            mAnimator = animator;
        }

        public BaseItemAnimator getAnimator() {
            return mAnimator;
        }
    }

    private static String[] data = new String[]{
            "Apple", "Ball", "Camera", "Day", "Egg", "Foo", "Google", "Hello", "Iron", "Japan",
            "Coke", "Dog", "Cat", "Yahoo", "Sony", "Canon", "Fujitsu", "USA", "Nexus", "LINE",
            "Haskell", "C++", "Java", "Go", "Swift", "Objective-c", "Ruby", "PHP", "Bash", "ksh",
            "C", "Groovy", "Kotlin"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_sample);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        final RecyclerView recyclerView = (RecyclerView) findViewById(
                R.id.list);

        if (getIntent().getBooleanExtra("GRID", true)) {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        } else {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }

        recyclerView.setItemAnimator(new FadeInAnimator());
        final MainAdapter adapter = new MainAdapter(this, new ArrayList<>(Arrays.asList(data)));
        recyclerView.setAdapter(adapter);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> spinnerAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        for (Type type : Type.values()) {
            spinnerAdapter.add(type.name());
        }
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                recyclerView.setItemAnimator(Type.values()[position].getAnimator());
                recyclerView.getItemAnimator().setAddDuration(300);
                recyclerView.getItemAnimator().setRemoveDuration(300);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.add("newly added item", 1);
            }
        });

        findViewById(R.id.del).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.remove(1);
            }
        });
    }
}
