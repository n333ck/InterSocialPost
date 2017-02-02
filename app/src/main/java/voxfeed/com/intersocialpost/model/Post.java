
package voxfeed.com.intersocialpost.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post implements Parcelable{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("socialNetwork")
    @Expose
    private String socialNetwork;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("campaign")
    @Expose
    private Campaign campaign;
    @SerializedName("brand")
    @Expose
    private Brand brand;
    @SerializedName("post")
    @Expose
    private Post_ post;
    @SerializedName("stats")
    @Expose
    private Stats stats;
    @SerializedName("earnings")
    @Expose
    private Double earnings;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSocialNetwork() {
        return socialNetwork;
    }

    public void setSocialNetwork(String socialNetwork) {
        this.socialNetwork = socialNetwork;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Post_ getPost() {
        return post;
    }

    public void setPost(Post_ post) {
        this.post = post;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public Double getEarnings() {
        return earnings;
    }

    public void setEarnings(Double earnings) {
        this.earnings = earnings;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(socialNetwork);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Post createFromParcel(Parcel in) {
            return new Post();
        }

        public Post[] newArray(int size) {
            return new Post[size];
        }
    };
}
