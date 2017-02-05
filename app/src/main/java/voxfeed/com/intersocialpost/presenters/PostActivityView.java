package voxfeed.com.intersocialpost.presenters;

import java.util.List;

import voxfeed.com.intersocialpost.model.StatsItem;

/**
 * Created by Rafael Jasso on 2/4/17.
 */

public interface PostActivityView {
    void updatePosts(List<StatsItem> stats);
    void updateTextVerPublicacion(String text, int color);
    void openBrowser(String url);
}
