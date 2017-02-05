package voxfeed.com.intersocialpost.interactors;

import voxfeed.com.intersocialpost.model.Stats;
import voxfeed.com.intersocialpost.presenters.PostActivityPresenter;

/**
 * Created by Rafael Jasso on 2/4/17.
 */

public interface Utils {
    String calcDate(String dateStr);
    int getColor(String social);
    void getStats(Stats stats, PostActivityPresenter presenter);
    String getVerPublicacionMessage(String social);
}
