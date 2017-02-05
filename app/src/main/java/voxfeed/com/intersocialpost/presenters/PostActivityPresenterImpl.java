package voxfeed.com.intersocialpost.presenters;

import java.util.List;

import voxfeed.com.intersocialpost.activities.PostActivity;
import voxfeed.com.intersocialpost.interactors.UtilsImpl;
import voxfeed.com.intersocialpost.model.Stats;
import voxfeed.com.intersocialpost.model.StatsItem;

/**
 * Created by Rafael Jasso on 2/4/17.
 */

public class PostActivityPresenterImpl implements PostActivityPresenter {
    private final PostActivity mView;
    private final UtilsImpl mUtils;

    public PostActivityPresenterImpl (PostActivity view) {
        mView = view;
        mUtils = new UtilsImpl();
    }

    @Override
    public void setAdapter(List<StatsItem> statsItems) {
        mView.updatePosts(statsItems);
    }

    @Override
    public void loadPosts(Stats item) {
        mUtils.getStats(item, this);
    }

    @Override
    public void getSocialColor(String social) {
        mView.updateTextVerPublicacion(mUtils.getVerPublicacionMessage(social), mUtils.getColor(social));
    }

    @Override
    public void openBrowser(String link) {
        mView.openBrowser(link);
    }
}
