package voxfeed.com.intersocialpost.adapters;

/**
 * Created by rjasso on 02/02/2017.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import voxfeed.com.intersocialpost.R;
import voxfeed.com.intersocialpost.model.Post;
import voxfeed.com.intersocialpost.presenters.PostPresenter;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private List<Post> mDataset;
    private PostPresenter mPostPresenter;

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_textview)
        public TextView textItem;

        public ViewHolder(View v) {
            super(v);
            textItem = (TextView) v.findViewById(R.id.item_textview);
        }
    }

    public PostAdapter(List<Post> dataset, PostPresenter presenter) {
        mDataset = dataset;
        mPostPresenter = presenter;
    }

    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Post post = mDataset.get(position);
        holder.textItem.setText("Item: " + post.getPost().getText());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPostPresenter.startPostActivity(post);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}