
package voxfeed.com.intersocialpost.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Campaign implements Parcelable{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("coverImage")
    @Expose
    private String coverImage;

    protected Campaign(Parcel in) {
        name = in.readString();
        coverImage = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(coverImage);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Campaign> CREATOR = new Creator<Campaign>() {
        @Override
        public Campaign createFromParcel(Parcel in) {
            return new Campaign(in);
        }

        @Override
        public Campaign[] newArray(int size) {
            return new Campaign[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

}
