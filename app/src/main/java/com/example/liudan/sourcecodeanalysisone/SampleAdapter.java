package com.example.liudan.sourcecodeanalysisone;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liudan.sourcecodeanalysisone.databinding.RowSampleBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liudan on 2017/3/10.
 */

public class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.SampleViewHold> {

    private List<Sample> samples = new ArrayList<>();
    private Activity activity;
    private LayoutInflater inflater;

    public SampleAdapter(Activity activity) {
        this.activity = activity;
        inflater = LayoutInflater.from(activity);
    }

    public SampleAdapter(Activity activity, List<Sample> samples) {
        this(activity);
        setSamples(samples);
    }

    public void setSamples(List<Sample> samples) {
        this.samples.clear();
        if (samples != null && samples.size() > 0) {
            this.samples.addAll(samples);
        }
        notifyDataSetChanged();
    }

    @Override
    public SampleViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
        RowSampleBinding binding = DataBindingUtil.inflate(inflater, R.layout.row_sample, parent, false);
        return new SampleViewHold(binding.getRoot());

    }

    @Override
    public void onBindViewHolder(final SampleViewHold holder, final int position) {
        final Sample sample = samples.get(holder.getAdapterPosition());
        holder.binding.setSample(sample);
        holder.binding.layoutSample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (holder.getAdapterPosition()) {
                    case 0:
                        toTransitionActivity(TransitionActivity.class, sample);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void toTransitionActivity(Class target, Sample sample) {
        Pair<View, String>[] pairs = TransitionHelper.createSafeTransitionParticipants(activity, true);
        startActivity(target, pairs, sample);
    }

    private void startActivity(Class target, Pair<View, String>[] pairs, Sample sample) {
        Intent i = new Intent(activity, target);
        ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, pairs);
        i.putExtra("sample", sample);
        activity.startActivity(i, transitionActivityOptions.toBundle());
    }

    @Override
    public int getItemCount() {
        return samples.size();
    }

    class SampleViewHold extends RecyclerView.ViewHolder {

        private RowSampleBinding binding;

        public SampleViewHold(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }


}
