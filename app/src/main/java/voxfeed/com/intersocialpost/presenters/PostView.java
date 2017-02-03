package voxfeed.com.intersocialpost.presenters;

import java.util.List;
import voxfeed.com.intersocialpost.model.PostFull;

/**
 * Created by rjasso on 02/02/2017.
 */

public interface PostView {
    void updatePosts(List<PostFull> post);
    void showFailureMessage();
    void startPostActivity(PostFull post);
}
