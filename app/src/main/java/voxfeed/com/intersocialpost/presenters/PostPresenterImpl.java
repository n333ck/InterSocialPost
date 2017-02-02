package voxfeed.com.intersocialpost.presenters;

import java.util.List;

import voxfeed.com.intersocialpost.interactors.ServerRequest;
import voxfeed.com.intersocialpost.interactors.ServerRequestImpl;
import voxfeed.com.intersocialpost.model.Post;

/**
 * Created by rjasso on 02/02/2017.
 */

public class PostPresenterImpl implements PostPresenter{

    private final PostView mView;
    private ServerRequest mServerRequest;

    public PostPresenterImpl(PostView view) {
        mView = view;
        mServerRequest = new ServerRequestImpl();
    }

    @Override
    public void updatePost(List<Post> posts) {
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
    public void startPostActivity(Post post) {
        mView.startPostActivity(post);
    }
}
