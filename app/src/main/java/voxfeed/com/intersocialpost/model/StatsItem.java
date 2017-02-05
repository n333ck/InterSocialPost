package voxfeed.com.intersocialpost.model;

/**
 * Created by Rafael Jasso on 2/4/17.
 */

public class StatsItem {
    int mIcon;
    String mName;
    int mValue;

    public StatsItem(int icon_likes, String name, int value) {
        mIcon = icon_likes;
        mName = name;
        mValue = value;
    }

    public int getValue() {
        return mValue;
    }

    public void setValue(int value) {
        this.mValue = value;
    }

    public int getIcon() {
        return mIcon;
    }

    public void setIcon(int icon) {
        this.mIcon = icon;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }
}
