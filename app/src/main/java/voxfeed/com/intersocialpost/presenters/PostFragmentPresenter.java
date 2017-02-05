package voxfeed.com.intersocialpost.presenters;

import android.support.v4.app.Fragment;

import java.util.List;

import voxfeed.com.intersocialpost.model.PostFull;

/**
 * Created by rjasso on 02/02/2017.
 */

public interface PostFragmentPresenter {
    void updatePost(List<PostFull> posts);
    void loadPosts();
    void showFailureMessage();
    void startPostActivity(PostFull post);
    Fragment getView();
    int getSocialColor(String color);
    String getDate(String date);
}
