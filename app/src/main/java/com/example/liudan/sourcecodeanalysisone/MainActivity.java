package com.example.liudan.sourcecodeanalysisone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.view.Gravity;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Sample> samples;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupToolbar();
        setupWindowAnimation();
        setupSamples();
        setupLayout();

    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setupWindowAnimation() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Slide slide = new Slide();
            slide.setDuration(1000);
            slide.setSlideEdge(Gravity.LEFT);
            getWindow().setExitTransition(slide);
            getWindow().setReenterTransition(slide);
        }
    }

    private void setupSamples() {
        samples = Arrays.asList(
                new Sample(R.color.sample_red, "Transitions"),
                new Sample(R.color.sample_blue, "Shared Elements"),
                new Sample(R.color.sample_green, "View animations"),
                new Sample(R.color.sample_yellow, "Circular Reveal Animation"),
                new Sample(R.color.sample_blue, "Shared Elements"),
                new Sample(R.color.sample_green, "View animations"),
                new Sample(R.color.sample_yellow, "Circular Reveal Animation")
        );
    }

    private void setupLayout() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SampleAdapter adapter = new SampleAdapter(this, samples);
        recyclerView.setAdapter(adapter);

    }


}
