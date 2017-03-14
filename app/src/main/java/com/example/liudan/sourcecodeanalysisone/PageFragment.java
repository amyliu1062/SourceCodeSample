package com.example.liudan.sourcecodeanalysisone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

/**
 * Created by liudan on 2017/3/14.
 */

public class PageFragment extends Fragment {

    private static final String ARG_PAGE = "ARG_PAGE";

    private List<Sample> samples;

    public static PageFragment newInstance(int page) {
        PageFragment pageFragment = new PageFragment();
        return pageFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupSamples();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_temple, container, false);
        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        SampleAdapter adapter = new SampleAdapter(getActivity(), samples);
        recyclerView.setAdapter(adapter);

        return root;
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

}
