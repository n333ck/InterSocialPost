
package voxfeed.com.intersocialpost.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stats implements Parcelable{

    @SerializedName("clicks")
    @Expose
    private Object clicks;
    @SerializedName("shares")
    @Expose
    private Integer shares;
    @SerializedName("likes")
    @Expose
    private Integer likes;
    @SerializedName("comments")
    @Expose
    private Integer comments;
    @SerializedName("audience")
    @Expose
    private Integer audience;

    protected Stats(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Stats> CREATOR = new Creator<Stats>() {
        @Override
        public Stats createFromParcel(Parcel in) {
            return new Stats(in);
        }

        @Override
        public Stats[] newArray(int size) {
            return new Stats[size];
        }
    };

    public Object getClicks() {
        return clicks;
    }

    public void setClicks(Object clicks) {
        this.clicks = clicks;
    }

    public Integer getShares() {
        return shares;
    }

    public void setShares(Integer shares) {
        this.shares = shares;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Integer getAudience() {
        return audience;
    }

    public void setAudience(Integer audience) {
        this.audience = audience;
    }

}
