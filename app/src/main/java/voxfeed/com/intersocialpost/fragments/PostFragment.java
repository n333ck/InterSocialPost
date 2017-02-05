package voxfeed.com.intersocialpost.fragments;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import voxfeed.com.intersocialpost.R;
import voxfeed.com.intersocialpost.activities.PostActivity;
import voxfeed.com.intersocialpost.adapters.PostAdapter;
import voxfeed.com.intersocialpost.model.PostFull;
import voxfeed.com.intersocialpost.presenters.PostFragmentPresenter;
import voxfeed.com.intersocialpost.presenters.PostFragmentPresenterImpl;
import voxfeed.com.intersocialpost.presenters.PostView;

/**
 * Created by rjasso on 02/02/2017.
 */

public class PostFragment extends Fragment implements PostView{
    private PostAdapter mAdapter;
    private PostFragmentPresenter mPostPresenter;

    @BindView(R.id.post_recycler_view)
    RecyclerView mRecyclerView;

    public PostFragment() {
    }

    public static PostFragment newInstance() {
        return new PostFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_post, container, false);
        ButterKnife.bind(this, rootView);

        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(), linearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);

        mPostPresenter = new PostFragmentPresenterImpl(this);
        mPostPresenter.loadPosts();
        return rootView;
    }

    @Override
    public void updatePosts(List<PostFull> post) {
        mAdapter = new PostAdapter(post, mPostPresenter);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showFailureMessage() {
        Toast.makeText(getActivity(), R.string.failure_message, Toast.LENGTH_LONG).show();
        getActivity().finish();
    }

    @Override
    public void startPostActivity(PostFull post) {
        Intent intent = new Intent(getActivity(), PostActivity.class);
        intent.putExtra(getString(R.string.post_bundle), post);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getActivity().startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());
        } else {
            getActivity().startActivity(intent);
        }
    }
}
