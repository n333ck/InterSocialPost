
package voxfeed.com.intersocialpost.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Brand implements Parcelable{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("logo")
    @Expose
    private String logo;

    protected Brand(Parcel in) {
        name = in.readString();
        logo = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(logo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Brand> CREATOR = new Creator<Brand>() {
        @Override
        public Brand createFromParcel(Parcel in) {
            return new Brand(in);
        }

        @Override
        public Brand[] newArray(int size) {
            return new Brand[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

}
