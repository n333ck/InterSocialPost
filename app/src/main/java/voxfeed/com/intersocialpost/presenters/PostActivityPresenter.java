package voxfeed.com.intersocialpost.presenters;

import java.util.List;

import voxfeed.com.intersocialpost.model.Stats;
import voxfeed.com.intersocialpost.model.StatsItem;

/**
 * Created by Rafael Jasso on 2/4/17.
 */

public interface PostActivityPresenter {
    void setAdapter(List<StatsItem> statsItems);
    void loadPosts(Stats stats);
    void getSocialColor(String social);
    void openBrowser(String link);
}
