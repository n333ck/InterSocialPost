package voxfeed.com.intersocialpost.presenters;

import java.util.List;
import voxfeed.com.intersocialpost.model.Post;

/**
 * Created by rjasso on 02/02/2017.
 */

public interface PostView {
    void updatePosts(List<Post> post);
    void showFailureMessage();
    void startPostActivity(Post post);
}
