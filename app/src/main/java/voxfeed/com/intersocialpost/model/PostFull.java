
package voxfeed.com.intersocialpost.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostFull implements Parcelable{

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
    private Post post;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
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

    private PostFull(Parcel in) {
        id = in.readString();
        date = in.readString();
        socialNetwork = in.readString();
        user = in.readParcelable(User.class.getClassLoader());
        campaign = in.readParcelable(Campaign.class.getClassLoader());
        brand = in.readParcelable(Brand.class.getClassLoader());
        post = in.readParcelable(Post.class.getClassLoader());
        stats = in.readParcelable(Stats.class.getClassLoader());
        earnings = in.readDouble();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(date);
        dest.writeString(socialNetwork);
        dest.writeParcelable(user, flags);
        dest.writeParcelable(campaign, flags);
        dest.writeParcelable(brand, flags);
        dest.writeParcelable(post, flags);
        dest.writeParcelable(stats, flags);
        dest.writeDouble(earnings);
    }

    public static final Parcelable.Creator<PostFull> CREATOR = new Parcelable.Creator<PostFull>() {
        public PostFull createFromParcel(Parcel in) {
            return new PostFull(in);
        }

        public PostFull[] newArray(int size) {
            return new PostFull[size];
        }
    };
}
