package voxfeed.com.intersocialpost.adapters;

/**
 * Created by rjasso on 02/02/2017.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import voxfeed.com.intersocialpost.R;
import voxfeed.com.intersocialpost.model.StatsItem;

public class StatsAdapter extends RecyclerView.Adapter<StatsAdapter.ViewHolder> {
    private List<StatsItem> mDataset;

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.stat_image) ImageView statmageView;
        @BindView(R.id.stat_name) TextView statNameTextView;
        @BindView(R.id.stat_value) TextView statvalueTextView;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    public StatsAdapter(List<StatsItem> dataset) {
        mDataset = dataset;
    }

    @Override
    public StatsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.stats_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final StatsItem stat = mDataset.get(position);

        holder.statmageView.setImageResource(stat.getIcon());
        holder.statNameTextView.setText(stat.getName());
        holder.statvalueTextView.setText(String.valueOf(stat.getValue()));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}