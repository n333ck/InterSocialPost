package voxfeed.com.intersocialpost.presenters;

import java.util.List;

import voxfeed.com.intersocialpost.model.PostFull;

/**
 * Created by rjasso on 02/02/2017.
 */

public interface PostPresenter {
    void updatePost(List<PostFull> posts);
    void loadPosts();
    void showFailureMessage();
    void startPostActivity(PostFull post);
}
