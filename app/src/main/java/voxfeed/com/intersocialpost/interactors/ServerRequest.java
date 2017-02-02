package voxfeed.com.intersocialpost.interactors;

import voxfeed.com.intersocialpost.presenters.PostPresenterImpl;

/**
 * Created by rjasso on 02/02/2017.
 */

public interface ServerRequest {
    void getPosts(PostPresenterImpl presenter);
}
