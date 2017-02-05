package voxfeed.com.intersocialpost.presenters;

import android.support.v4.app.Fragment;

import java.util.List;

import voxfeed.com.intersocialpost.interactors.ServerRequest;
import voxfeed.com.intersocialpost.interactors.ServerRequestImpl;
import voxfeed.com.intersocialpost.interactors.Utils;
import voxfeed.com.intersocialpost.interactors.UtilsImpl;
import voxfeed.com.intersocialpost.model.PostFull;

/**
 * Created by rjasso on 02/02/2017.
 */

public class PostFragmentPresenterImpl implements PostFragmentPresenter {

    private final PostView mView;
    private ServerRequest mServerRequest;
    private Utils mUtils;

    public PostFragmentPresenterImpl(PostView view) {
        mView = view;
        mServerRequest = new ServerRequestImpl();
        mUtils = new UtilsImpl();
    }

    @Override
    public void updatePost(List<PostFull> posts) {
        mView.updatePosts(posts);
    }

    @Override
    public void loadPosts() {
        mServerRequest.getPosts(this);
    }

    @Override
    public void showFailureMessage() {
        mView.showFailureMessage();
    }

    @Override
    public void startPostActivity(PostFull post) {
        mView.startPostActivity(post);
    }

    @Override
    public Fragment getView() {
        return (Fragment) mView;
    }

    @Override
    public int getSocialColor(String color) {
        return mUtils.getColor(color);
    }

    @Override
    public String getDate(String date) {
        return mUtils.calcDate(date);
    }
}
