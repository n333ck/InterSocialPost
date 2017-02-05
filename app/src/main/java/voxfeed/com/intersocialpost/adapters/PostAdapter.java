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

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import voxfeed.com.intersocialpost.R;
import voxfeed.com.intersocialpost.model.PostFull;
import voxfeed.com.intersocialpost.presenters.PostFragmentPresenter;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private List<PostFull> mDataset;
    private PostFragmentPresenter mPostPresenter;

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_textview) TextView textItem;
        @BindView(R.id.post_image) ImageView postImageView;
        @BindView(R.id.user_image ) ImageView userImageView;
        @BindView(R.id.user_name) TextView userNameTextView;
        @BindView(R.id.user_social_network) TextView socialTextView;
        @BindView(R.id.post_date) TextView dateTextView;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    public PostAdapter(List<PostFull> dataset, PostFragmentPresenter presenter) {
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

        final PostFull post = mDataset.get(position);

        holder.textItem.setText(post.getPost().getText());
        Picasso.with(mPostPresenter.getView().getActivity()).load(post.getPost().getImage()).into(holder.postImageView);
        Picasso.with(mPostPresenter.getView().getActivity()).load(post.getUser().getProfileImage()).into(holder.userImageView);
        holder.userNameTextView.setText(post.getUser().getUsername());
        holder.socialTextView.setText(post.getSocialNetwork().substring(0, 1).toUpperCase() + post.getSocialNetwork().substring(1));
        holder.socialTextView.setTextColor(mPostPresenter.getSocialColor(post.getSocialNetwork()));
        holder.dateTextView.setText(mPostPresenter.getDate(post.getDate()));

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