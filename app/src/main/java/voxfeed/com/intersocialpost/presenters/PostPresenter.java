package voxfeed.com.intersocialpost.presenters;

import java.util.List;

import voxfeed.com.intersocialpost.model.Post;

/**
 * Created by rjasso on 02/02/2017.
 */

public interface PostPresenter {
    void updatePost(List<Post> posts);
    void loadPosts();
    void showFailureMessage();
    void startPostActivity(Post post);
}
